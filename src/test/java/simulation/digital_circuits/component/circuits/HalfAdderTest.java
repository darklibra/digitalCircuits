package simulation.digital_circuits.component.circuits;

import simulation.digital_circuits.component.Wire;
import simulation.digital_circuits.component.enums.Signal;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HalfAdderTest {

    private Wire a, b;
    private Wire sum, c;
    private HalfAdder halfAdder;

    @Before
    public void setup() {
        a = new Wire();
        b = new Wire();
        sum = new Wire();
        c = new Wire();

        halfAdder = new HalfAdder(a, b, sum, c);
    }

    @Test
    public void test1() {
        a.setSignal(Signal.HIGH);
        b.setSignal(Signal.ROW);

        assertThat(sum.getSignal()).isEqualTo(Signal.HIGH);
        assertThat(c.getSignal()).isEqualTo(Signal.ROW);
    }

    @Test
    public void test2() {
        a.setSignal(Signal.ROW);
        b.setSignal(Signal.HIGH);

        assertThat(sum.getSignal()).isEqualTo(Signal.HIGH);
        assertThat(c.getSignal()).isEqualTo(Signal.ROW);
    }

    @Test
    public void test3() {
        a.setSignal(Signal.HIGH);
        b.setSignal(Signal.HIGH);

        assertThat(sum.getSignal()).isEqualTo(Signal.ROW);
        assertThat(c.getSignal()).isEqualTo(Signal.HIGH);
    }
}
