package com.chez1s.QuanLyKhoNhot.service;

import com.chez1s.QuanLyKhoNhot.entity.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAll();

    Brand getBrandByID(int id);

    int addBrand(String brandName);

    int updateBrandNameByID(int id, String name);

    int deleteBrandByID(int id);


}
