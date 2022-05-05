package com.company.warehouse.repository;

import com.company.warehouse.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputRepository extends JpaRepository<Output,Integer> {
    Warehouse findByWarehouseId(Integer warehouse_id);
    Client findByClientId(Integer clientId);
    Currency findByCurrencyId(Integer currency_id);
}
