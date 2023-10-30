package ru.cv2.springmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.cv2.springmongodb.documents.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

    List<Patient> findPatientsByCondition(String condition);
    List<Patient> findPatientsByAge(Integer age);
    Patient findPatientById(String id);
    List<Patient> findPatientsByBlockId(String blockId);

}
