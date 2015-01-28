package circuits;

import component.enums.Signal;
import component.Wire;
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
        a.setSignal(Signal.ONE);
        b.setSignal(Signal.ZERO);

        assertThat(sum.getSignal()).isEqualTo(Signal.ONE);
        assertThat(c.getSignal()).isEqualTo(Signal.ZERO);
    }

    @Test
    public void test2() {
        a.setSignal(Signal.ZERO);
        b.setSignal(Signal.ONE);

        assertThat(sum.getSignal()).isEqualTo(Signal.ONE);
        assertThat(c.getSignal()).isEqualTo(Signal.ZERO);
    }

    @Test
    public void test3() {
        a.setSignal(Signal.ONE);
        b.setSignal(Signal.ONE);

        assertThat(sum.getSignal()).isEqualTo(Signal.ZERO);
        assertThat(c.getSignal()).isEqualTo(Signal.ONE);
    }
}
