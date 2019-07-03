package com.eight.tracks.api.model;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Table(name="popular_tracks")
@Data
public class PopularTarcks {

  @PartitionKey
  @Column(name="date")
  private LocalDate date;

  @ClusteringColumn
  @Column(name="trackId")
  private String trackId;

  @Column(name = "trackName")
  private String trackName;

  @ClusteringColumn
  @Column(name="numberOfTimesPlayed")
  private String numberOfTimesPlayed;

  @ClusteringColumn
  @Column(name="numberOfLikes")
  private String numberOfLikes;

  @Column(name ="lastModifiedTime")
  private LocalDateTime lastModifiedTime;

  @Column(name ="LastModifiedBy")
  private String LastModifiedBy;

  @Column(name="artist")
  private List<String> artist;

  @Column(name ="tag")
  private List<String> tag;

  @Column(name = "genre")
  private List<String> genre;

  @Column(name ="mood")
  private List<String> mood;
}

