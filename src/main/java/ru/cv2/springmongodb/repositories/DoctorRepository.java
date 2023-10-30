package ru.cv2.springmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.cv2.springmongodb.documents.Doctor;

import java.util.List;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
    Doctor findDoctorById(String id);
    List<Doctor> findDoctorsByNameAndAge(String name, Integer age);
    List<Doctor> findDoctorsByPatient(String patient);


}
