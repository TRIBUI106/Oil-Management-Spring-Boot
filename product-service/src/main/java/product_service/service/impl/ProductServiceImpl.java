package product_service.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import product_service.entity.Product;
import product_service.mapper.ProductMapper;
import product_service.service.ProductService;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public List<Product> getAllProduct() {
        return productMapper.getAllProduct();
    }

    // Insert nhớt
    @Override
    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        productMapper.deleteProductById(id);
    }

    @Override
    public void updateProductById(Product product) {
        productMapper.updateProductById(product);
    }


}
