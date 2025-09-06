package com.diplav.HospitalManagementApplication.repository;

import com.diplav.HospitalManagementApplication.entity.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {
}
