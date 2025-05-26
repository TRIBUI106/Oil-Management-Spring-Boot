package brand_service.service;

import brand_service.entity.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAll();

    Brand getBrandByID(int id);

    int addBrand(String brandName);

    int updateBrandNameByID(int id, String name);

    int deleteBrandByID(int id);

}
