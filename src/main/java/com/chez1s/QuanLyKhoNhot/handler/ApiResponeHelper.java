package com.chez1s.QuanLyKhoNhot.handler;

public class ApiResponeHelper {

    public static <T> ApiRespone<T> success(String message, T data) {
        return ApiRespone.<T>builder()
                .success(true)
                .code("200")
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiRespone<T> failed(String code, String message) {
        return ApiRespone.<T>builder()
                .success(false)
                .code(code)
                .message(message)
                .data(null)
                .build();
    }
    
}