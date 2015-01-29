package simulation.digital_circuits.component.enums;

import java.util.function.Supplier;

public enum Signal {
    ROW, HIGH;

    public static Signal ifOneThenZero(Supplier<Boolean> predicate) {
        if (predicate.get()) return HIGH;
        else return ROW;
    }
}