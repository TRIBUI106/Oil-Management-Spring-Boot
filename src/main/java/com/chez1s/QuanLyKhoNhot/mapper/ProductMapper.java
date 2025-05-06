package com.chez1s.QuanLyKhoNhot.mapper;

import com.chez1s.QuanLyKhoNhot.entity.Product;
import org.apache.ibatis.annotations.*;
// CRUD nha
import java.util.List;

@Mapper
public interface ProductMapper {

    // Get toàn bộ sản phẩm nhớt
    @Select("SELECT p.product_id AS id, \n" +
            "       p.product_code AS code, \n" +
            "       p.product_name AS name, \n" +
            "       p.capacity AS capacity, \n" +
            "       p.brand AS brand, \n" +
            "       p.currentStock AS currentStock, \n" +
            "       p.newStock AS newStock \n" +
            "FROM products p")
    List<Product> getAllProduct();

    // Post ( thêm sản phẩm nhớt vào )
    @Insert("INSERT INTO products (product_code, product_name, capacity, brand, current_stock, new_stock) " +
            "VALUES (#{code}, #{name}, #{capacity}, #{brand}, #{currentStock}, #{newStock})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertProduct(Product product);


}
