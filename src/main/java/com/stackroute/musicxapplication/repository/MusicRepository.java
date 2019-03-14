package com.stackroute.musicxapplication.repository;

import com.stackroute.musicxapplication.domain.Music;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends MongoRepository<Music,Integer> {

//    @Query(value = "Select m from Music m  where m.trackName = ?1")
//    List<Music> trackByName(String trackName);
//
//    @Query(value = "Select count(m) from Music m  where m.trackName = ?1")
//    int searchTrackByName(String trackName);

}
