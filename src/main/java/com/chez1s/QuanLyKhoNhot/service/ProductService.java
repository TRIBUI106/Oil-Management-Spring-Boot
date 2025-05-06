package com.chez1s.QuanLyKhoNhot.service;

import com.chez1s.QuanLyKhoNhot.entity.Product;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface ProductService {

    @Bean
    List<Product> getAllProduct();



}
