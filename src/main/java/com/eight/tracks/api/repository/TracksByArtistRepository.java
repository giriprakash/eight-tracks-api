package com.eight.tracks.api.repository;

import com.eight.tracks.api.model.TracksByArtist;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;

public interface TracksByArtistRepository extends CassandraRepository<TracksByArtist,String> {
}
