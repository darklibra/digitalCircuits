package component.circuits;

import component.enums.Signal;
import component.Wire;

public class Inverter {
    private final Wire input;
    private final Wire output;

    public Inverter(Wire input, Wire output) {
        this.input = input;
        this.output = output;

        applyInverterAction(input);
    }

    private void applyInverterAction(Wire target) {
        target.addAction( () -> output.setSignal(logicalNot()) );
    }

    private Signal logicalNot() {
        if (input.getSignal() == Signal.ZERO) return Signal.ONE;
        else if (input.getSignal() == Signal.ONE) return Signal.ZERO;
        else throw new IllegalArgumentException("Invalid signal");
    }
}
