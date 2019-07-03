package com.eight.tracks.api.model;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.time.LocalDateTime;

@Table(name="track_by_genre")
@Data
public class TracksByGenre {

  @PartitionKey
  private String genre;

  @PartitionKey
  private String  trackId;

  private LocalDateTime lastUpdatedTime;

  @ClusteringColumn
  private int numberOfLikes;

  @ClusteringColumn
  private int numberOfPlays;


}
