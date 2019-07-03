package com.eight.tracks.api.rs;


import com.eight.tracks.api.model.PopularTarcks;
import com.eight.tracks.api.model.PopularTracksResponse;
import com.eight.tracks.api.model.TrackMetadata;
import com.eight.tracks.api.model.TracksByArtist;
import com.eight.tracks.api.model.TracksByGenre;
import com.eight.tracks.api.model.TracksByMood;
import com.eight.tracks.api.model.TracksByTag;
import com.eight.tracks.api.service.impl.EightTracksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eight/tracks/v1")
public class EightTracksApiController {


  @Autowired
  EightTracksServiceImpl eightTracksService;

  @GetMapping("track/details")
  public TrackMetadata getTrackDetails(@RequestParam String trackId){
    return eightTracksService.getTrackDetails(trackId);
  }

  @GetMapping("/landing/explore/tracks")
  public PopularTracksResponse getTracksOnLanding(){
    return eightTracksService.getPopularTracksOnLanding();
  }

  @PutMapping("/track")
  public String updateTrack(@RequestBody TrackMetadata trackMetadata){
    eightTracksService.updateTrackMetadata(trackMetadata);
    return "Successfully updated data";
  }

  @PostMapping("/track")
  public String createTrack(@RequestBody TrackMetadata trackMetadata){
    eightTracksService.updateTrackMetadata(trackMetadata);
    return "Successfully creates track";
  }

  @DeleteMapping("/track")
  public String deleteTrack(@RequestParam String trackId){
    eightTracksService.deleteTrack(trackId);
    return "Successfully deleted track";
  }

  @GetMapping("/genre/tracks")
  public List<TracksByGenre> getTracksByGenre(@RequestBody List<String> genreList){
    return eightTracksService.getTracksByGenre(genreList);
  }

  @GetMapping("/artist/tracks")
  public List<TracksByArtist> getTracksByArtist(@RequestBody List<String> artistList){
    return eightTracksService.getTracksByArtist(artistList);
  }

  @GetMapping("/mood/tracks")
  public List<TracksByMood> getTracksByMood(@RequestBody List<String> moodList){
    return eightTracksService.getTracksByMood(moodList);
  }

  @GetMapping("/tag/tracks")
  public List<TracksByTag> getTracksByTag(@RequestBody List<String> tagsList){
    return eightTracksService.getTracksByTags(tagsList);
  }



}
