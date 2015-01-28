package simulation.digital_circuits.component.circuits;

import simulation.digital_circuits.component.Wire;
import simulation.digital_circuits.component.elements.AndGate;
import simulation.digital_circuits.component.elements.Inverter;
import simulation.digital_circuits.component.elements.OrGate;

public class HalfAdder {
    private final OrGate orGate;
    private final AndGate andGate;
    private final Inverter inverter;
    private final AndGate andGate1;
    private final Wire d;
    private final Wire e;

    private final Wire inputA, inputB;
    private final Wire sum, outputC;

    public HalfAdder(Wire inputA, Wire inputB, Wire sum, Wire outputC) {
        this.inputA = inputA;
        this.inputB = inputB;
        this.sum = sum;
        this.outputC = outputC;

        d = new Wire();
        orGate = new OrGate(inputA, inputB, d);
        andGate = new AndGate(inputA, inputB, outputC);
        e = new Wire();
        inverter = new Inverter(outputC, e);
        andGate1 = new AndGate(d, e, sum);
    }
}
