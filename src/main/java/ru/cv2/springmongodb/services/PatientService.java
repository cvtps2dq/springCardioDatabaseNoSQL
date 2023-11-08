package ru.cv2.springmongodb.services;

import ru.cv2.springmongodb.documents.Patient;

import java.util.Arrays;
import java.util.List;

public interface PatientService {

    List<Patient> findByCondition(String condition);
    List<Patient> findByAge(Integer age);
    Patient findById(String id);
    List<Patient> findByBlockId(String blockId);
    Patient savePatient(Patient patient);
    void deletePatient(String id);
    Patient updatePatient(String id, Patient updatedPatient);
    List<Patient> findAll();
}
