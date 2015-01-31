package constraint_propagation.binomial;

import constraint_propagation.Connector;
import constraint_propagation.binomial.Multiplier;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplierTest {

    private Multiplier multiplier;
    private Connector left;
    private Connector right;
    private Connector result;

    @Before
    public void setup() {
        left = new Connector();
        right = new Connector();
        result = new Connector();
        multiplier = new Multiplier(left, right, result);
    }

    @Test
    public void product_test() {
        left.setValue(10, multiplier);
        right.setValue(10, multiplier);

        multiplier.newValue();
        assertThat(result.getValue()).isEqualTo(100);
    }

    @Test
    public void product_test_2() {
        left.setValue(10, multiplier);
        assertThat(result.getValue()).isEqualTo(0);

        result.setValue(100, multiplier);

        multiplier.newValue();
        assertThat(right.getValue()).isEqualTo(10);
    }

    @Test
    public void product_test_3() {
        right.setValue(10, multiplier);
        assertThat(result.getValue()).isEqualTo(0);

        result.setValue(100, multiplier);

        multiplier.newValue();
        assertThat(left.getValue()).isEqualTo(10);
    }

    @Test
    public void forget_test() {
        left.setValue(2, multiplier);
        right.setValue(3, multiplier);
        result.setValue(4, multiplier);

        multiplier.forgetValue();

        assertThat(left.hasValue()).isEqualTo(false);
        assertThat(left.getValue()).isEqualTo(null);

        assertThat(right.hasValue()).isEqualTo(false);
        assertThat(right.getValue()).isEqualTo(null);

        assertThat(result.hasValue()).isEqualTo(false);
        assertThat(result.getValue()).isEqualTo(null);
    }
}
