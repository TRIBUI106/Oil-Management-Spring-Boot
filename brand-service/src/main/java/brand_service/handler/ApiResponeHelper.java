package brand_service.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponeHelper {

    public static <T> ResponseEntity<ApiRespone<T>> success(T data, String message) {
        ApiRespone<T> response = ApiRespone.<T>builder()
                .success(true)
                .status("200")
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<ApiRespone<T>> error(String message) {
        ApiRespone<T> response = ApiRespone.<T>builder()
                .success(false)
                .status("500")
                .message(message)
                .data(null)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    public static <T> ResponseEntity<ApiRespone<T>> error(String code, String message, HttpStatus status) {
        ApiRespone<T> response = ApiRespone.<T>builder()
                .success(false)
                .status(code)
                .message(message)
                .data(null)
                .build();
        return ResponseEntity.status(status).body(response);
    }
}
