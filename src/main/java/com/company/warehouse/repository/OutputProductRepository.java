package com.company.warehouse.repository;

import com.company.warehouse.entity.Input;
import com.company.warehouse.entity.Output;
import com.company.warehouse.entity.OutputProduct;
import com.company.warehouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputProductRepository extends JpaRepository<OutputProduct,Integer> {
    Product findByProductId(Integer product_id);

    Output findByOutputId(Integer output_id);
}
