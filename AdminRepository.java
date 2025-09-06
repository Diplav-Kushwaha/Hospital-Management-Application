package com.diplav.HospitalManagementApplication.repository;

import com.diplav.HospitalManagementApplication.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
