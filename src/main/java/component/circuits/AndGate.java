package component.circuits;

import component.enums.Signal;
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

    private Signal logicalAnd() {
        return Signal.ifOneThenZero(() -> inputA.getSignal() == Signal.ONE && inputB.getSignal() == Signal.ONE);
    }
}
