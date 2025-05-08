package com.chez1s.QuanLyKhoNhot.controller;

import com.chez1s.QuanLyKhoNhot.entity.Product;
import com.chez1s.QuanLyKhoNhot.handler.ApiRespone;
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

    /**
     * @return Danh sách nhớt
     */
    @GetMapping("get")
    public ResponseEntity<ApiRespone<List<Product>>> getAllProduct() {
        List<Product> products = productService.getAllProduct();
        ApiRespone<List<Product>> response = ApiRespone.<List<Product>>builder()
                .success(true)
                .message("Success")
                .data(products)
                .build();
        return ResponseEntity.ok(response);
    }


    @PostMapping("post")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.insertProduct(product);
        return ResponseEntity.ok("Thêm sản phẩm thành công!");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Xoá sản phẩm thành công!");
    }

    @PutMapping("put")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        productService.updateProductById(product);
        return ResponseEntity.ok("Cập nhật sản phẩm thành công!");
    }

}