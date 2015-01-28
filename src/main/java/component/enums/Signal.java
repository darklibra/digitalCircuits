package component.enums;

import java.util.function.Supplier;

public enum Signal {
    ZERO, ONE;

    public static Signal ifOneThenZero(Supplier<Boolean> predicate) {
        if (predicate.get()) return ONE;
        else return ZERO;
    }
}