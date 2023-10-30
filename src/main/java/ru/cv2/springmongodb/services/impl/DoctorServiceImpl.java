package ru.cv2.springmongodb.services.impl;

import ru.cv2.springmongodb.documents.Doctor;
import ru.cv2.springmongodb.repositories.DoctorRepository;
import ru.cv2.springmongodb.services.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor findById(String id) {
        return doctorRepository.findDoctorById(id);
    }

    @Override
    public List<Doctor> findByNameAndAge(String name, Integer age) {
        return doctorRepository.findDoctorsByNameAndAge(name, age);
    }

    @Override
    public List<Doctor> findByPatient(String patient) {
        return doctorRepository.findDoctorsByPatient(patient);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(String id) {
        Doctor doctor = findById(id);
        doctorRepository.delete(doctor);
    }

    @Override
    public Doctor updateDoctor(String id, Doctor updatedDoctor) {
        Doctor doctor = findById(id);
        doctor.setAge(updatedDoctor.getAge());
        doctor.setName(updatedDoctor.getName());
        doctor.setSurname(updatedDoctor.getSurname());
        doctor.setPatient(updatedDoctor.getPatient());
        doctor.setBlockId(updatedDoctor.getBlockId());
        return doctorRepository.save(doctor);
    }
}
