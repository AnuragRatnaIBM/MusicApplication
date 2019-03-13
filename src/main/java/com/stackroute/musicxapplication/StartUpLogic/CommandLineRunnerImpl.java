package com.stackroute.musicxapplication.StartUpLogic;

import com.stackroute.musicxapplication.domain.Music;
import com.stackroute.musicxapplication.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

public class CommandLineRunnerImpl implements CommandLineRunner {
    private MusicRepository musicRepository;
    @Value("${name}")
    String trackname;

    @Value("${comment}")
    String trackComments;
    public CommandLineRunnerImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        musicRepository.save(new Music(1,trackname,trackComments));

    }
}
