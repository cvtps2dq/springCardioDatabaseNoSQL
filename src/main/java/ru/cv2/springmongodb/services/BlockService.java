package ru.cv2.springmongodb.services;

import ru.cv2.springmongodb.documents.Block;

public interface BlockService {
    Block findByAddress(String address);
    Block findByZip(String zip);
    Block saveBlock(Block block);
    void deleteBlock(String id);
    Block updateBlock(String id, Block updatedBlock);
}
