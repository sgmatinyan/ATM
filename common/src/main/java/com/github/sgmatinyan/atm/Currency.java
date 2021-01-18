package com.github.sgmatinyan.atm;

import lombok.Getter;

@Getter
public enum Currency {
    RUR("RUR","рубль"); //только рубль пока

    private String code;
    private String name;

    private Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
