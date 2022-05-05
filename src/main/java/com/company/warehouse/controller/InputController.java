package com.company.warehouse.controller;

import com.company.warehouse.entity.Input;
import com.company.warehouse.payload.InputDto;
import com.company.warehouse.payload.Result;
import com.company.warehouse.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;
    @PostMapping
    public Result addInput(@RequestBody InputDto inputDto){
        Result result = inputService.addInput(inputDto);
        return result;
    }
    @GetMapping
    public List<Input> getInputList(){
        List<Input> inputList = inputService.getInputList();
        return inputList;
    }
    @GetMapping("/{id}")
    public Input getInput(@PathVariable Integer id){
        Input input = inputService.getInput(id);
        return input;
    }
    @DeleteMapping("/{id}")
    public Result deleteInput(@PathVariable Integer id){
        Result result = inputService.deleteInput(id);
        return result;
    }
    @PutMapping("/{id}")
    public Result editInput(@PathVariable Integer id, @RequestBody InputDto inputDto){
        Result result = inputService.editInput(id, inputDto);
        return result;
    }
}
