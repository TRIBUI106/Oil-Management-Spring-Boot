package com.chez1s.QuanLyKhoNhot.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private String capacity;
    private String brand;
    private Integer currentStock;
    private Integer newStock;
}
