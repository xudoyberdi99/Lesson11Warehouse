package com.company.warehouse.repository;

import com.company.warehouse.entity.User;
import com.company.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
    Set<Warehouse> findAllByWarehousesId(Integer warehouses_id);
}
