package com.company.warehouse.repository;

import com.company.warehouse.entity.Input;
import com.company.warehouse.entity.InputProduct;
import com.company.warehouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {

    Product findByProductId(Integer product_id);

    Input findByInputId(Integer input_id);
}
