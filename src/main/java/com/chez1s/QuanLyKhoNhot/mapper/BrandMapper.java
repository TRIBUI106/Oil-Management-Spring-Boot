package com.chez1s.QuanLyKhoNhot.mapper;

import com.chez1s.QuanLyKhoNhot.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BrandMapper {

    @Select("SELECT id, brand from brands")
    List<Brand> findAll();

}
