package com.chez1s.QuanLyKhoNhot.service;

import com.chez1s.QuanLyKhoNhot.entity.Product;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Beans
public interface ProductService {

    List<Product> getAllProduct();

}
