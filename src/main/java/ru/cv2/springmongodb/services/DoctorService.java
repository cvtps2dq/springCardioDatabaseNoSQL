package ru.cv2.springmongodb.services;

import ru.cv2.springmongodb.documents.Doctor;
import ru.cv2.springmongodb.documents.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor findById(String id);
    List<Doctor> findByNameAndAge(String name, Integer age);
    List<Doctor> findByPatient(String patient);
    Doctor saveDoctor(Doctor doctor);
    void deleteDoctor(String id);
    Doctor updateDoctor(String id, Doctor updatedDoctor);
}
