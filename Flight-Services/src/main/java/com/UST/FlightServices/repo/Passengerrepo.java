package com.UST.FlightServices.repo;

import com.UST.FlightServices.entity.Passengerinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Passengerrepo extends JpaRepository<Passengerinfo,Long> {
}
