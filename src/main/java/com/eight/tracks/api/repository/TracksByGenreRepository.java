package com.eight.tracks.api.repository;

import com.eight.tracks.api.model.TracksByArtist;
import com.eight.tracks.api.model.TracksByGenre;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;

public interface TracksByGenreRepository extends CassandraRepository<TracksByGenre,String> {
}
