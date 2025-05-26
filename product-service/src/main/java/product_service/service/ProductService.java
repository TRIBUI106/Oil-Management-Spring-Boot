package product_service.service;


import org.springframework.context.annotation.Bean;
import product_service.entity.Product;

import java.util.List;


public interface ProductService {

    List<Product> getAllProduct();

    void insertProduct(Product product);

    void deleteProductById(Integer id);

    void updateProductById(Product product);


}
