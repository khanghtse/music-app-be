package com.example.music_app.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.music_app.documents.Song;
import com.example.music_app.dtos.SongListResponse;
import com.example.music_app.dtos.SongRequest;
import com.example.music_app.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final Cloudinary cloudinary;

    public Song addSong(SongRequest request) throws IOException {
        Map<String, Object> audioUploadResult = cloudinary.uploader().upload(request.getAudioFile().getBytes(), ObjectUtils.asMap("resource_type", "video"));
        Map<String, Object> imageUploadResult = cloudinary.uploader().upload(request.getImageFile().getBytes(), ObjectUtils.asMap("resource_type", "image"));

        Double durationSeconds = (Double)audioUploadResult.get("duration");
        String duration = formatDuration(durationSeconds);

        Song newSong = Song.builder()
                .name(request.getName())
                .desc(request.getDesc())
                .album(request.getAlbum())
                .image(imageUploadResult.get("secure_url").toString())
                .file(audioUploadResult.get("secure_url").toString())
                .duration(duration)
                .build();
        return songRepository.save(newSong);

    }

    public SongListResponse getAllSongs() {
        return new SongListResponse(true, songRepository.findAll());
    }

    public Boolean removeSong(String id) {
        Song existingSong = songRepository.findById(id).orElseThrow(() -> new RuntimeException("Song not found"));
        songRepository.delete(existingSong);
        return true;
    }

    private String formatDuration(Double durationSeconds) {
        if (durationSeconds == null) {
            return "0:00";
        }

        int minutes = (int)(durationSeconds / 60);
        int seconds = (int)(durationSeconds % 60);
        return String.format("%d:%02d", minutes, seconds);
    }

}
