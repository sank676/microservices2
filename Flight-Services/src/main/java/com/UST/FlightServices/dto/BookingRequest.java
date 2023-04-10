package com.UST.FlightServices.dto;

import com.UST.FlightServices.entity.Passengerinfo;
import com.UST.FlightServices.entity.Paymentinfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingRequest {
    private Passengerinfo passengerinfo;
    private Paymentinfo paymentinfo;
}
