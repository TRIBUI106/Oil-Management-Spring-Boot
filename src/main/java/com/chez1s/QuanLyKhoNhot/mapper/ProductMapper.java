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
            "       p.current_stock AS currentStock, \n" +
            "       p.new_stock AS newStock \n" +
            "FROM products p")
    List<Product> getAllProduct();

    // Post ( thêm sản phẩm nhớt vào )
    @Insert("INSERT INTO products (product_name, capacity, brand, current_stock, new_stock) " +
            "VALUES (#{p.name}, #{p.capacity}, #{p.brand}, #{p.currentStock}, #{p.newStock})")
    void insertProduct(@Param("p") Product product);

    // Cai nay la xoa product ne
    @Delete("DELETE FROM products WHERE product_id = #{i}")
    void deleteProductById(@Param("i") Integer id);

    // Cai nay la update nha
    @Update("UPDATE products SET " +
            "product_code = #{p.code}, " +
            "product_name = #{p.name}, " +
            "capacity = #{p.capacity}, " +
            "brand = #{p.brand}, " +
            "current_stock = #{p.currentStock}, " +
            "new_stock = #{p.newStock} " +
            "WHERE product_id = #{p.id}")
    void updateProductById(@Param("p") Product product);



}
