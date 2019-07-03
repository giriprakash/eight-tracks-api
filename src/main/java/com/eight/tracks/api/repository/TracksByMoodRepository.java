package com.eight.tracks.api.repository;

import com.eight.tracks.api.model.TracksByMood;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface TracksByMoodRepository extends CassandraRepository<TracksByMood,String> {
}
