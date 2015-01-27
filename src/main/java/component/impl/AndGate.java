package component.impl;

import component.Wire;

public class AndGate {
    private final Wire inputA, inputB;
    private final Wire output;

    public AndGate(Wire inputA, Wire inputB, Wire output) {
        this.inputA = inputA;
        this.inputB = inputB;
        this.output = output;

        applyAndGateAction(inputA);
        applyAndGateAction(inputB);
    }

    private void applyAndGateAction(Wire target) {
        target.addAction( () -> output.setSignal(logicalAnd()) );
    }

    private byte logicalAnd() {
        if (!validateInputs()) throw new IllegalArgumentException("Invalid signal");
        else if (inputA.getSignal() == Wire.ONE && inputB.getSignal() == Wire.ONE) return Wire.ONE;
        else return 0;
    }

    private boolean validateInputs() {
        return Wire.validSignal(inputA) && Wire.validSignal(inputB);
    }
}
