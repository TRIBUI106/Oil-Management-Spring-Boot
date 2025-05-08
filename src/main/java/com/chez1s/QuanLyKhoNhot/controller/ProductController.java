package com.chez1s.QuanLyKhoNhot.controller;

import com.chez1s.QuanLyKhoNhot.entity.Product;
import com.chez1s.QuanLyKhoNhot.handler.ApiRespone;
import com.chez1s.QuanLyKhoNhot.handler.ApiResponeHelper;
import com.chez1s.QuanLyKhoNhot.service.ProductService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Báo hiệu thằng này là 1 cái Controller, tức là RestAPI
@RequestMapping("api/v1/oil")
// Cái này là cái gì thì tôi không biết
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("get")
    public ResponseEntity<ApiRespone<List<Product>>> getAllProduct() {
        List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(ApiRespone.<List<Product>>builder()
                .success(true)
                .code("200")
                .message("Lấy danh sách sản phẩm thành công")
                .data(products)
                .build());
    }

    @PostMapping("post")
    public ResponseEntity<ApiRespone<String>> addProduct(@RequestBody Product product) {
        productService.insertProduct(product);
        return ResponseEntity.ok(ApiRespone.<String>builder()
                .success(true)
                .code("200")
                .message("Thêm sản phẩm thành công")
                .data(null)
                .build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiRespone<String>> deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok(ApiRespone.<String>builder()
                .success(true)
                .code("200")
                .message("Xoá sản phẩm thành công")
                .data(null)
                .build());
    }

    @PutMapping("put")
    public ResponseEntity<ApiRespone<String>> updateProduct(@RequestBody Product product) {
        productService.updateProductById(product);
        return ResponseEntity.ok(ApiRespone.<String>builder()
                .success(true)
                .code("200")
                .message("Cập nhật sản phẩm thành công")
                .data(null)
                .build());
    }

}