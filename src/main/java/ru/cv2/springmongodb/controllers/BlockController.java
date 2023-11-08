package ru.cv2.springmongodb.controllers;

import org.springframework.web.bind.annotation.*;
import ru.cv2.springmongodb.documents.Block;
import ru.cv2.springmongodb.services.BlockService;

import java.util.List;

@RestController
@RequestMapping("/api/block")
public class BlockController {

    private BlockService blockService;

    @GetMapping("/all")
    public List<Block> getAll(){
        return blockService.findAll().stream().toList();
    }

    @GetMapping("/{id}")
    public Block getbyId(@PathVariable String id){
        return blockService.findById(id);
    }

    @GetMapping("/zip/{zip}")
    public Block getByZip(@PathVariable String zip){
        return blockService.findByZip(zip);
    }


    @PostMapping("/update")
    public Block update(String id, Block updatedBlock){
        return blockService.updateBlock(id, updatedBlock);
    }

    @PostMapping("/add")
    public Block add(Block target){
        return blockService.saveBlock(target);
    }
}
