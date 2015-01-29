package simulation.digital_circuits.component.elements;

import simulation.digital_circuits.component.Wire;
import simulation.digital_circuits.component.enums.Signal;
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
        input.setSignal(Signal.ROW);
        assertThat(output.getSignal()).isEqualTo(Signal.HIGH);

        input.setSignal(Signal.HIGH);
        assertThat(output.getSignal()).isEqualTo(Signal.ROW);
    }
}
