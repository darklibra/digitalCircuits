package circuits;

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
        a.setSignal(Wire.ONE);
        b.setSignal(Wire.ZERO);

        assertThat(sum.getSignal()).isEqualTo(Wire.ONE);
        assertThat(c.getSignal()).isEqualTo(Wire.ZERO);
    }

    @Test
    public void test2() {
        a.setSignal(Wire.ZERO);
        b.setSignal(Wire.ONE);

        assertThat(sum.getSignal()).isEqualTo(Wire.ONE);
        assertThat(c.getSignal()).isEqualTo(Wire.ZERO);
    }

    @Test
    public void test3() {
        a.setSignal(Wire.ONE);
        b.setSignal(Wire.ONE);

        assertThat(sum.getSignal()).isEqualTo(Wire.ZERO);
        assertThat(c.getSignal()).isEqualTo(Wire.ONE);
    }
}
