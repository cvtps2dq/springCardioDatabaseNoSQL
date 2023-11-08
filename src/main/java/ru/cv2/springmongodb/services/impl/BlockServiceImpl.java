package ru.cv2.springmongodb.services.impl;

import org.springframework.stereotype.Service;
import ru.cv2.springmongodb.documents.Block;
import ru.cv2.springmongodb.documents.Doctor;
import ru.cv2.springmongodb.documents.Patient;
import ru.cv2.springmongodb.repositories.BlockRepository;
import ru.cv2.springmongodb.repositories.DoctorRepository;
import ru.cv2.springmongodb.repositories.PatientRepository;
import ru.cv2.springmongodb.services.BlockService;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    private final BlockRepository blockRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public BlockServiceImpl(BlockRepository blockRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.blockRepository = blockRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Block> findAll(){
        return blockRepository.findAll();
    }
    @Override
    public Block findByAddress(String address) {
        return blockRepository.findBlockByAddress(address);
    }

    @Override
    public Block findByZip(String zip) {
        return blockRepository.findBlockByZip(zip);
    }

    @Override
    public Block saveBlock(Block block) {
        return blockRepository.save(block);
    }

    @Override
    public void deleteBlock(String id) {
        Block block = findById(id);
        List<Patient> patients = patientRepository.findAll();
        List<Doctor> doctors = doctorRepository.findAll();
        patientRepository.deleteAll(patients);
        doctorRepository.deleteAll(doctors);
        blockRepository.delete(block);
    }

    public Block findById(String id) {
        return blockRepository.findBlockById(id);
    }

    @Override
    public Block updateBlock(String id, Block updatedBlock) {
        Block block = findById(id);
        block.setPhoneNumber(updatedBlock.getPhoneNumber());
        block.setAddress(updatedBlock.getAddress());
        block.setZip(updatedBlock.getZip());
        return blockRepository.save(block);
    }
}
