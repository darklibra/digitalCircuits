package simulation.digital_circuits.agenda;

import simulation.digital_circuits.component.CircuitsAction;

import simulation.digital_circuits.component.elements.AndGate;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgendaTest {

    private Agenda agenda;

    @Before
    public void setup() {
        agenda = new Agenda();
    }

    @Test
    public void empty_test() {
        assertThat(agenda.isEmpty()).isEqualTo(true);
    }

    @Test
    public void add_event_test() {
        agenda.addAction(1, () -> { });

        assertThat(agenda.isEmpty()).isEqualTo(false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void expect_exception_when_passed_wrong_time() {
        agenda.setCurrentTime(3);

        agenda.addAction(2, () -> { });
    }

    @Test
    public void first_item_test() {
        CircuitsAction action = () -> {};

        agenda.addAction(1, action);
        agenda.addAction(2, () -> {});

        assertThat(agenda.firstItem()).isEqualTo(action);
    }

    @Test
    public void first_item_test_2() {
        agenda.addAction(2, () -> {
        });
        agenda.firstItem();

        assertThat(agenda.getCurrentTime()).isEqualTo(2);
    }

    @Test
    public void remove_first_item_test() {
        CircuitsAction action = () -> {};

        agenda.addAction(1, () -> {});
        agenda.addAction(1, action);

        agenda.removeFirstItem();
        assertThat(agenda.firstItem()).isEqualTo(action);
    }

    @Test
    public void remove_first_item_test_2() {
        CircuitsAction action = () -> {};

        agenda.addAction(2, action);
        agenda.addAction(1, () -> {});

        agenda.removeFirstItem();
        assertThat(agenda.firstItem()).isEqualTo(action);
    }

    @Test
    public void delay_time_test() {
        agenda.setDelayTime(AndGate.class.getName(), 3);
        assertThat(agenda.getDelayTime(AndGate.class.getName())).isEqualTo(3);
    }

}