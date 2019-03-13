package com.stackroute.musicxapplication.StartUpLogic;

import com.stackroute.musicxapplication.domain.Music;
import com.stackroute.musicxapplication.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerImpl implements ApplicationListener<ContextRefreshedEvent> {
    private MusicRepository musicRepository;

    @Value("${name}")
    String trackname;

    @Value("${comment}")
    String trackComments;
    public ApplicationListenerImpl() {
    }

    @Autowired
    public ApplicationListenerImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        musicRepository.save(new Music(1, trackname, trackComments));
    }
}
