package com.diplav.HospitalManagementApplication.controller;

import com.diplav.HospitalManagementApplication.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoctorController {
    @Autowired
    private final PatientRepository patientRepository;
    public DoctorController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @RequestMapping("/doctorPage")
    public String doctorPage(Model model){
        model.addAttribute("appointments", patientRepository.findAll());
        return "doctorPage";
    }

}
