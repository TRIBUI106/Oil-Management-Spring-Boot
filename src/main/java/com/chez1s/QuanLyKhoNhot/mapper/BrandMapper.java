package com.chez1s.QuanLyKhoNhot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public class BrandMapper {

    @Select(SELECT id, brand from brands)
    List getAll

}
