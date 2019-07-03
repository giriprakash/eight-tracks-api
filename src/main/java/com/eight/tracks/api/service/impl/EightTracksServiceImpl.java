package com.eight.tracks.api.service.impl;

import com.eight.tracks.api.model.PopularTarcks;
import com.eight.tracks.api.model.PopularTracksResponse;
import com.eight.tracks.api.model.TrackMetadata;
import com.eight.tracks.api.model.TracksByArtist;
import com.eight.tracks.api.model.TracksByGenre;
import com.eight.tracks.api.model.TracksByMood;
import com.eight.tracks.api.model.TracksByTag;
import com.eight.tracks.api.repository.PopularTrackRepository;
import com.eight.tracks.api.repository.TrackRepository;
import com.eight.tracks.api.repository.TracksByArtistRepository;
import com.eight.tracks.api.repository.TracksByGenreRepository;
import com.eight.tracks.api.repository.TracksByMoodRepository;
import com.eight.tracks.api.repository.TracksByTagRepository;
import com.eight.tracks.api.service.EightTracksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EightTracksServiceImpl implements EightTracksService {

  @Autowired
  PopularTrackRepository popularTrackRepository;

  @Autowired
  TrackRepository trackRepository;

  @Autowired
  TracksByArtistRepository tracksByArtistRepository;

  @Autowired
  TracksByGenreRepository tracksByGenreRepository;

  @Autowired
  TracksByMoodRepository tracksByMoodRepository;

  @Autowired
  TracksByTagRepository tracksByTagRepository;

  @Override
  public List<TracksByGenre> getTracksByGenre(List<String> genreList) {
    List<TracksByGenre> tracksByGenres = new ArrayList<>();
    genreList.forEach(genre ->{
      tracksByGenres.add(tracksByGenreRepository.findById(genre).get());
    });
    return tracksByGenres;
  }

  @Override
  public List<TracksByMood> getTracksByMood(List<String> moodList) {
    List<TracksByMood> tracksByMood = new ArrayList<>();
    moodList.forEach(genre ->{
      tracksByMood.add(tracksByMoodRepository.findById(genre).get());
    });
    return tracksByMood;
  }

  @Override
  public List<TracksByArtist> getTracksByArtist(List<String> artistList) {
    List<TracksByArtist> tracksByArtists = new ArrayList<>();
    artistList.forEach(genre ->{
      tracksByArtists.add(tracksByArtistRepository.findById(genre).get());
    });
    return tracksByArtists;
  }

  @Override
  public PopularTracksResponse getPopularTracksOnLanding() {
    PopularTracksResponse popularTracksResponse = new PopularTracksResponse();
    List<PopularTarcks> popularTarcks = popularTrackRepository.findPopularTarcks(LocalDate.now());
    List<String> tagsList = new ArrayList<>();
    List<String> genreList = new ArrayList<>();
    List<String> moodList = new ArrayList<>();
    List<String> artistList = new ArrayList<>();
    popularTracksResponse.setPopularTarcksList(popularTarcks);
    popularTarcks.forEach(track -> {
      tagsList.addAll(track.getTag());
      artistList.addAll(track.getArtist());
      moodList.addAll(track.getMood());
      genreList.addAll(track.getGenre());
    });
    popularTracksResponse.setTagsList(tagsList);
    popularTracksResponse.setArtistList(artistList);
    popularTracksResponse.setGenreList(genreList);
    return popularTracksResponse;
  }

  @Override
  public List<TracksByTag> getTracksByTags(List<String> tags) {
    List<TracksByTag> tracksByTag = new ArrayList<>();
    tags.forEach(tag ->{
      tracksByTag.add(tracksByTagRepository.findById(tag).get());
    });
    return tracksByTag;
  }

  @Override
  public void updateTrackMetadata(TrackMetadata trackMetadata) {
    trackRepository.save(trackMetadata);
    //update TrackByArtist,TrackTag,TrackByGenre,TrackByMood list also parallelly in batch.
  }

  @Override
  public TrackMetadata getTrackDetails(String trackId) {
    return trackRepository.findById(trackId).get();
  }

  @Override
  public void deleteTrack(String Id) {
    trackRepository.deleteById(Id);
  }
}
;