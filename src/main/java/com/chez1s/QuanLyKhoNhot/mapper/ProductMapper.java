package com.chez1s.QuanLyKhoNhot.mapper;

import com.chez1s.QuanLyKhoNhot.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getAllProduct();

    void insertProduct(Product product);

    void deleteProductById(Integer id);

    void updateProductById(Product product);

    List<Product> getByKeywords(String s);
}
