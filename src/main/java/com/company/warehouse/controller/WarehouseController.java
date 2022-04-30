package com.company.warehouse.controller;

import com.company.warehouse.entity.Measurement;
import com.company.warehouse.entity.Warehouse;
import com.company.warehouse.payload.Result;
import com.company.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @PostMapping
    public Result addWarehouse(@RequestBody Warehouse warehouse){
        Result result = warehouseService.addWarehouse(warehouse);
        return result;
    }

    @GetMapping
    public List<Warehouse> getListWarehouse(){
        List<Warehouse> warehouseList = warehouseService.getWarehouseList();
        return warehouseList ;
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouseId(@PathVariable Integer id){
        Warehouse warehouseId = warehouseService.getWarehouseId(id);
        return warehouseId;
    }
    @DeleteMapping("/{id}")
    public Result deleteMeasurement(@PathVariable Integer id){
        Result result = warehouseService.deleteWarehouse(id);
        return result;
    }
    @PutMapping("/{id}")
    public Result editMeasurement(@PathVariable Integer id, @RequestBody Warehouse warehouse){
        Result result = warehouseService.editWarehouse(id, warehouse);
        return result;
    }
}
