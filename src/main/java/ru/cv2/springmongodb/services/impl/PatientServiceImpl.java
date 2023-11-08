package ru.cv2.springmongodb.services.impl;

import org.springframework.stereotype.Service;
import ru.cv2.springmongodb.documents.Patient;
import ru.cv2.springmongodb.repositories.PatientRepository;
import ru.cv2.springmongodb.services.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findByCondition(String condition) {
        return patientRepository.findPatientsByCondition(condition);
    }

    @Override
    public List<Patient> findByAge(Integer age) {
        return patientRepository.findPatientsByAge(age);
    }

    @Override
    public Patient findById(String id) {
        return patientRepository.findPatientById(id);
    }

    @Override
    public List<Patient> findByBlockId(String blockId) {
        return patientRepository.findPatientsByBlockId(blockId);
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(String id) {
        Patient patient = findById(id);
        patientRepository.delete(patient);
    }

    @Override
    public Patient updatePatient(String id, Patient updatedPatient) {
        Patient patient = findById(id);
        patient.setAge(updatedPatient.getAge());
        patient.setName(updatedPatient.getName());
        patient.setSurname(updatedPatient.getSurname());
        patient.setCondition(updatedPatient.getCondition());
        patient.setDiagnosis(updatedPatient.getDiagnosis());
        patient.setBlockId(updatedPatient.getBlockId());
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
