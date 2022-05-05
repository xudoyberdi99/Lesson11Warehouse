package com.company.warehouse.controller;

import com.company.warehouse.entity.Output;
import com.company.warehouse.payload.OutputDto;
import com.company.warehouse.payload.Result;
import com.company.warehouse.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;

    @PostMapping
    public Result addOutput(@RequestBody OutputDto outputDto){
        Result result = outputService.addOutput(outputDto);
        return result;
    }

    @GetMapping
    public List<Output> getOutputList(){
        List<Output> outputList = outputService.getOutputList();
        return outputList;
    }

    @GetMapping("/{id}")
    public Output getOutput(@PathVariable Integer id){
        Output output = outputService.getOutput(id);
        return output;
    }

    @DeleteMapping("/{id}")
    public Result deleteOutput(@PathVariable Integer id){
        Result result = outputService.deleteOutput(id);
        return result;
    }
    @PutMapping("/{id}")
    public Result editOutput(@PathVariable Integer id, @RequestBody OutputDto outputDto){
        Result result = outputService.editOutput(id, outputDto);
        return result;
    }
}
