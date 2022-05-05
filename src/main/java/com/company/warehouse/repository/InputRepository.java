package com.company.warehouse.repository;

import com.company.warehouse.entity.Currency;
import com.company.warehouse.entity.Input;
import com.company.warehouse.entity.Supplier;
import com.company.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input,Integer> {
    Warehouse findByWarehouseId(Integer warehouse_id);
    Supplier findBySupplierId(Integer supplier_id);
    Currency findByCurrencyId(Integer currency_id);
}
