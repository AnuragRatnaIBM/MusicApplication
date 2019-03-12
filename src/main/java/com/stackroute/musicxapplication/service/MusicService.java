package com.stackroute.musicxapplication.service;

import com.stackroute.musicxapplication.domain.Music;
import com.stackroute.musicxapplication.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MusicService {
    private MusicRepository musicRepository;
    @Autowired
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public Music saveTrack(Music music) {
        return musicRepository.save(music);
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
}
