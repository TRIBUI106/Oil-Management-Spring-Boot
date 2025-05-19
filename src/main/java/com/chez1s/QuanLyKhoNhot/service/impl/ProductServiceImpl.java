package com.chez1s.QuanLyKhoNhot.service.impl;

import com.chez1s.QuanLyKhoNhot.entity.Product;
import com.chez1s.QuanLyKhoNhot.mapper.ProductMapper;
import com.chez1s.QuanLyKhoNhot.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public List<Product> getAllProduct() {
        return productMapper.getAllProduct();
    }

    // Insert nhớt
    @Override
    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        productMapper.deleteProductById(id);
    }

    @Override
    public void updateProductById(Product product) {
        productMapper.updateProductById(product);
    }





}
