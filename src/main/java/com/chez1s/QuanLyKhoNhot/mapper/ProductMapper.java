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


    @Select("select p.product_id, \n" +
            "       p.product_code, \n" +
            "       p.product_name, \n" +
            "       p.capacity, \n" +
            "       p.brand, \n" +
            "       p.brand, \n" +
            "       p.currentStock, \n" +
            "       p.newStock\n" +
            "from products p")
    List<Product> getAllProduct();


}
