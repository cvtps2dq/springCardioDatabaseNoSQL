package ru.cv2.springmongodb.controllers;

import org.springframework.web.bind.annotation.*;
import ru.cv2.springmongodb.documents.Patient;
import ru.cv2.springmongodb.services.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public List<Patient> getAll(){
        return patientService.findAll().stream().toList();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable String id){
        return patientService.findById(id);
    }

    @PostMapping("/update")
    public Patient update(String id, Patient updatedPatient){
        return patientService.updatePatient(id, updatedPatient);
    }

    @PostMapping("/add")
    public Patient add(Patient target){
        return patientService.savePatient(target);
    }
}

