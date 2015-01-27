package component.impl;

import component.Wire;
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
    public void expect_false_output_passing_true_false() {
        output.setSignal(Wire.ONE);
        inputA.setSignal(Wire.ONE);
        inputB.setSignal(Wire.ZERO);

        assertThat(inputA.getSignal()).isEqualTo(Wire.ONE);
        assertThat(inputB.getSignal()).isEqualTo(Wire.ZERO);
        assertThat(output.getSignal()).isEqualTo(Wire.ZERO);
    }

    @Test
    public void expect_false_output_passing_false_true() {
        output.setSignal(Wire.ONE);
        inputA.setSignal(Wire.ZERO);
        inputB.setSignal(Wire.ONE);

        assertThat(inputA.getSignal()).isEqualTo(Wire.ZERO);
        assertThat(inputB.getSignal()).isEqualTo(Wire.ONE);
        assertThat(output.getSignal()).isEqualTo(Wire.ZERO);
    }

    @Test
    public void expect_false_output_passing_true_true() {
        output.setSignal(Wire.ZERO);
        inputA.setSignal(Wire.ONE);
        inputB.setSignal(Wire.ONE);

        assertThat(inputA.getSignal()).isEqualTo(Wire.ONE);
        assertThat(inputB.getSignal()).isEqualTo(Wire.ONE);
        assertThat(output.getSignal()).isEqualTo(Wire.ONE);
    }
}
