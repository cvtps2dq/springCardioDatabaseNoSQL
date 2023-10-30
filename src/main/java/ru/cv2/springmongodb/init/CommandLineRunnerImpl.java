package ru.cv2.springmongodb.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.cv2.springmongodb.factories.BlockFactory;
import ru.cv2.springmongodb.factories.DoctorFactory;
import ru.cv2.springmongodb.factories.PatientFactory;
import ru.cv2.springmongodb.repositories.BlockRepository;
import ru.cv2.springmongodb.repositories.DoctorRepository;
import ru.cv2.springmongodb.repositories.PatientRepository;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    BlockRepository blockRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @Override
    public void run(String... args) throws Exception {
        BlockFactory blockFactory = new BlockFactory(blockRepository);
        blockFactory.generate(10);

        PatientFactory patientFactory = new PatientFactory(patientRepository, blockRepository);
        patientFactory.generate(10000);

        DoctorFactory doctorFactory = new DoctorFactory(doctorRepository, patientRepository, blockRepository);
        doctorFactory.generate(10000);

    }
}
