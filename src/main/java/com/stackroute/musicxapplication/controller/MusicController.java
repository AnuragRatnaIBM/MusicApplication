package com.stackroute.musicxapplication.controller;

import com.stackroute.musicxapplication.domain.Music;
import com.stackroute.musicxapplication.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class MusicController {

    private MusicService musicService;
    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }
    @PostMapping("/track")
    public ResponseEntity<Music> saveTrack(@RequestBody Music music)
    {
        Music musicList=musicService.saveTrack(music);
        return new ResponseEntity<Music>(musicList,HttpStatus.OK);
    }
    @GetMapping("/tracks")
    public ResponseEntity<List<Music>> displayTracks()
    {
       List<Music>musicList= musicService.displayAllTracks();
       return new ResponseEntity<>(musicList,HttpStatus.OK);
    }
    @PutMapping("/tracks/{id}")
    public ResponseEntity<Music> updateTrack(@RequestBody Music music,@PathVariable int id)
    {
        Music updatedTrack=musicService.updateTrack(music,id);
        return new ResponseEntity<Music>(updatedTrack,HttpStatus.OK);
    }
    @DeleteMapping("/tracks/{id}")
    public ResponseEntity<Music> deleteTrack(@PathVariable int id)
    {
        musicService.deleteTrack(id);
        return new ResponseEntity<Music>(HttpStatus.OK);
    }
}
