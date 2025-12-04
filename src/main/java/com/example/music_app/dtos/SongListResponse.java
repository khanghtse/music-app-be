package com.example.music_app.dtos;

import com.example.music_app.documents.Song;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongListResponse {

    private Boolean success;
    private List<Song> songs;
}
