package com.chez1s.QuanLyKhoNhot.enums;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Message {

    API_SUCCESS("SUCCESS", "Message trả"),
    ;

    private final String content;

    private final String description;

}
