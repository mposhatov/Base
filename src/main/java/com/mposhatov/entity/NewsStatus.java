package com.mposhatov.entity;

import java.util.Arrays;

public enum NewsStatus {
    CREATED(0),
    PUBLISHED(1),
    UNPUBLISHED(2);

    private Integer code;

    NewsStatus(Integer code) {
        this.code = code;
    }

    public static NewsStatus byCode(int code) {
        return Arrays.stream(values())
                .filter(role -> role.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown code: " + code));
    }

    public Integer getCode() {
        return code;
    }
}
