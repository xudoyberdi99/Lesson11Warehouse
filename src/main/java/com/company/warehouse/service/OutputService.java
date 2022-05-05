package com.company.warehouse.service;

import com.company.warehouse.entity.*;
import com.company.warehouse.payload.InputDto;
import com.company.warehouse.payload.OutputDto;
import com.company.warehouse.payload.Result;
import com.company.warehouse.repository.InputRepository;
import com.company.warehouse.repository.OutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;

    public Result addOutput(OutputDto outputDto){
        Output output=new Output();

        Warehouse getWarehouseId = outputRepository.findByWarehouseId(outputDto.getWarehouseId());
        output.setWarehouse(getWarehouseId);
        Client byClientId = outputRepository.findByClientId(outputDto.getClientId());
        output.setClient(byClientId);
        Currency getCurrencyId = outputRepository.findByCurrencyId(outputDto.getCurrencyId());
        output.setCurrency(getCurrencyId);
        output.setFactureNumber(outputDto.getFactureNumber());
        output.setCode("1");
        outputRepository.save(output);
        return new Result("add input",true);
    }

    public List<Output> getOutputList(){
        List<Output> all = outputRepository.findAll();
        return all;
    }

    public Output getOutput(Integer id){
        Optional<Output> output = outputRepository.findById(id);
        if (output.isPresent()){
            Output output1 = output.get();
            return output1;
        }
        return new Output();
    }

    public Result deleteOutput(Integer id){
        outputRepository.deleteById(id);
        return new Result("uchirildi",true);
    }

    public Result editOutput(Integer id,OutputDto outputDto){
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (!optionalOutput.isPresent()){
            return new Result("not found input",true);
        }
        Currency byCurrencyId = outputRepository.findByCurrencyId(outputDto.getCurrencyId());
        Client byClientId = outputRepository.findByClientId(outputDto.getClientId());
        Warehouse byWarehouseId = outputRepository.findByWarehouseId(outputDto.getWarehouseId());
        Output output = optionalOutput.get();
        output.setCurrency(byCurrencyId);
        output.setClient(byClientId);
        output.setWarehouse(byWarehouseId);
        output.setFactureNumber(output.getFactureNumber());
        output.setCode("2");
        outputRepository.save(output);
        return new Result("edit Input",true);
    }
}
