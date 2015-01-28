package component.circuits;

import component.enums.Signal;
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

    private Signal logicalOr() {
        return Signal.ifOneThenZero(() -> inputA.getSignal() == Signal.ONE || inputB.getSignal() == Signal.ONE);
    }
}
