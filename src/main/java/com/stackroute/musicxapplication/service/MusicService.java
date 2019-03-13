package com.stackroute.musicxapplication.service;

import com.stackroute.musicxapplication.domain.Music;
import com.stackroute.musicxapplication.exceptions.TrackAlreadyExitsException;
import com.stackroute.musicxapplication.exceptions.TrackNotFoundException;
import com.stackroute.musicxapplication.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MusicService implements ApplicationListener<ContextRefreshedEvent>,CommandLineRunner {
    private MusicRepository musicRepository;
    @Autowired
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public Music saveTrack(Music music) throws TrackAlreadyExitsException {
        if(musicRepository.existsById(music.getTrackId()))
        {
            throw new TrackAlreadyExitsException("Track Already Exist ");
        }
        Music savedMusic=musicRepository.save(music);
        if (savedMusic.getTrackName()==null)
        {
            throw new TrackAlreadyExitsException("Track Already Exist ");
        }
        return savedMusic;
    }

    public List<Music> displayAllTracks() {
        return (List<Music>) musicRepository.findAll();
    }

    public Music updateTrack(Music newMusic,int id) {
        Music oldTrack= musicRepository.findById(id).get();
        oldTrack.setTrackComments(newMusic.getTrackComments());
        return musicRepository.save(oldTrack);

    }

    public void deleteTrack(int id) {
        musicRepository.deleteById(id);
    }

    public List<Music> displayTracksByName(String name) throws TrackNotFoundException{
        if(musicRepository.searchTrackByName(name)==0)
        {
            throw new TrackNotFoundException("Track not found");
        }
        else
        {
            return musicRepository.trackByName(name);
        }

    }
    @Value("${name}")
    String trackname;

    @Value("${comment}")
    String trackComments;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        musicRepository.save(new Music(1,trackname,trackComments));
    }

    @Override
    public void run(String... args) throws Exception {
        musicRepository.save(new Music(1,"ahshjsa","hsasad"));
    }


}
