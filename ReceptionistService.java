package com.diplav.HospitalManagementApplication.service;

import com.diplav.HospitalManagementApplication.entity.Receptionist;
import com.diplav.HospitalManagementApplication.repository.ReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceptionistService {
    @Autowired
    private final ReceptionistRepository receptionistRepository;
    public ReceptionistService(ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }
    public void save(Receptionist receptionist) {
        receptionistRepository.save(receptionist);
    }
    public void updateReceptionist(Long id, Receptionist receptionist) {
        Receptionist existing = receptionistRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setReceptionistName(receptionist.getReceptionistName());
            existing.setReceptionistAddress(receptionist.getReceptionistAddress());
            existing.setReceptionistContact(receptionist.getReceptionistContact());
            existing.setSpecialistIn(receptionist.getSpecialistIn());

            receptionistRepository.save(receptionist);
        }
    }
    public void deleteReceptionist(Long id) {
        receptionistRepository.deleteById(id);
    }
}
