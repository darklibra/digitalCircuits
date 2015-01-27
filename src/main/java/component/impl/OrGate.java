package component.impl;

import component.Wire;

public class OrGate {
    private final Wire inputA, inputB;
    private final Wire output;

    public OrGate(Wire inputA, Wire inputB, Wire output) {
        this.inputA = inputA;
        this.inputB = inputB;
        this.output = output;

        applyAndGateAction(inputA);
        applyAndGateAction(inputB);
    }

    private void applyAndGateAction(Wire target) {
        target.addAction( () -> output.setSignal(logicalOr()) );
    }

    private byte logicalOr() {
        if (!validateInputs()) throw new IllegalArgumentException("Invalid signal");
        else if (inputA.getSignal() == Wire.ONE || inputB.getSignal() == Wire.ONE) return Wire.ONE;
        else return Wire.ZERO;
    }

    private boolean validateInputs() {
        return Wire.validSignal(inputA) && Wire.validSignal(inputB);
    }
}
