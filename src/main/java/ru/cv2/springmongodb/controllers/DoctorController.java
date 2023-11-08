package ru.cv2.springmongodb.controllers;

import org.springframework.web.bind.annotation.*;
import ru.cv2.springmongodb.documents.Doctor;
import ru.cv2.springmongodb.services.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @GetMapping("/all")
    public List<Doctor> getAll(){
        return doctorService.findAll().stream().toList();
    }

    @GetMapping("/{id}")
    public Doctor getById(@PathVariable String id){
        return doctorService.findById(id);
    }

    @PostMapping("/update")
    public Doctor update(String id, Doctor updatedDoctor){
        return doctorService.updateDoctor(id, updatedDoctor);
    }

    @PostMapping("/add")
    public Doctor add(Doctor target){
        return doctorService.saveDoctor(target);
    }
}
