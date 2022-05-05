package com.company.warehouse.service;

import com.company.warehouse.entity.Input;
import com.company.warehouse.entity.InputProduct;
import com.company.warehouse.entity.Product;
import com.company.warehouse.payload.InputProductDto;
import com.company.warehouse.payload.Result;
import com.company.warehouse.repository.InputProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;

    public Result addInputProduct(InputProductDto inputProductDto){
        InputProduct inputProduct=new InputProduct();
        Product productId = inputProductRepository.findByProductId(inputProductDto.getProductId());
        Input inputId = inputProductRepository.findByInputId(inputProductDto.getInputId());
        inputProduct.setProduct(productId);
        inputProduct.setInput(inputId);
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setExpireDate(new Date());
        inputProductRepository.save(inputProduct);
        return new Result("Input product add",true);
    }
    public List<InputProduct> getInputProductList(){
        List<InputProduct> all = inputProductRepository.findAll();
        return all;
    }
    public InputProduct getInputProduct(Integer id){
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (optionalInputProduct.isPresent()){
            InputProduct inputProduct = optionalInputProduct.get();
            return inputProduct;
        }

        return new InputProduct();
    }
    public Result deleteInputProduct(Integer id){
        inputProductRepository.deleteById(id);
        return new Result("delete input product",true);
    }

    public Result editInputProduct(Integer id,InputProductDto inputProductDto){
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (!optionalInputProduct.isPresent()){
            return new Result("not found inputProduct",false);
        }
        Input getInputId = inputProductRepository.findByInputId(inputProductDto.getInputId());
        Product getProductId = inputProductRepository.findByProductId(inputProductDto.getProductId());
        InputProduct inputProduct = optionalInputProduct.get();
        inputProduct.setExpireDate(new Date());
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setProduct(getProductId);
        inputProduct.setInput(getInputId);
        inputProductRepository.save(inputProduct);
        return new Result("edit input Product",true);
    }


}
