package com.chez1s.QuanLyKhoNhot.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    Integer id;
    String code;
    String name;
    String capacity;
    String brand;
    Integer currentStock;
    Integer newStock;

}
