package dev.fernanda.model.enums;

import java.util.Arrays;

public enum Options {
    CREATE("1"),
    READ("2"),
    READ_ALL("3"),
    UPDATE("4"),
    DELETE("5"),
    EXIT("X"),
    UNKNOWN("-100");

    private final String value;

    Options(final String value){
        this.value = value;
    }

    public static Options fromValue(final String value){
        return Arrays.stream(Options.values())
                .filter( (option) -> value.equals(option.value) )
                .findFirst()
                .orElse(UNKNOWN);

    }
}
