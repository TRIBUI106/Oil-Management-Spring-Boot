package com.chez1s.QuanLyKhoNhot.handler;

import lombok.*;

//@Data
//// @Data nó là cả @Getter @Setter @toString @EqualsAndHashCode, @RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ApiResponse<T> {

    private boolean success;
    private String status;
    private String message;
    private T data;

}
