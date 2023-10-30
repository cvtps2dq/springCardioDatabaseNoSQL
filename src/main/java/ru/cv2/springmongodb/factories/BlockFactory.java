package ru.cv2.springmongodb.factories;

import com.github.javafaker.Faker;
import ru.cv2.springmongodb.documents.Block;
import ru.cv2.springmongodb.repositories.BlockRepository;

public class BlockFactory {

    private final Faker faker = new Faker();

    private final BlockRepository blockRepository;

    public BlockFactory(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    public void generate(int count) {
        for (int i = 0; i < count; i++) {
            Block block = new Block();
            block.setZip(faker.address().zipCode());
            block.setPhoneNumber(faker.phoneNumber().phoneNumber());
            block.setAddress(faker.address().fullAddress());
            blockRepository.save(block);
        }
    }

}
