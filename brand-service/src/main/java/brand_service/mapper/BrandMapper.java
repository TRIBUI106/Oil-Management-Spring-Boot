package brand_service.mapper;

import brand_service.entity.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {
    List<Brand> getAllBrand();

    Brand getBrandById(Integer id);

    int addBrand(String name);

    int updateBrandById(Integer id, String name);

    int deleteBrandById(Integer id);
}
