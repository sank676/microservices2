package com.UST.FlightServices.repo;

import com.UST.FlightServices.entity.Paymentinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Paymentrepo extends JpaRepository<Paymentinfo,String> {
}
