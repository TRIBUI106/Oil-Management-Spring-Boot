package com.chez1s.QuanLyKhoNhot.mapper;

import com.chez1s.QuanLyKhoNhot.entity.Product;
import org.apache.ibatis.annotations.Mapper;
// CRUD nha
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import java.util.List;

@Mapper
public interface ProductMapper {


    @Select("SELECT p.product_id AS id, \n" +
            "       p.product_code AS code, \n" +
            "       p.product_name AS name, \n" +
            "       p.capacity AS capacity, \n" +
            "       p.brand AS brand, \n" +
            "       p.currentStock AS currentStock, \n" +
            "       p.newStock AS newStock \n" +
            "FROM products p")
    List<Product> getAllProduct();



}
