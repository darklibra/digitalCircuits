package component;

import component.enums.Signal;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WireTest {

    private Wire wire;

    @Before
    public void setup() {
        wire = new Wire();
    }

    @Test
    public void default_signal_test() {
        assertThat(wire.getSignal()).isEqualTo(Signal.ZERO);
    }

    @Test
    public void set_signal_test() {
        wire.setSignal(Signal.ONE);
        assertThat(wire.getSignal()).isEqualTo(Signal.ONE);

        wire.setSignal(Signal.ZERO);
        assertThat(wire.getSignal()).isEqualTo(Signal.ZERO);
    }

    @Test
    public void expect_run_when_add_action_and_set_signal() {
        List<Integer> items = Lists.newArrayList();

        wire.addAction(() -> items.add(1));
        assertThat(items.size()).isEqualTo(1);

        wire.setSignal(Signal.ONE);
        assertThat(items.size()).isEqualTo(2);

        wire.setSignal(Signal.ZERO);
        assertThat(items.size()).isEqualTo(3);
    }

    @Test
    public void expect_not_run_when_passed_same_signal() {
        List<Integer> items = Lists.newArrayList();

        wire.addAction(() -> items.add(1));

        wire.setSignal(Signal.ONE);
        assertThat(items.size()).isEqualTo(2);

        wire.setSignal(Signal.ONE);
        assertThat(items.size()).isEqualTo(2);
    }
}