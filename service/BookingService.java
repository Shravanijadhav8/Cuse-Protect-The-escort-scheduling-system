package com.shravani.cuseprotect.service;

import com.shravani.cuseprotect.model.Booking;

import java.util.List;

public interface BookingService {
    Booking escortBooking(Booking booking);

    List<Booking> fetchAllBookings();

    void cancelBooking(Booking booking);

    Booking getStudentDetailsBysuID(Integer suID);

    // Booking getBookingDetailByName(String name);
}
