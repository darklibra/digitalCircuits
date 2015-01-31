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
}
