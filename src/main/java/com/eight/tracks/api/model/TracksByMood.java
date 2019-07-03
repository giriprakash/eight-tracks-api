package com.eight.tracks.api.model;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.time.LocalDateTime;

@Table(name="track_by_mood")
@Data
public class TracksByMood {

  @PartitionKey
  private String mood;

  @PartitionKey
  private String trackId;

  private String trackName;

  @ClusteringColumn
  private int numberOfLikes;

  @ClusteringColumn
  private int numberOfPlays;

  private LocalDateTime lastUpdatedTime;

}
