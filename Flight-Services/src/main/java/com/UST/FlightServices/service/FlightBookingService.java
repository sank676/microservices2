package com.UST.FlightServices.service;

import com.UST.FlightServices.dto.BookingRequest;
import com.UST.FlightServices.dto.FlightBookingAcknowledgement;
import com.UST.FlightServices.entity.Passengerinfo;
import com.UST.FlightServices.entity.Paymentinfo;
import com.UST.FlightServices.exception.InsufficentAmountException;
import com.UST.FlightServices.repo.Passengerrepo;
import com.UST.FlightServices.repo.Paymentrepo;
import com.UST.FlightServices.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    private Passengerrepo passengerrepo;
    @Autowired
    private Paymentrepo paymentrepo;
    @Transactional
    public FlightBookingAcknowledgement bookingFlightTicket(BookingRequest request) throws InsufficentAmountException {
        Passengerinfo passengerinfo=request.getPassengerinfo();
        passengerinfo= passengerrepo.save(passengerinfo);
        Paymentinfo paymentinfo=request.getPaymentinfo();
        PaymentUtils.validateCreditLimit(paymentinfo.getAccountNo(),passengerinfo.getFare());
        paymentinfo.setPassengerId(passengerinfo.getPId());
        paymentinfo.setAmount(passengerinfo.getFare());
        paymentrepo.save(paymentinfo);

        return new FlightBookingAcknowledgement("success",passengerinfo.getFare(),
                UUID.randomUUID().toString().split("-")[0],passengerinfo);
    }
}
