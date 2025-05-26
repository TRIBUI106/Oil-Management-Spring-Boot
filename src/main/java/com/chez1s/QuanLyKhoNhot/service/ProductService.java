package com.chez1s.QuanLyKhoNhot.service;

import com.chez1s.QuanLyKhoNhot.entity.Product;

import java.util.List;


public interface ProductService {

    List<Product> getAllProduct();

    void insertProduct(Product product);

    void deleteProductById(Integer id);

    void updateProductById(Product product);

    List<Product> getByKeywords(String keywords);

}
