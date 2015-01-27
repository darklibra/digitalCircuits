package component.impl;

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

    private byte logicalNot() {
        if (input.getSignal() == Wire.ZERO) return Wire.ONE;
        else if (input.getSignal() == Wire.ONE) return Wire.ZERO;
        else throw new IllegalArgumentException("Invalid signal");
    }
}
