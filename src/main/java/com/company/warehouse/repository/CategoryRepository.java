package com.company.warehouse.repository;

import com.company.warehouse.entity.Category;
import com.company.warehouse.payload.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
