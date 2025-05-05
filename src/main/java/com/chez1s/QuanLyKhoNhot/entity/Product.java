package com.chez1s.QuanLyKhoNhot.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity
public class Product {

    Integer id;
    String code;
    String name;
    String capacity;
    String brand;
    Integer currentStock;
    Integer newStock;

}
