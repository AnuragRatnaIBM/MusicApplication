package com.stackroute.musicxapplication.service;

import com.stackroute.musicxapplication.domain.Music;

import java.util.List;

public interface MusicService {
    Music saveTrack(Music music) throws Exception;

    List<Music> displayAllTracks();

    Music updateTrack(Music newMusic, int id);

    void deleteTrack(int id);
//
//    List<Music> displayTracksByName(String name) throws Exception;
}
