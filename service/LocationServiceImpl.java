package com.shravani.cuseprotect.service;

import com.shravani.cuseprotect.model.Location;
import com.shravani.cuseprotect.model.Student;
import com.shravani.cuseprotect.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    public LocationRepo locationRepo;

    @Override
    public Location saveLocation(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public Location getStudentLocation(String location) {

        Optional<Location> studentLocation = locationRepo.findByLocation(location);
        System.out.println(location);
        if(studentLocation.isPresent()){
            Location studentLocationDetail = studentLocation.get();
            return studentLocationDetail;
        }
        return null;
    }


}
