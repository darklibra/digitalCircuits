package simulation.digital_circuits.component.elements;

import simulation.digital_circuits.component.enums.Signal;
import simulation.digital_circuits.component.Wire;

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

    protected void applyAndGateAction(Wire target) {
        target.addAction(() -> output.setSignal(logicalOr()) );
    }

    protected Signal logicalOr() {
        return Signal.ifOneThenZero(() -> inputA.getSignal() == Signal.ONE || inputB.getSignal() == Signal.ONE);
    }
}
