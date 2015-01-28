package simulation.digital_circuits.component.elements;

import simulation.digital_circuits.component.Wire;
import simulation.digital_circuits.component.enums.Signal;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrGateTest {

    private OrGate og;
    private Wire inputA;
    private Wire inputB;
    private Wire output;

    @Before
    public void setup() {
        inputA = new Wire();
        inputB = new Wire();
        output = new Wire();

        og = new OrGate(inputA, inputB, output);
    }

    @Test
    public void expect_one_output_when_passed_one_zero() {
        output.setSignal(Signal.ZERO);

        inputA.setSignal(Signal.ONE);
        inputB.setSignal(Signal.ZERO);

        assertThat(output.getSignal()).isEqualTo(Signal.ONE);
    }

    @Test
    public void expect_one_output_when_passed_zero_one() {
        output.setSignal(Signal.ZERO);

        inputA.setSignal(Signal.ZERO);
        inputB.setSignal(Signal.ONE);

        assertThat(output.getSignal()).isEqualTo(Signal.ONE);
    }

    @Test
    public void expect_zero_output_when_passed_zero_zero() {
        output.setSignal(Signal.ONE);

        inputA.setSignal(Signal.ZERO);

        inputB.setSignal(Signal.ONE);
        inputB.setSignal(Signal.ZERO);

        assertThat(output.getSignal()).isEqualTo(Signal.ZERO);
    }
}
