package com.eight.tracks.api.model;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.time.LocalDateTime;
import java.util.List;

@Table(name="tracks_metadata")
@Data
public class TrackMetadata {

  @PartitionKey
  @Column(name="track_id")
  private String trackId;

  @Column(name="track_title")
  private String trackTitle;

  @Column(name="description")
  private String description;

  @Column(name="artists")
  private List<String> artists;

  @Column(name="genre")
  private List<String> genre;

  @Column(name="tags")
  private List<String> tags;

  @Column(name="mood")
  private List<String> mood;

  @Column(name="numberOfTimesPlayed")
  private long numberOfTimesPlayed;

  @Column(name="numberOfLikes")
  private long numberOfLikes;

  @ClusteringColumn
  @Column(name="createTime")
  private LocalDateTime createTime;

  @Column(name="lastUpdatedTime")
  private LocalDateTime lastUpdatedTime;

}
