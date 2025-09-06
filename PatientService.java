package com.diplav.HospitalManagementApplication.service;

import com.diplav.HospitalManagementApplication.entity.Patient;
import com.diplav.HospitalManagementApplication.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public void save(Patient patient) {
        patientRepository.save(patient);
    }
    public void removePatient(Long id) {
        patientRepository.deleteById(id);
    }
    public void appointmentAccepted(Long id) {
        Patient existing = patientRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setPatientAppointment(true);
            patientRepository.save(existing);
        }
    }
}
