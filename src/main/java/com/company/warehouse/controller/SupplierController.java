package com.company.warehouse.controller;

import com.company.warehouse.entity.Supplier;
import com.company.warehouse.payload.Result;
import com.company.warehouse.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @PostMapping
    public Result addSupplier(@RequestBody Supplier supplier){
        Result result = supplierService.addSupplier(supplier);
        return result;
    }
    @GetMapping
    public List<Supplier> getSuppliers(){
        List<Supplier> suppliers = supplierService.getSuppliers();
        return suppliers;
    }
    @GetMapping("/{id}")
    public Supplier getSupplier(@PathVariable Integer id){
        Supplier supplier = supplierService.getSupplier(id);
        return supplier;
    }
    @PutMapping("/{id}")
    public Result editSupplier(@PathVariable Integer id, @RequestBody Supplier supplier){
        Result result = supplierService.editSupplier(id, supplier);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteSupplier(@PathVariable Integer id){
        Result result = supplierService.deleteSupplier(id);
        return result;
    }

}
