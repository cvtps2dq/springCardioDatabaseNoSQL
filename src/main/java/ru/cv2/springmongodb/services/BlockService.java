package ru.cv2.springmongodb.services;

import ru.cv2.springmongodb.documents.Block;

import java.util.Arrays;
import java.util.List;

public interface BlockService {
    Block findByAddress(String address);
    Block findByZip(String zip);
    Block saveBlock(Block block);
    void deleteBlock(String id);
    Block updateBlock(String id, Block updatedBlock);
    Block findById(String id);
    List<Block> findAll();
}
