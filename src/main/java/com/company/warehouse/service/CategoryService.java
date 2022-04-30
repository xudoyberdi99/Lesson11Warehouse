package com.company.warehouse.service;

import com.company.warehouse.entity.Category;
import com.company.warehouse.payload.CategoryDto;
import com.company.warehouse.payload.Result;
import com.company.warehouse.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Result addCategory(CategoryDto categoryDto){
        Category category=new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId()!=null){
            Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalParentCategory.isPresent())
                return new Result("bunday ota kategoriya mavjud emas", false);
                category.setParentCategory(optionalParentCategory.get());
        }
        categoryRepository.save(category);
        return new Result("kategoriya muvaffaqiyatli qushildi", true);
    }

    public List<Category> getCategorys(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
    public Category getCategory(Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            return category;
        }
        return new Category();
    }
    public Result DeleteCategory(Integer id){
        categoryRepository.deleteById(id);
        return new Result("kategoriya uchirildi",true);
    }
    public Result editCategory(Integer id, CategoryDto categoryDto){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent()){
            return new Result("bunaqa kategorya mavjud emas", false);
        }
        Optional<Category> categoryOptional = categoryRepository.findById(categoryDto.getParentCategoryId());
        if (!categoryOptional.isPresent()){
            return new Result("ota kategoriyasi mavjud emas", false);
        }
        Category parentCategory = categoryOptional.get();
        Category category = optionalCategory.get();
        category.setName(categoryDto.getName());
        category.setParentCategory(parentCategory);
        category.setActive(true);
        categoryRepository.save(category);
        return new Result("kategoriya uzgartirildi",true);
    }
}
