package constraint_propagation;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectorTest {
    private Connector connector;

    @Before
    public void setup() {
        connector = new Connector();
    }

    @Test
    public void has_value_test() {
        assertThat(connector.hasValue()).isEqualTo(false);
    }

    @Test
    public void get_and_set_value_test() {
        int value = 6;
        connector.setValue(value, null);
        assertThat(connector.getValue()).isEqualTo(value);
    }

    @Test
    public void forget_value_test() {
        connector.setValue(6, null);
        connector.forgetValue(null);
        assertThat(connector.hasValue()).isEqualTo(false);
        assertThat(connector.getValue()).isEqualTo(null);
    }

    @Test(expected = RuntimeException.class)
    public void twice_call_set_value_with_not_same_value() {
        connector.setValue(6, null);
        connector.setValue(7, null);
    }

    @Test
    public void twice_call_set_value_with_same_value() {
        connector.setValue(6, null);
        connector.setValue(6, null);
    }

    @Test
    public void connect_test() {
        List<Integer> list = Lists.newArrayList();
        connector.connect(new Constraint() {
            @Override
            public void newValue() {
                list.add(1);
            }
            @Override
            public void forgetValue() {}
        });
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void connect_test_2() {
        List<Integer> list = Lists.newArrayList();
        connector.setValue(20, null);
        connector.connect(new Constraint() {
            @Override
            public void newValue() {
                list.add(1);
            }
            @Override
            public void forgetValue() {}
        });
        assertThat(list.size()).isEqualTo(1);
    }
}