package com.shravani.cuseprotect.controller;

import com.shravani.cuseprotect.model.*;
import com.shravani.cuseprotect.payload.response.MessageResponse;
import com.shravani.cuseprotect.repository.BookingRepo;
import com.shravani.cuseprotect.service.BookingService;
import com.shravani.cuseprotect.service.LocationService;
import com.shravani.cuseprotect.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private StudentService studentService;
    
    public Integer totalETA = 0;
    public Integer studentsAhead = 0;

    @PostMapping("/Booking/addBooking")
    public ResponseEntity<?> addBooking(@RequestBody Booking booking){
        totalETA = 0;
        Location studentLoc = locationService.getStudentLocation(booking.getDestination());
        booking.setTime(studentLoc.getTime());
        Booking booking1 = new Booking(booking.getId(), booking.getName(), booking.getSuID(), booking.getDestination(), booking.getTime());
        Booking bookingLocation = bookingService.escortBooking(booking1);

        List<Booking> studentBookings = bookingService.fetchAllBookings();
        
        for (Booking studentbooking : studentBookings) {
            totalETA = studentbooking.getTime() + totalETA;
        }
        BookingResponseModel bookingResponseModel = new BookingResponseModel(totalETA, studentBookings.size());
        return ResponseEntity.ok(bookingResponseModel);

    }

    @RequestMapping(value = "/Booking/getBookingDetails/{suID}", method = RequestMethod.GET)
    public ResponseEntity<?> getBookingDetails(@PathVariable Integer suID){

        studentsAhead = 0;
        totalETA = 0;
        List<Booking> studentBookings = bookingService.fetchAllBookings();

       for (Booking studentbooking : studentBookings) {
            if(!Objects.equals(suID, studentbooking.getSuID())){
                totalETA = studentbooking.getTime() + totalETA;
                studentsAhead++;
                //break;
            }
            else{
                break;
            }
            System.out.println(studentsAhead);
            System.out.println(studentbooking.getSuID());
        }
       Booking studentBooking = bookingService.getStudentDetailsBysuID(suID);
       StudentResponseModel studentResponseModel = new StudentResponseModel(studentBooking.getName(),
               studentBooking.getSuID(), totalETA, studentsAhead, studentBooking.getDestination());

        //BookingResponseModel bookingResponseModel = new BookingResponseModel(totalETA, studentsAhead);
        return ResponseEntity.ok(studentResponseModel);
    }

    @RequestMapping(value = "/Booking/getAllDetails", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDetails(){
        List<Booking> studentBookings = bookingService.fetchAllBookings();
        if(studentBookings == null){
            return ResponseEntity.badRequest().body(new MessageResponse("No booking details exists!"));
        }
        return ResponseEntity.ok(studentBookings);
    }

    @DeleteMapping(value = "/Booking/cancelBooking/{suID}")
    public ResponseEntity<?> cancelBooking(@PathVariable Integer suID){
        Booking booking = bookingService.getStudentDetailsBysuID(suID);
        if(booking != null){
            bookingService.cancelBooking(booking);
        }
        return ResponseEntity.ok(booking);
    }
}
