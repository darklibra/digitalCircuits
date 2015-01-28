package agenda;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AgendaPropagateTest {
    Agenda agenda;
    AgendaPropagate agendaPropagate;
    private List<Integer> accu;


    @Before
    public void setup() {
        agenda = new Agenda();
        accu = Lists.newArrayList();
        agendaPropagate = new AgendaPropagate(agenda);
    }

    @Test
    public void propagate_test() {

        agenda.addAction(2, () -> { accu.add(0); });
        agendaPropagate.propagate();

        assertThat(agenda.getCurrentTime()).isEqualTo(2);
        assertThat(accu.size()).isEqualTo(1);
    }

    @Test
    public void propagate_test_2() {
        agenda.addAction(2, () -> { accu.add(0);  });
        agenda.addAction(3, () -> { accu.add(0); });
        agendaPropagate.propagate();

        assertThat(agenda.getCurrentTime()).isEqualTo(3);
        assertThat(accu.size()).isEqualTo(2);
    }

    @Test
    public void propagate_test_3() {
        agenda.addAction(2, () -> { accu.add(0); });
        agenda.addAction(2, () -> { accu.add(0); });
        agenda.addAction(3, () -> { accu.add(0); });
        agendaPropagate.propagate();

        assertThat(agenda.getCurrentTime()).isEqualTo(3);
        assertThat(accu.size()).isEqualTo(3);
    }
}
