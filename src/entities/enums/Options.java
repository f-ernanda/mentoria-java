package entities.enums;

import java.util.Arrays;

public enum Options {
    ADD("1"),
    READ("2"),
    UPDATE("3"),
    DELETE("4"),
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
