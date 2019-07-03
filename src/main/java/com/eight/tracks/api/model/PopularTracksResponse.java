package com.eight.tracks.api.model;

import lombok.Data;

import java.util.List;

@Data
public class PopularTracksResponse {

  List<PopularTarcks> popularTarcksList;
  List<String> tagsList;
  List<String> genreList;
  List<String> moodList;
  List<String> artistList;
}
