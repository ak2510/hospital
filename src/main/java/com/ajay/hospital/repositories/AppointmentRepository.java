package com.ajay.hospital.repositories;

import com.ajay.hospital.domain.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
