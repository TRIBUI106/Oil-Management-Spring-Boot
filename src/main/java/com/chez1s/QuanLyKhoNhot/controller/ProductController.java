package com.chez1s.QuanLyKhoNhot.controller;

import com.chez1s.QuanLyKhoNhot.dto.response.ProductDTO;
import com.chez1s.QuanLyKhoNhot.entity.Product;
import com.chez1s.QuanLyKhoNhot.handler.ApiRespone;
import com.chez1s.QuanLyKhoNhot.handler.ApiResponeHelper;
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
    public ResponseEntity<ApiRespone<List<Product>>> getAllProduct() {
        try {
            List<Product> products = productService.getAllProduct();
            return ApiResponeHelper.success(products, "Lấy danh sách sản phẩm thành công");
        } catch (Exception e) {
            return ApiResponeHelper.error("Lỗi khi lấy danh sách sản phẩm: " + e.getMessage());
        }
    }

    @GetMapping("get-for-ui")
    public ResponseEntity<ApiRespone<List<ProductDTO>>> getForUI() {
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

            return ApiResponeHelper.success(productDTOs, "Lấy danh sách sản phẩm cho UI thành công");
        } catch (Exception e) {
            return ApiResponeHelper.error("Lỗi khi lấy danh sách sản phẩm cho UI: " + e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<ApiRespone<String>> addProduct(@RequestBody Product product) {
        try {
            productService.insertProduct(product);
            return ApiResponeHelper.success(null, "Thêm sản phẩm thành công");
        } catch (Exception e) {
            return ApiResponeHelper.error("Lỗi khi thêm sản phẩm: " + e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiRespone<String>> deleteProduct(@PathVariable Integer id) {
        try {
            productService.deleteProductById(id);
            return ApiResponeHelper.success(null, "Xoá sản phẩm thành công");
        } catch (Exception e) {
            return ApiResponeHelper.error("Lỗi khi xoá sản phẩm: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<ApiRespone<String>> updateProduct(@RequestBody Product product) {
        try {
            productService.updateProductById(product);
            return ApiResponeHelper.success(null, "Cập nhật sản phẩm thành công");
        } catch (Exception e) {
            return ApiResponeHelper.error("Lỗi khi cập nhật sản phẩm: " + e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ApiRespone<List<Product>>> searchProducts(@RequestParam String keyword) {
        try {
            List<Product> products = productService.getByKeywords(keyword);
            return ApiResponeHelper.success(products, "Danh sách sản phẩm với tìm kiếm " + keyword);
        } catch (Exception e) {
            return ApiResponeHelper.error("Lỗi khi cập nhật sản phẩm: " + e.getMessage());
        }
    }
}
