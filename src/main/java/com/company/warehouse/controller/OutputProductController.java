package com.company.warehouse.controller;

import com.company.warehouse.entity.InputProduct;
import com.company.warehouse.entity.OutputProduct;
import com.company.warehouse.payload.InputProductDto;
import com.company.warehouse.payload.OutputProductDto;
import com.company.warehouse.payload.Result;
import com.company.warehouse.service.InputProductService;
import com.company.warehouse.service.OutputProductService;
import com.company.warehouse.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outputproduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;

    @PostMapping
    public Result addoutputProduct(@RequestBody OutputProductDto outputProductDto){
        Result result = outputProductService.addOutputProduct(outputProductDto);
        return result;
    }
    @GetMapping
    public List<OutputProduct> getOutputProducts(){
        List<OutputProduct> outputProductList = outputProductService.getOutputProductList();
        return outputProductList;
    }
    @GetMapping("/{id}")
    public OutputProduct getOutputProduct(@PathVariable Integer id){
        OutputProduct outputProduct = outputProductService.getOutputProduct(id);
        return outputProduct;
    }
    @DeleteMapping("/{id}")
    public Result deleteOutputProduct(@PathVariable Integer id){
        Result result = outputProductService.deleteOutputProduct(id);
        return result;
    }
    @PutMapping("/{id}")
    public Result editOutputProduct(@PathVariable Integer id,@RequestBody OutputProductDto outputProductDto){
        Result result = outputProductService.editOutputProduct(id, outputProductDto);
        return result;
    }
}
