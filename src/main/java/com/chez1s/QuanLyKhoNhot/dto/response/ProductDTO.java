package com.chez1s.QuanLyKhoNhot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
