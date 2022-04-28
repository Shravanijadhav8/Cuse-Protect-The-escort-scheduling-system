package com.shravani.cuseprotect.service;

import com.shravani.cuseprotect.model.Location;

public interface LocationService {

    //static Location saveLocation(Location location);

    Location saveLocation(Location location);

    Location getStudentLocation(String location);


}
