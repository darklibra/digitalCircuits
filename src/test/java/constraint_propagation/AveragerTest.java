package constraint_propagation;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AveragerTest {

    private Averager averager;
    private Connector left;
    private Connector right;
    private Connector result;

    @Before
    public void setup() {
        left = new Connector();
        right = new Connector();
        result = new Connector();
        averager = new Averager(left, right, result);
    }

    @Test
    public void test_1() {
        left.setValue(4, null);
        right.setValue(6, null);

        assertThat(result.getValue()).isEqualTo(5);
    }

    @Test
    public void test_2() {
        left.setValue(4, null);
        result.setValue(5, null);

        assertThat(right.getValue()).isEqualTo(6);
    }

    @Test
    public void test_3() {
        right.setValue(6, null);
        result.setValue(5, null);

        assertThat(left.getValue()).isEqualTo(4);
    }
}
