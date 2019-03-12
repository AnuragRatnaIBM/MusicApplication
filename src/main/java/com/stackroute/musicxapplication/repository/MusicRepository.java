package com.stackroute.musicxapplication.repository;

import com.stackroute.musicxapplication.domain.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends CrudRepository<Music,Integer> {

}
