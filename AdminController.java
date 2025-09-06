package com.diplav.HospitalManagementApplication.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.diplav.HospitalManagementApplication.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import com.diplav.HospitalManagementApplication.entity.Receptionist;
import com.diplav.HospitalManagementApplication.service.DoctorService;
import com.diplav.HospitalManagementApplication.repository.DoctorRepository;
import com.diplav.HospitalManagementApplication.service.ReceptionistService;
import com.diplav.HospitalManagementApplication.repository.ReceptionistRepository;

@Controller
public class AdminController {

    @Autowired
    private final DoctorService doctorService;
    @Autowired
    private final DoctorRepository doctorRepository;
    @Autowired
    private final ReceptionistService receptionistService;
    @Autowired
    private final ReceptionistRepository receptionistRepository;
    public AdminController(DoctorService doctorService,
                           DoctorRepository doctorRepository,
                           ReceptionistService receptionistService,
                           ReceptionistRepository receptionistRepository) {
        this.doctorService = doctorService;
        this.doctorRepository = doctorRepository;
        this.receptionistService = receptionistService;
        this.receptionistRepository = receptionistRepository;
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }
    @RequestMapping("/adminPage")
    public String adminPage(){
        return "adminPage";
    }
    //Doctor Management By Admin
    @GetMapping("/manageDoctor")
    public String manageDoctor(Model model){
        model.addAttribute("doctors", doctorRepository.findAll());
        return "manageDoctor";
    }
    @PostMapping("/addDoctor")
    public String addDoctor(@ModelAttribute("doctor") Doctor doctor){
        doctorService.save(doctor);
        return "redirect:/manageDoctor";
    }
    @GetMapping("/updateDoctor/{id}")
    public String showUpdateDoctorForm(@PathVariable("id") Long id, Model model) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        model.addAttribute("doctor", doctor);
        return "updateDoctor";
    }
    @PostMapping("/updateDoctor/{id}")
    public String updateDoctor(@PathVariable("id") Long id, @ModelAttribute("doctor") Doctor doctor) {
        doctorService.updateDoctor(id, doctor);
        return "redirect:/manageDoctor";
    }
    @RequestMapping("/removeDoctor/{id}")
    public String removeDoctor(@PathVariable("id") Long id){
        doctorService.deleteDoctor(id);
        return "redirect:/manageDoctor";
    }
    //Receptionist management by admin
    @GetMapping("/manageReceptionist")
    public String manageReceptionist(Model model){
        model.addAttribute("receptionists", receptionistRepository.findAll());
        return "manageReceptionist";
    }
    @PostMapping("/addReceptionist")
    public String addReceptionist(@ModelAttribute("receptionist") Receptionist receptionist){
        receptionistService.save(receptionist);
        return "redirect:/manageReceptionist";
    }
    @GetMapping("/updateReceptionist/{id}")
    public String showUpdateReceptionistForm(@PathVariable("id") Long id, Model model) {
        Receptionist receptionist= receptionistRepository.findById(id).orElse(null);
        model.addAttribute("receptionist", receptionist);
        return "updateReceptionist";
    }
    @PostMapping("/updateReceptionist/{id}")
    public String updateReceptionist(@PathVariable("id") Long id, @ModelAttribute("receptionist") Receptionist receptionist) {
        receptionistService.updateReceptionist(id, receptionist);
        return "redirect:/manageReceptionist";
    }
    @RequestMapping("/removeReceptionist/{id}")
    public String removeReceptionist(@PathVariable("id") Long id){
        receptionistService.deleteReceptionist(id);
        return "redirect:/manageReceptionist";
    }
}
