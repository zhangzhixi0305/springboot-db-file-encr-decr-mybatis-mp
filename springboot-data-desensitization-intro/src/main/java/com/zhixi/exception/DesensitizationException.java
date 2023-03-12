package com.zhixi.exception;

import lombok.Getter;


@Getter
public class DesensitizationException extends RuntimeException {
    public DesensitizationException(String message) {
        super(message);
    }
}