package com.company.warehouse.service;

import com.company.warehouse.entity.*;
import com.company.warehouse.payload.InputProductDto;
import com.company.warehouse.payload.OutputProductDto;
import com.company.warehouse.payload.Result;
import com.company.warehouse.repository.OutputProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputProductRepository outputProductRepository;


    public Result addOutputProduct(OutputProductDto outputProductDto){
        OutputProduct outputProduct=new OutputProduct();
        Product productId = outputProductRepository.findByProductId(outputProductDto.getProductId());
        Output output = outputProductRepository.findByOutputId(outputProductDto.getOutputId());
        outputProduct.setProduct(productId);
        outputProduct.setOutput(output);
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProductRepository.save(outputProduct);
        return new Result("Input product add",true);
    }
    public List<OutputProduct> getOutputProductList(){
        List<OutputProduct> all = outputProductRepository.findAll();
        return all;
    }
    public OutputProduct getOutputProduct(Integer id){
        Optional<OutputProduct> outputProductOptional= outputProductRepository.findById(id);
        if (outputProductOptional.isPresent()){
            OutputProduct outputProduct = outputProductOptional.get();
            return outputProduct;
        }

        return new OutputProduct();
    }
    public Result deleteOutputProduct(Integer id){
        outputProductRepository.deleteById(id);
        return new Result("delete input product",true);
    }

    public Result editOutputProduct(Integer id,OutputProductDto outputProductDto){
        Optional<OutputProduct> outputProductOptional = outputProductRepository.findById(id);
        if (!outputProductOptional.isPresent()){
            return new Result("not found inputProduct",false);
        }
        Output getOutput = outputProductRepository.findByOutputId(outputProductDto.getOutputId());
        Product getProductId = outputProductRepository.findByProductId(outputProductDto.getProductId());
        OutputProduct outputProduct = outputProductOptional.get();
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProduct.setProduct(getProductId);
        outputProduct.setOutput(getOutput);
        outputProductRepository.save(outputProduct);
        return new Result("edit input Product",true);
    }
}
