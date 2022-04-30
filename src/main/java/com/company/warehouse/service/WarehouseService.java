package com.company.warehouse.service;

import com.company.warehouse.entity.Measurement;
import com.company.warehouse.entity.Warehouse;
import com.company.warehouse.payload.Result;
import com.company.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addWarehouse(Warehouse warehouse){
        boolean byName = warehouseRepository.existsByName(warehouse.getName());
        if (byName){
            return new Result("bunday ombor mavjud",false);
        }

        warehouseRepository.save(warehouse);
        return new Result("muvaffaqiyatli saqlandi",true);
    }

    public List<Warehouse> getWarehouseList(){
        List<Warehouse> all = warehouseRepository.findAll();
        return all;
    }

    public Warehouse getWarehouseId(Integer id){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isPresent()){
            Warehouse warehouse = optionalWarehouse.get();
            return warehouse;
        }
        return new Warehouse();
    }

    public Result deleteWarehouse(Integer id) {
        warehouseRepository.deleteById(id);
        return new Result("warehouse delete", true);
    }

    public Result editWarehouse(Integer id, Warehouse warehouse){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent()){
            return new Result("bunday ombor bazada mavjud emas",false);
        }
        Warehouse warehouse1 = optionalWarehouse.get();
        warehouse1.setName(warehouse.getName());
        warehouse1.setActive(true);
        warehouseRepository.save(warehouse1);
        return new Result("ombor malumotlari uzgartirildi", true);
    }
}
