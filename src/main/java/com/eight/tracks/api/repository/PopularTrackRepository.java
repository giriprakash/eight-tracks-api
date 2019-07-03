package com.eight.tracks.api.repository;

import com.eight.tracks.api.model.PopularTarcks;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface PopularTrackRepository extends CassandraRepository<PopularTarcks,LocalDate> {

  @Query("SELECT*FROM popular_tracks WHERE date = ?")
  List<PopularTarcks> findPopularTarcks(LocalDate date);


}
