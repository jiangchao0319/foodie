package com.imooc.enums;

public enum Sex {
    women(0,"女"),
    man(1, "男"),
    secret(2, "保密");

    private final Integer type;
    private final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
