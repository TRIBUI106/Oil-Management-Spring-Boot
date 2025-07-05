package com.chez1s.QuanLyKhoNhot.handler;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PageableResponse<T> {

    private boolean success;

    private String message;

    private List<T> content;

    private int pageNumber;

    private int pageSize;

    private long totalElements;

}
