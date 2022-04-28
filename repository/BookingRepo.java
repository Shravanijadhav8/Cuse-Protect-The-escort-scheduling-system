package com.shravani.cuseprotect.repository;

import com.shravani.cuseprotect.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepo extends MongoRepository<Booking, String> {

    Optional<Booking> findByName(String name);

    Optional<Booking> findBysuID(Integer suID);
}
