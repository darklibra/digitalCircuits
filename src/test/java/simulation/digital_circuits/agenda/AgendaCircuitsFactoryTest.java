package simulation.digital_circuits.agenda;

import simulation.digital_circuits.component.Wire;
import simulation.digital_circuits.component.elements.AndGate;
import simulation.digital_circuits.component.elements.Inverter;
import simulation.digital_circuits.component.elements.OrGate;
import simulation.digital_circuits.component.enums.Signal;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgendaCircuitsFactoryTest {
    private AgendaCircuitsFactory agendaCircuitsFactory;
    private Agenda agenda;
    private AgendaPropagate agendaPropagate;

    @Before
    public void setup() {
        agenda = new Agenda();
        agendaCircuitsFactory = new AgendaCircuitsFactory(agenda);
        agendaPropagate = agendaCircuitsFactory.getPropagate();
    }

    @Test
    public void inverter_test() {
        agenda.setDelayTime(AgendaCircuitsFactory.INVERTER_DELAY_NAME, 3);
        Wire input = new Wire();
        Wire output = new Wire();
        input.setSignal(Signal.ONE);
        output.setSignal(Signal.ONE);

        Inverter inverter = agendaCircuitsFactory.newInverter(input, output);

        assertThat(agenda.getCurrentTime()).isEqualTo(0);
        assertThat(output.getSignal()).isEqualTo(Signal.ONE);

        agendaPropagate.propagate();

        assertThat(output.getSignal()).isEqualTo(Signal.ZERO);
        assertThat(agenda.getCurrentTime()).isEqualTo(3);

        input.setSignal(Signal.ZERO);
        assertThat(output.getSignal()).isEqualTo(Signal.ZERO);

        agendaPropagate.propagate();

        assertThat(output.getSignal()).isEqualTo(Signal.ONE);
        assertThat(agenda.getCurrentTime()).isEqualTo(6);
    }

    @Test
    public void orgate_test() {
        agenda.setDelayTime(AgendaCircuitsFactory.OR_GATE_DELAY_NAME, 3);

        Wire inputA = new Wire();
        Wire inputB = new Wire();
        Wire output = new Wire();

        OrGate orGate = agendaCircuitsFactory.newOrGate(inputA, inputB, output);

        inputA.setSignal(Signal.ONE);
        assertThat(output.getSignal()).isEqualTo(Signal.ZERO);
        assertThat(agenda.getCurrentTime()).isEqualTo(0);

        agendaPropagate.propagate();
        assertThat(output.getSignal()).isEqualTo(Signal.ONE);
        assertThat(agenda.getCurrentTime()).isEqualTo(3);

        inputB.setSignal(Signal.ONE);
        assertThat(agenda.getCurrentTime()).isEqualTo(3);

        agendaPropagate.propagate();
        assertThat(agenda.getCurrentTime()).isEqualTo(6);

        inputA.setSignal(Signal.ZERO);
        inputB.setSignal(Signal.ZERO);

        agendaPropagate.propagate();
        assertThat(output.getSignal()).isEqualTo(Signal.ZERO);
        assertThat(agenda.getCurrentTime()).isEqualTo(9);
    }

    @Test
    public void andgate_test() {
        agenda.setDelayTime(AgendaCircuitsFactory.AND_GATE_DELAY_NAME, 3);

        Wire inputA = new Wire();
        Wire inputB = new Wire();
        Wire output = new Wire();

        AndGate andGate = agendaCircuitsFactory.newAndGate(inputA, inputB, output);

        inputA.setSignal(Signal.ONE);
        inputB.setSignal(Signal.ONE);
        assertThat(agenda.getCurrentTime()).isEqualTo(0);

        agendaPropagate.propagate();
        assertThat(output.getSignal()).isEqualTo(Signal.ONE);
        assertThat(agenda.getCurrentTime()).isEqualTo(3);

        inputB.setSignal(Signal.ZERO);
        assertThat(agenda.getCurrentTime()).isEqualTo(3);

        agendaPropagate.propagate();
        assertThat(output.getSignal()).isEqualTo(Signal.ZERO);
        assertThat(agenda.getCurrentTime()).isEqualTo(6);
    }

}
