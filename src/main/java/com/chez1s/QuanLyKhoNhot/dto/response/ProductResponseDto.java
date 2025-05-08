package com.chez1s.QuanLyKhoNhot.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDto {

    Integer id;
    String name;
    String capacity;
    String brand;
    Integer currentStock;
    Integer newStock;
}
