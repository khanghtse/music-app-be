package com.example.music_app.repositories;

import com.example.music_app.documents.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAlbumRepository extends MongoRepository<Album, String> {
}
