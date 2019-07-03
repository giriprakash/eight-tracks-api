package com.eight.tracks.api.repository;

import com.eight.tracks.api.model.TrackMetadata;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface TrackRepository extends CassandraRepository<TrackMetadata,String> {
}
