package com.stackroute.musicxapplication.controller;

import com.stackroute.musicxapplication.domain.Music;
import com.stackroute.musicxapplication.exceptions.TrackAlreadyExitsException;
import com.stackroute.musicxapplication.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class MusicController {

    private MusicServiceImpl musicServiceImpl;

    @Autowired
    public MusicController(MusicServiceImpl musicServiceImpl) {
        this.musicServiceImpl = musicServiceImpl;
    }

    @PostMapping("/music")
    public ResponseEntity<Music> saveTrack(@Valid @RequestBody Music music) throws TrackAlreadyExitsException {
        ResponseEntity responseEntity;
        musicServiceImpl.saveTrack(music);
        responseEntity = new ResponseEntity<String>("Successfully CREATED", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/musics")
    public ResponseEntity<List<Music>> displayTracks() {
        List<Music> musicList = musicServiceImpl.displayAllTracks();
        return new ResponseEntity<>(musicList, HttpStatus.OK);
    }

    @PutMapping("/musics/{id}")
    public ResponseEntity<Music> updateTrack(@Valid @RequestBody Music music, @PathVariable int id) {
        Music updatedTrack = musicServiceImpl.updateTrack(music, id);
        return new ResponseEntity<Music>(updatedTrack, HttpStatus.OK);
    }

    @DeleteMapping("/musics/{id}")
    public ResponseEntity<Music> deleteTrack(@PathVariable int id) {
        musicServiceImpl.deleteTrack(id);
        return new ResponseEntity<Music>(HttpStatus.OK);
    }


//    @GetMapping("/musics/{name}")
//    public ResponseEntity<?> displayTracksByName(@PathVariable String name) throws Exception {
//        ResponseEntity responseEntity;
//        List<Music> musicList = musicServiceImpl.displayTracksByName(name);
//        responseEntity = new ResponseEntity<List>(musicList, HttpStatus.OK);
//        return responseEntity;
//
//    }
}
