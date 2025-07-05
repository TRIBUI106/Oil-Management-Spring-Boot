package com.chez1s.QuanLyKhoNhot.service.impl;

import com.chez1s.QuanLyKhoNhot.dto.response.PageableResponse;
import com.chez1s.QuanLyKhoNhot.entity.Brand;
import com.chez1s.QuanLyKhoNhot.enums.Message;
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
        return brandMapper.getAllBrand();
    }

    @Override
    public Brand getBrandByID(int id) {
        return brandMapper.getBrandById(id);
    }

    @Override
    public int addBrand(String s) {
        return brandMapper.addBrand(s);
    }

    @Override
    public int updateBrandNameByID(int i, String s) {
        return brandMapper.updateBrandById(i, s);
    }

    @Override
    public int deleteBrandByID(int id) {
        return brandMapper.deleteBrandById(id);
    }

    @Override
    public PageableResponse<Brand> findBrandWithPageable(int page, int size) {
        //Xử lý logic
        //Tính OFFSET dựa vào size được truyền vào
        int offset = (page - 1) * size;

        List<Brand> content = brandMapper.findBrandWithPageable(offset, size);

        int totalElements = brandMapper.getAllBrand().size();

        return PageableResponse.<Brand>builder()
                .success(true)
                .message(Message.API_SUCCESS.getContent())
                .content(content)
                .pageNumber(page)
                .pageSize(size)
                .totalElements(totalElements)
                .build();
    }
}
