package simulation.digital_circuits.component.circuits;

import simulation.digital_circuits.component.Wire;
import simulation.digital_circuits.component.elements.AndGate;
import simulation.digital_circuits.component.elements.Inverter;
import simulation.digital_circuits.component.elements.OrGate;

public class HalfAdder {
    public HalfAdder(Wire inputA, Wire inputB, Wire sum, Wire outputC) {
        Wire d = new Wire();
        Wire e = new Wire();

        new OrGate(inputA, inputB, d);
        new AndGate(inputA, inputB, outputC);
        new Inverter(outputC, e);
        new AndGate(d, e, sum);
    }
}
