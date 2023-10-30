package ru.cv2.springmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.cv2.springmongodb.documents.Block;

import java.util.List;

@Repository
public interface BlockRepository extends MongoRepository<Block, String> {
    Block findBlockByAddress(String address);
    Block findBlockByZip(String zip);
    Block findBlockById(String id);
}
