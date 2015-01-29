package constraint_propagation;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstantTest {
    @Test
    public void constant_test() {
        new Constant(10, new Connector() {
            @Override
            public void setValue(Integer value, Constraint constraint) {
                assertThat(value).isEqualTo(10);
            }
        });
    }

    @Test//(expected = UnsupportedOperationException.class)
    public void constant_test_2() {
        Constant constant = new Constant(10, new Connector());
        constant.newValue();
    }

    @Test//(expected = UnsupportedOperationException.class)
    public void constant_test_3() {
        Constant constant = new Constant(10, new Connector());
        constant.forgetValue();
    }
}
