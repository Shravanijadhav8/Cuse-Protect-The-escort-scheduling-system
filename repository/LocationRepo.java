package com.shravani.cuseprotect.repository;

import com.shravani.cuseprotect.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepo extends MongoRepository<Location, String> {

    Optional<Location> findByLocation(String location);

}
