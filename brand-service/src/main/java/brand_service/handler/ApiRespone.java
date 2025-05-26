package brand_service.handler;

import lombok.*;

//@Data

/// / @Data nó là cả @Getter @Setter @toString @EqualsAndHashCode, @RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ApiRespone<T> {

    private boolean success;
    private String status;
    private String message;
    private T data;

}
