package com.shravani.cuseprotect.controller;

import com.shravani.cuseprotect.model.Location;
//import com.shravani.cuseprotect.model.Student;
import com.shravani.cuseprotect.payload.response.MessageResponse;
import com.shravani.cuseprotect.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {
    @Autowired
    public LocationService locationService;

    @PostMapping("/Location/addLocation")
    public ResponseEntity<?> addLocation(@RequestBody Location location){
        Location location1 = new Location(location.getLocation(), location.getTime());
        Location studentLocation = locationService.saveLocation(location1);
        return ResponseEntity.ok(studentLocation);
    }

   @RequestMapping(value = "/Location/studentLocation/{location}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudentLocation(@PathVariable String location){
        Location studentLoc = locationService.getStudentLocation(location);
       if(studentLoc == null){
           return ResponseEntity.badRequest().body(new MessageResponse("No student location exist!"));
       }
        return ResponseEntity.ok(studentLoc);
   }

}
