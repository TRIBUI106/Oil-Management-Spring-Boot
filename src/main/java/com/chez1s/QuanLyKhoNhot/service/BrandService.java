package com.chez1s.QuanLyKhoNhot.service;

import com.chez1s.QuanLyKhoNhot.entity.Brand;
import com.chez1s.QuanLyKhoNhot.entity.Product;

import java.util.List;

public interface BrandService {

    List<Brand> getAll();

    Brand getBrandByID(int id);

    int addBrand(String brandName);
}
