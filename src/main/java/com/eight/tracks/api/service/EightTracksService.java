package com.eight.tracks.api.service;

import com.eight.tracks.api.model.PopularTarcks;
import com.eight.tracks.api.model.PopularTracksResponse;
import com.eight.tracks.api.model.TrackMetadata;
import com.eight.tracks.api.model.TracksByArtist;
import com.eight.tracks.api.model.TracksByGenre;
import com.eight.tracks.api.model.TracksByMood;
import com.eight.tracks.api.model.TracksByTag;

import java.util.List;

public interface EightTracksService {

  List<TracksByGenre> getTracksByGenre(List<String> genreList);

  List<TracksByMood> getTracksByMood(List<String> moodList);

  List<TracksByArtist> getTracksByArtist(List<String> artistList);

  PopularTracksResponse getPopularTracksOnLanding();

  List<TracksByTag> getTracksByTags(List<String> tags);

  void updateTrackMetadata(TrackMetadata trackMetadata);

  TrackMetadata getTrackDetails(String trackId);

  void deleteTrack(String Id);


}
