package simulation.digital_circuits.component.elements;

import simulation.digital_circuits.component.Wire;
import simulation.digital_circuits.component.enums.Signal;

public class Inverter {
    private final Wire input;
    private final Wire output;

    public Inverter(Wire input, Wire output) {
        this.input = input;
        this.output = output;

        applyInverterAction(input);
    }

    protected void applyInverterAction(Wire target) {
        target.addAction( () -> output.setSignal(logicalNot()) );
    }

    protected Signal logicalNot() {
        if (input.getSignal() == Signal.ZERO) return Signal.ONE;
        else if (input.getSignal() == Signal.ONE) return Signal.ZERO;
        else throw new IllegalArgumentException("Invalid signal");
    }
}
