package constraint_propagation.binomial;

import constraint_propagation.Connector;
import constraint_propagation.binomial.Adder;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdderTest {

    private Adder adder;
    private Connector left;
    private Connector right;
    private Connector result;

    @Before
    public void setup() {
        left = new Connector();
        right = new Connector();
        result = new Connector();
        adder = new Adder(left, right, result);
    }

    @Test
    public void add_test () {
        left.setValue(1, adder);
        right.setValue(2, adder);
        adder.newValue();

        assertThat(result.getValue()).isEqualTo(3);
    }

    @Test
    public void result_test () {
        left.setValue(3, adder);
        result.setValue(4, adder);
        adder.newValue();

        assertThat(right.getValue()).isEqualTo(1);
    }

    @Test
    public void result_test_2 () {
        result.setValue(5, adder);
        right.setValue(2, adder);
        adder.newValue();

        assertThat(left.getValue()).isEqualTo(3);
    }

    @Test
    public void forget_test() {
        left.setValue(2, adder);
        right.setValue(3, adder);
        result.setValue(4, adder);

        adder.forgetValue();

        assertThat(left.hasValue()).isEqualTo(false);
        assertThat(left.getValue()).isEqualTo(null);

        assertThat(right.hasValue()).isEqualTo(false);
        assertThat(right.getValue()).isEqualTo(null);

        assertThat(result.hasValue()).isEqualTo(false);
        assertThat(result.getValue()).isEqualTo(null);
    }
}
