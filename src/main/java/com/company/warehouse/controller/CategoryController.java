package com.company.warehouse.controller;

import com.company.warehouse.entity.Category;
import com.company.warehouse.payload.CategoryDto;
import com.company.warehouse.payload.Result;
import com.company.warehouse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.addCategory(categoryDto);
        return result;
    }
    //all category
    @GetMapping
    public List<Category> getCategorys(){
        List<Category> categorys = categoryService.getCategorys();
        return categorys;
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Integer id){
        Category category = categoryService.getCategory(id);
        return category;
    }

    @DeleteMapping("/{id}")
    public Result deleteCategory(@PathVariable Integer id){
        Result result = categoryService.DeleteCategory(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result editCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        Result result = categoryService.editCategory(id, categoryDto);
        return result;
    }
}
