package component.impl;

import component.Wire;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InverterTest {

    private Wire input;
    private Wire output;
    private Inverter inverter;

    @Before
    public void setup() {
        input = new Wire();
        output = new Wire();

        inverter = new Inverter(input, output);
    }

    @Test
    public void invert_test() {
        input.setSignal(Wire.ZERO);
        assertThat(output.getSignal()).isEqualTo(Wire.ONE);

        input.setSignal(Wire.ONE);
        assertThat(output.getSignal()).isEqualTo(Wire.ZERO);
    }
}
