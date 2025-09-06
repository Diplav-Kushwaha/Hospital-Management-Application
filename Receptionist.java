package com.diplav.HospitalManagementApplication.entity;

import lombok.Data;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Receptionist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specialistIn;
    private String receptionistName;
    private String receptionistContact;
    private String receptionistAddress;
}
