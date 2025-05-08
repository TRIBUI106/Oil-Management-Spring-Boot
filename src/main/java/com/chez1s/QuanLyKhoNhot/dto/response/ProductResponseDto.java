package com.chez1s.QuanLyKhoNhot.dto.response;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDto {

    Integer id;
    String name;
    String capacity;
    String brand;
    Integer currentStock;
    Integer newStock;
}
