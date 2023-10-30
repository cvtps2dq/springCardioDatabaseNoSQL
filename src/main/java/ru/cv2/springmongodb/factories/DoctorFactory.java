package ru.cv2.springmongodb.factories;

import com.github.javafaker.Faker;
import ru.cv2.springmongodb.documents.Block;
import ru.cv2.springmongodb.documents.Doctor;
import ru.cv2.springmongodb.documents.Patient;
import ru.cv2.springmongodb.repositories.BlockRepository;
import ru.cv2.springmongodb.repositories.DoctorRepository;
import ru.cv2.springmongodb.repositories.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoctorFactory {
    private final Faker faker = new Faker();
    private List<Block> blockList = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final BlockRepository blockRepository;
    private final Random rand = new Random();

    public DoctorFactory(DoctorRepository doctorRepository, PatientRepository patientRepository, BlockRepository blockRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.blockRepository = blockRepository;
    }


    public void generate(int count) {
        blockList = blockRepository.findAll();
        patients = patientRepository.findAll();
        System.out.println(patients.size());
        for (int i = 0; i < count; i++) {
            Doctor doctor = new Doctor();

            doctor.setAge(rand.nextInt(45, 99));
            doctor.setName(faker.name().firstName());
            doctor.setSurname(faker.name().lastName());
            String block = patients.get(rand.nextInt(patients.size())).getId();
            doctor.setPatient(block);
            doctor.setBlockId(block);
            doctorRepository.save(doctor);
        }
    }

}
