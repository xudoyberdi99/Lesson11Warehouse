package com.company.warehouse.service;

import com.company.warehouse.entity.Currency;
import com.company.warehouse.entity.Input;
import com.company.warehouse.entity.Supplier;
import com.company.warehouse.entity.Warehouse;
import com.company.warehouse.payload.InputDto;
import com.company.warehouse.payload.Result;
import com.company.warehouse.repository.InputRepository;
import com.company.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;

    public Result addInput(InputDto inputDto){
        Input input=new Input();
        input.setDate(inputDto.getDate());
        Warehouse getWarehouseId = inputRepository.findByWarehouseId(inputDto.getWarehouseId());
        input.setWarehouse(getWarehouseId);
        Supplier getSupplierId = inputRepository.findBySupplierId(inputDto.getSupplierId());
        input.setSupplier(getSupplierId);
        Currency getCurrencyId = inputRepository.findByCurrencyId(inputDto.getCurrencyId());
        input.setCurrency(getCurrencyId);
        input.setFactureNumber(inputDto.getFactureNumber());
        input.setCode("1");
        inputRepository.save(input);
        return new Result("add input",true);
    }

    public List<Input> getInputList(){
        List<Input> all = inputRepository.findAll();
        return all;
    }

    public Input getInput(Integer id){
        Optional<Input> inputOptional = inputRepository.findById(id);
        if (inputOptional.isPresent()){
            Input input = inputOptional.get();
            return input;
        }
        return new Input();
    }

    public Result deleteInput(Integer id){
        inputRepository.deleteById(id);
        return new Result("uchirildi",true);
    }

    public Result editInput(Integer id,InputDto inputDto){
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent()){
            return new Result("not found input",true);
        }
        Currency byCurrencyId = inputRepository.findByCurrencyId(inputDto.getCurrencyId());
        Supplier bySupplierId = inputRepository.findBySupplierId(inputDto.getSupplierId());
        Warehouse byWarehouseId = inputRepository.findByWarehouseId(inputDto.getWarehouseId());
        Input input = optionalInput.get();
        input.setCurrency(byCurrencyId);
        input.setSupplier(bySupplierId);
        input.setWarehouse(byWarehouseId);
        input.setFactureNumber(inputDto.getFactureNumber());
        input.setCode("2");
        inputRepository.save(input);
        return new Result("edit Input",true);
    }
}
