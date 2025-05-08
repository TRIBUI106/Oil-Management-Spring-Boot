package com.chez1s.QuanLyKhoNhot.dto;

import lombok.*;
import org.apache.ibatis.annotations.ConstructorArgs;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private String capacity;
    private String brand;
    private Integer currentStock;
    private Integer newStock;
}
