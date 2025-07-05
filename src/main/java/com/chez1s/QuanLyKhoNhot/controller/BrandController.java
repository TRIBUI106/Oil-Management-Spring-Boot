package com.chez1s.QuanLyKhoNhot.controller;

import com.chez1s.QuanLyKhoNhot.dto.request.CreationBranchDTO;
import com.chez1s.QuanLyKhoNhot.entity.Brand;
import com.chez1s.QuanLyKhoNhot.handler.ApiResponse;
import com.chez1s.QuanLyKhoNhot.handler.ApiResponseHelper;
import com.chez1s.QuanLyKhoNhot.handler.PageableResponse;
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
    public Brand getBrandByID(@PathVariable("id") int id) {
        return brandService.getBrandByID(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> insertBrand(@RequestBody CreationBranchDTO cbd) {
        try {
            String s = cbd.getName();
            brandService.addBrand(s);
            return ApiResponseHelper.success(null, "Thêm thương hiệu thành công ! Tên : " + s);
        } catch (Exception e) {
            return ApiResponseHelper.error("Lỗi khi thêm thương hiệu" + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateBrand(@PathVariable("id") int id, @RequestBody Brand brand) {
        try {
            brandService.updateBrandNameByID(id, brand.getName());
            return ApiResponseHelper.success(null, "Cập nhật thương hiệu thành công ! ID : " + id + " / Tên mới : " + brand.getName());
        } catch (Exception e) {
            return ApiResponseHelper.error("Lỗi khi cập nhật thương hiệu: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Integer>> delelteBrand(@PathVariable("id") int id) {
        try {
            brandService.deleteBrandByID(id);
            return ApiResponseHelper.success(null, "Xoá thương hiệu thành công ! ID : " + id);
        } catch (Exception e) {
            return ApiResponseHelper.error("Lỗi khi xoá thương hiệu: " + e.getMessage());
        }
    }

    @GetMapping("/search")
    public PageableResponse<Brand> searchBrand(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return brandService.findBrandWithPageable(page, size);
    }
}