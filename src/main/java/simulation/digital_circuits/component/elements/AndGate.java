package simulation.digital_circuits.component.elements;

import simulation.digital_circuits.component.Wire;
import simulation.digital_circuits.component.enums.Signal;

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

    protected void applyAndGateAction(Wire target) {
        target.addAction( () -> output.setSignal(logicalAnd()) );
    }

    protected Signal logicalAnd() {
        return Signal.ifOneThenZero(() -> inputA.getSignal() == Signal.ONE && inputB.getSignal() == Signal.ONE);
    }
}
