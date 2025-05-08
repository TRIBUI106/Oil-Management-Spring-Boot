package com.chez1s.QuanLyKhoNhot.dto.response;

import lombok.*;

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
