package com.company.warehouse.service;

import com.company.warehouse.entity.Supplier;
import com.company.warehouse.payload.Result;
import com.company.warehouse.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Result addSupplier(Supplier supplier){
        boolean existsByPhoneNumber = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (existsByPhoneNumber){
            return new Result("Bunaqa taminotchi bazada bor", false);
        }
        Supplier supplier1=new Supplier();
        supplier1.setName(supplier.getName());
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepository.save(supplier1);
        return new Result("taminotchi bazaga qushildi", true);
    }
    public List<Supplier> getSuppliers(){
        List<Supplier> all = supplierRepository.findAll();
        return all;
    }
    public Supplier getSupplier(Integer id){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        return optionalSupplier.orElseGet(Supplier::new);
    }
    public Result deleteSupplier(Integer id){
        supplierRepository.deleteById(id);
        return new Result("taminotchi uchirildi",true,supplierRepository.findById(id).get().getId()+"shu id li");
    }

    public Result editSupplier(Integer id, Supplier supplier){
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent()){
            return new Result("bunday taminotchi mavjud emas",false);
        }
        Supplier supplier1 = optionalSupplier.get();
        supplier1.setName(supplier.getName());
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplier1.setActive(true);
        supplierRepository.save(supplier1);
        return new Result("edit supplier date",true);
    }
}
