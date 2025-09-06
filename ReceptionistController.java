package com.diplav.HospitalManagementApplication.controller;

import com.diplav.HospitalManagementApplication.repository.PatientRepository;
import com.diplav.HospitalManagementApplication.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceptionistController {

    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    private final PatientService patientService;
    public ReceptionistController(PatientRepository patientRepository,
                                  PatientService patientService) {
        this.patientRepository = patientRepository;
        this.patientService = patientService;
    }

    @RequestMapping("/receptionistPage")
    public String receptionistPage(Model model){
        model.addAttribute("appointments", patientRepository.findAll());
        return "receptionistPage";
    }
    @RequestMapping("/appointmentAccepted/{id}")
    public String appointmentAccepted(@PathVariable("id") Long id){
        patientService.appointmentAccepted(id);
        return "redirect:/receptionistPage";
    }
    @RequestMapping("/removeAppointmentByReceptionist/{id}")
    public String removeAppointment(@PathVariable("id") Long id){
        patientService.removePatient(id);
        return "redirect:/receptionistPage";
    }
}
