package product_service.mapper;


import org.apache.ibatis.annotations.Mapper;
import product_service.entity.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getAllProduct();

    void insertProduct(Product product);

    void deleteProductById(Integer id);

    void updateProductById(Product product);
}
