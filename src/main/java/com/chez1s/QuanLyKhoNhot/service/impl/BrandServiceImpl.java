package com.chez1s.QuanLyKhoNhot.service.impl;

import com.chez1s.QuanLyKhoNhot.entity.Brand;
import com.chez1s.QuanLyKhoNhot.mapper.BrandMapper;
import com.chez1s.QuanLyKhoNhot.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    @Override
    public List<Brand> getAll() {
        return brandMapper.getAll();
    }

    @Override
    public int getBrandByID(int id) {
        return brandMapper.getBrandByID(id);
    }

    @Override
    public int addBrand(String s) {
        return brandMapper.addBrand(s);
    }

    @Override
    public int updateBrandNameByID(int i, String s) {
        return brandMapper.updateBrand(i, s);
    }

    @Override
    public int deleteBrandByID(int id) {
        return brandMapper.deleteBrand(id);
    }
}
