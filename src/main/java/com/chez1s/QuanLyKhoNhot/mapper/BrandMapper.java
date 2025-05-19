package com.chez1s.QuanLyKhoNhot.mapper;

import com.chez1s.QuanLyKhoNhot.entity.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BrandMapper {

    @Select("SELECT id, name from brands")
    List<Brand> getAll();

    @Select("SELECT id, name from brands WHERE id = #{id}")
    Brand getBrandByID(@Param("id") int i);

    @Insert("INSERT INTO brands VALUE (#{name})")
    int addBrand(@Param("name") String s);
}
