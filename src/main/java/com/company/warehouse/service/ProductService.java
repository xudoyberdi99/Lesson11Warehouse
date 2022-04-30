package com.company.warehouse.service;

import com.company.warehouse.entity.Attachment;
import com.company.warehouse.entity.Category;
import com.company.warehouse.entity.Measurement;
import com.company.warehouse.entity.Product;
import com.company.warehouse.payload.ProductDto;
import com.company.warehouse.payload.Result;
import com.company.warehouse.repository.AttachmentRepository;
import com.company.warehouse.repository.CategoryRepository;
import com.company.warehouse.repository.MeasurementRepository;
import com.company.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;


    public Result addProduct(ProductDto productDto){
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        //mahsulotni tekshirish
        if (!existsByNameAndCategoryId){
            return new Result("bunday mahsulot ushbu kategiryada mavud emas",false);
        }
        //categoryni tekshirish
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new Result("Bunday categoriya mavjud emas",false);
        }
        //photoni tekshirish
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if(!optionalAttachment.isPresent()){
            return new Result("Bunday rasm mavjud emas",false);
        }
        // ulchov birligini tekshirish
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent()){
            return new Result("Bunday ulchov birligi  mavjud emas",false);
        }

        Product product=new Product();
        product.setName(productDto.getName());
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        product.setCode("1");
        product.setActive(true);

        productRepository.save(product);
        return new Result("product muvaffaqiyatli qushildi",true);

    }

    //allProduct
    public List<Product> getAllProduct(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    //one product id
    public Product getProduct(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()){
            return new Product();
        }
        Product product = optionalProduct.get();
        return product;
    }

    //delete product
    public Result deleteProduct(Integer id){
        productRepository.deleteById(id);
        return new Result("product uchirildi",true);
    }

    //edit product
    public Result editProduct(Integer id,ProductDto productDto){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()){
            return new Result("bunday product topilmadi", false);
        }

        //categoryni tekshirish
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new Result("Bunday categoriya mavjud emas",false);
        }
        //photoni tekshirish
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if(!optionalAttachment.isPresent()){
            return new Result("Bunday rasm mavjud emas",false);
        }
        // ulchov birligini tekshirish
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalMeasurement.isPresent()){
            return new Result("Bunday ulchov birligi  mavjud emas",false);
        }

        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        product.setCode("1");
        product.setActive(true);

        productRepository.save(product);
        return new Result("product muvaffaqiyatli qushildi",true);

    }

}
