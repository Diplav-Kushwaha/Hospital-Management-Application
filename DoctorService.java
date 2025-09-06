package com.diplav.HospitalManagementApplication.service;

import com.diplav.HospitalManagementApplication.entity.Doctor;
import com.diplav.HospitalManagementApplication.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private final DoctorRepository doctorRepository;
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
    public void updateDoctor(Long id, Doctor doctor) {
        Doctor existing = doctorRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setDoctorName(doctor.getDoctorName());
            existing.setDoctorAddress(doctor.getDoctorAddress());
            existing.setDoctorContact(doctor.getDoctorContact());
            existing.setSpecialistIn(doctor.getSpecialistIn());

            doctorRepository.save(doctor);
        }
    }

    public List<Doctor> findByName(String doctorName) {
        return doctorRepository.findByDoctorNameContainingIgnoreCase(doctorName);
    }
}
