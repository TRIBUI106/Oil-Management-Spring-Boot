package com.chez1s.QuanLyKhoNhot.handler;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiRespone<Object>> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ApiRespone.builder()
                        .success(false)
                        .status("400")
                        .message("Lỗi xử lý: " + ex.getMessage())
                        .data(null)
                        .build()
        );
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ApiRespone<Object>> handleDatabaseException(DataAccessException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiRespone.builder()
                        .success(false)
                        .status("500")
                        .message("Lỗi database: " + ex.getMessage())
                        .data(null)
                        .build()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiRespone<Object>> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiRespone.builder()
                        .success(false)
                        .status("500")
                        .message("Lỗi không xác định: " + ex.getMessage())
                        .data(null)
                        .build()
        );
    }
}
