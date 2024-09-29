package org.example.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.example.POJOS.booking;
import org.example.POJOS.bookingdates;
import org.example.POJOS.bookingresponse;

public class PayloadManager {

    Gson gson;

    // All Serialization and DeSerialization will be RUN

    // Converting the JAVA object to the String
    
    public String createpayloadbooking(){

        booking booking = new booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(111);

        bookingdates bookingdates = new bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        // Java Object -> JSON String (byteStream) - Serlization
        gson = new Gson();
        String jsonStringpayload = gson.toJson(booking);
        System.out.println(jsonStringpayload);
        return jsonStringpayload;
    }


    public String createpayloadbooking01(){
        Faker fake = new Faker();

        booking booking = new booking();
        booking.setFirstname(fake.name().firstName());
        booking.setLastname(fake.name().lastName());
        booking.setTotalprice(fake.random().nextInt(1000));
        booking.setDepositepaid(true);

        bookingdates bookingdates = new bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        gson = new Gson();
        String jsonstring = gson.toJson(booking);
        System.out.println(jsonstring);
        return jsonstring;
    }


    public bookingresponse bookingResponseJava(String responseString) {
        gson = new Gson();
        bookingresponse bookingResponse = gson.fromJson(responseString, bookingresponse.class);
        return bookingResponse;
    }
}
