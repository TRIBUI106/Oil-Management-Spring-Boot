package com.chez1s.QuanLyKhoNhot.controller;

import com.chez1s.QuanLyKhoNhot.handler.ApiRespone;
import com.chez1s.QuanLyKhoNhot.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity responseEntity () {
        
    }

}