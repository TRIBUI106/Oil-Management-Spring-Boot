package com.chez1s.QuanLyKhoNhot.mapper;

import com.chez1s.QuanLyKhoNhot.entity.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BrandMapper {

    @Select("SELECT id, name from brands")
    List<Brand> getAll();

    @Select("SELECT id, name from brands WHERE id = #{id}")
    int getBrandByID(@Param("id") int i);

    @Insert("INSERT INTO brands(`name`) VALUE (#{name})")
    int addBrand(@Param("name") String s);

    @Update("UPDATE brands " +
            "SET name = #{name} " +
            "WHERE id = #{id}")
    int updateBrand(@Param("id") int id, @Param("name") String name);

    @Delete("DELETE FROM brand" +
            "WHERE id = #{id}")

}
