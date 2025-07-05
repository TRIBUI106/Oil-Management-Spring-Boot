package com.chez1s.QuanLyKhoNhot.controller;

import com.chez1s.QuanLyKhoNhot.dto.response.ProductDTO;
import com.chez1s.QuanLyKhoNhot.entity.Product;
import com.chez1s.QuanLyKhoNhot.handler.ApiResponse;
import com.chez1s.QuanLyKhoNhot.handler.ApiResponseHelper;
import com.chez1s.QuanLyKhoNhot.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

// Depen Injection kieu khac
//    @Autowired
//    private ProductService productService;

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProduct() {
        try {
            List<Product> products = productService.getAllProduct();
            return ApiResponseHelper.success(products, "Lấy danh sách sản phẩm thành công");
        } catch (Exception e) {
            return ApiResponseHelper.error("Lỗi khi lấy danh sách sản phẩm: " + e.getMessage());
        }
    }

    @GetMapping("get-for-ui")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getForUI() {
        try {
            List<Product> products = productService.getAllProduct();
            // Chuyển đổi và thêm thông tin nếu cần
            List<ProductDTO> productDTOs = products.stream()
                    .map(product -> new ProductDTO(
                            product.getName(),
                            product.getCapacity(),
                            product.getBrand(),
                            product.getCurrentStock(),
                            product.getNewStock()))
                    .collect(Collectors.toList());

            return ApiResponseHelper.success(productDTOs, "Lấy danh sách sản phẩm cho UI thành công");
        } catch (Exception e) {
            return ApiResponseHelper.error("Lỗi khi lấy danh sách sản phẩm cho UI: " + e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<ApiResponse<String>> addProduct(@RequestBody Product product) {
        try {
            productService.insertProduct(product);
            return ApiResponseHelper.success(null, "Thêm sản phẩm thành công");
        } catch (Exception e) {
            return ApiResponseHelper.error("Lỗi khi thêm sản phẩm: " + e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<String>> deleteProduct(@PathVariable Integer id) {
        try {
            productService.deleteProductById(id);
            return ApiResponseHelper.success(null, "Xoá sản phẩm thành công");
        } catch (Exception e) {
            return ApiResponseHelper.error("Lỗi khi xoá sản phẩm: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<ApiResponse<String>> updateProduct(@RequestBody Product product) {
        try {
            productService.updateProductById(product);
            return ApiResponseHelper.success(null, "Cập nhật sản phẩm thành công");
        } catch (Exception e) {
            return ApiResponseHelper.error("Lỗi khi cập nhật sản phẩm: " + e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Product>>> searchProducts(@RequestParam String keyword) {
        try {
            List<Product> products = productService.getByKeywords(keyword);
            return ApiResponseHelper.success(products, "Danh sách sản phẩm với tìm kiếm " + keyword);
        } catch (Exception e) {
            return ApiResponseHelper.error("Lỗi khi cập nhật sản phẩm: " + e.getMessage());
        }
    }
}
