package com.diplav.HospitalManagementApplication.controller;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.diplav.HospitalManagementApplication.entity.Doctor;
import com.diplav.HospitalManagementApplication.entity.Patient;
import com.diplav.HospitalManagementApplication.service.DoctorService;
import com.diplav.HospitalManagementApplication.service.PatientService;
import com.diplav.HospitalManagementApplication.repository.DoctorRepository;
import com.diplav.HospitalManagementApplication.repository.PatientRepository;

@Controller
public class PatientController {

    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    private final PatientService patientService;
    @Autowired
    private final DoctorService doctorService;
    @Autowired
    private final DoctorRepository doctorRepository;
    public PatientController(PatientRepository patientRepository,
                             PatientService patientService,
                             DoctorService doctorService,
                             DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.doctorRepository = doctorRepository;
    }
    @RequestMapping("/patientPage")
    public String patientPage(){
        return "patientPage";
    }
    @GetMapping("/manageAppointment")
    public String manageAppointment(Model model){
        model.addAttribute("appointments", patientRepository.findAll());
        return "manageAppointment";
    }
    @PostMapping("/bookAppointment")
    public String bookAppointment(@ModelAttribute("appointments") Patient patient ){
        patientService.save(patient);
        return "redirect:/manageAppointment";
    }
    @RequestMapping("/removeAppointment/{id}")
    public String removeAppointment(@PathVariable("id") Long id){
        patientService.removePatient(id);
        return "redirect:/manageAppointment";
    }
    @GetMapping("/searchDoctor")
    public String searchDoctor(Model model){
        model.addAttribute("doctors", doctorRepository.findAll());
        return "checkDoctor";
    }
    @GetMapping("/doSearch")
    public String doSearch(@RequestParam("doctorName") String doctorName, Model model) {
        List<Doctor> doctorList = doctorService.findByName(doctorName);
        model.addAttribute("doctors", doctorList);
        return "SearchDoctor";
    }
}
