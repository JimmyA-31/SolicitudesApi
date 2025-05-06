package com.coudevi.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BaseResponseDto<T> {
    private Boolean success;
    private String message;
    private T data;
    private List<T> items;

    public BaseResponseDto() {}

    // Constructor público con parámetros
    public BaseResponseDto(Boolean success, String message, T data, List<T> items) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.items = items;
    }
}
