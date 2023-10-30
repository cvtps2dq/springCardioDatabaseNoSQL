package ru.cv2.springmongodb.services.impl;

import ru.cv2.springmongodb.documents.Block;
import ru.cv2.springmongodb.repositories.BlockRepository;
import ru.cv2.springmongodb.services.BlockService;

public class BlockServiceImpl implements BlockService {
    private final BlockRepository blockRepository;

    public BlockServiceImpl(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
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
