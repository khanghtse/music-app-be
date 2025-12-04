package com.example.music_app.repositories;

import com.example.music_app.documents.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {
}
