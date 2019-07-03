package com.eight.tracks.api.repository;

import com.eight.tracks.api.model.TracksByTag;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface  TracksByTagRepository extends CassandraRepository<TracksByTag,String> {
}
