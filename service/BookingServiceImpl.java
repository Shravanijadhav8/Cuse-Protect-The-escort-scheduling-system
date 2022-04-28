package com.shravani.cuseprotect.service;

import com.shravani.cuseprotect.model.Booking;
import com.shravani.cuseprotect.model.Location;
import com.shravani.cuseprotect.model.Student;
import com.shravani.cuseprotect.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    public BookingRepo bookingRepo;

   @Override
    public Booking escortBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> fetchAllBookings() {
        List<Booking> availableBookings = bookingRepo.findAll();
        return availableBookings;
    }

    @Override
    public void cancelBooking(Booking booking) {
        bookingRepo.delete(booking);
    }

    @Override
    public Booking getStudentDetailsBysuID(Integer suID) {
        Optional<Booking> bookingDetailbysuID = bookingRepo.findBysuID(suID);
        if(bookingDetailbysuID.isPresent()){
            Booking studentBookingDetail = bookingDetailbysuID.get();
            return studentBookingDetail;
        }
        return null;

    }

  /*  @Override
    public Booking getBookingDetailByName(String name) {
        Optional<Booking> bookingDetail = bookingRepo.findByName(name);
        if(bookingDetail.isPresent()){
            Booking studentBookingDetail = bookingDetail.get();
            return studentBookingDetail;
        }
        return null;    }*/
}
