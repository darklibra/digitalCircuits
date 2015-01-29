package simulation.digital_circuits.component.elements;

import simulation.digital_circuits.component.Wire;
import simulation.digital_circuits.component.enums.Signal;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AndGateTest {

    private AndGate ag;
    private Wire inputA;
    private Wire inputB;
    private Wire output;

    @Before
    public void setup() {
        inputA = new Wire();
        inputB = new Wire();
        output = new Wire();

        ag = new AndGate(inputA, inputB, output);
    }

    @Test
    public void expect_zero_output_when_passed_one_zero() {
        output.setSignal(Signal.HIGH);

        inputA.setSignal(Signal.HIGH);
        inputB.setSignal(Signal.ROW);

        assertThat(output.getSignal()).isEqualTo(Signal.ROW);
    }

    @Test
    public void expect_zero_output_when_passed_zero_one() {
        output.setSignal(Signal.HIGH);

        inputA.setSignal(Signal.ROW);
        inputB.setSignal(Signal.HIGH);

        assertThat(output.getSignal()).isEqualTo(Signal.ROW);
    }

    @Test
    public void expect_one_output_when_passed_one_one() {
        output.setSignal(Signal.ROW);

        inputA.setSignal(Signal.HIGH);
        inputB.setSignal(Signal.HIGH);

        assertThat(output.getSignal()).isEqualTo(Signal.HIGH);
    }
}
