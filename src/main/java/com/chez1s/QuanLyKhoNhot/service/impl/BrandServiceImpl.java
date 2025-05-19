package com.chez1s.QuanLyKhoNhot.service.impl;

import com.chez1s.QuanLyKhoNhot.mapper.BrandMapper;
import com.chez1s.QuanLyKhoNhot.service.BrandService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandServiceImpl implements BrandService {

    BrandMapper brandMapper;

    


}
