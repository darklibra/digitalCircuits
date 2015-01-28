package simulation.digital_circuits.component.circuits;

import simulation.digital_circuits.component.Wire;
import org.junit.Before;
import org.junit.Test;

public class FullAdderTest {
    private Wire inputA, inputB, inputC;
    private Wire sum, outputC;
    private FullAdder fullAdder;

    @Before
    public void setup() {
        inputA = new Wire();
        inputB = new Wire();
        inputC = new Wire();
        sum = new Wire();
        outputC = new Wire();
    }

    @Test
    public void create() {
        setup();
        fullAdder = new FullAdder(inputA, inputB, inputC, sum, outputC);
    }

}
