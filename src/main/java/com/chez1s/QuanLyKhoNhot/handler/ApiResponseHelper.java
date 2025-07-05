package com.chez1s.QuanLyKhoNhot.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseHelper {

    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .status("200")
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(false)
                .status("500")
                .message(message)
                .data(null)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String code, String message, HttpStatus status) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(false)
                .status(code)
                .message(message)
                .data(null)
                .build();
        return ResponseEntity.status(status).body(response);
    }
}
