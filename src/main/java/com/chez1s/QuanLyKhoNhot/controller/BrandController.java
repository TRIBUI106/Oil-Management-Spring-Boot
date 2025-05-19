package com.chez1s.QuanLyKhoNhot.controller;

import com.chez1s.QuanLyKhoNhot.dto.request.CreationBranchDTO;
import com.chez1s.QuanLyKhoNhot.entity.Brand;
import com.chez1s.QuanLyKhoNhot.handler.ApiRespone;
import com.chez1s.QuanLyKhoNhot.handler.ApiResponeHelper;
import com.chez1s.QuanLyKhoNhot.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public int getBrandByID(@PathVariable("id") int id) {
        return brandService.getBrandByID(id);
    }

    @PostMapping
    public ResponseEntity<ApiRespone<String>> insertBrand(@RequestBody CreationBranchDTO cbd) {
        try {
            brandService.addBrand(cbd.getName());
            return ApiResponeHelper.success(null, "Thêm thương hiệu thành công");
        } catch (Exception e) {
            return ApiResponeHelper.error("Lỗi khi thêm thương hiệu" + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiRespone<String>> updateBrand(@PathVariable("id") int id, @RequestBody Brand brand) {
        try {
            brandService.updateBrandNameByID(id, brand.getName());
            return ApiResponeHelper.success(null, "Cập nhật thương hiệu thành công");
        } catch (Exception e) {
            return ApiResponeHelper.error("Lỗi khi cập nhật thương hiệu: " + e.getMessage());
        }
    }


}