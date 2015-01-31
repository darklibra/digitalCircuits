package simulation.digital_circuits.agenda

import org.junit.Before
import simulation.digital_circuits.component.CircuitsAction
import simulation.digital_circuits.component.Wire
import simulation.digital_circuits.component.enums.Signal
import spock.lang.Specification

class AgendaCircuitsFactoryTestGroovy extends Specification {
    private agenda, action, agendaPropagate, agendaCircuitsFactory
    private static inverterDelayTime = 3;
    private static orGateDelayTime = 3;
    private static andGateDelayTime = 3;

    @Before
    public void setup() {
        agenda = new Agenda();
        action = Mock(CircuitsAction.class);
        agendaCircuitsFactory = new AgendaCircuitsFactory(agenda);
        agendaPropagate = agendaCircuitsFactory.getPropagate();

        agenda.setDelayTime(AgendaCircuitsFactory.INVERTER_DELAY_NAME, inverterDelayTime);
        agenda.setDelayTime(AgendaCircuitsFactory.OR_GATE_DELAY_NAME, orGateDelayTime);
        agenda.setDelayTime(AgendaCircuitsFactory.AND_GATE_DELAY_NAME, andGateDelayTime);
    }

    def "Factory에서 생성된 Inverter 동작 확인"() {
        given:
        def input = new Wire();
        def output = new Wire();

        expect:
        input.setSignal(init)
        agendaCircuitsFactory.newInverter(input, output);
        if (run) agendaPropagate.propagate();

        agenda.getCurrentTime() == b;
        output.getSignal() == c;

        where:
        init | run | b | c
        Signal.ROW | false | 0 | Signal.ROW
        Signal.ROW | true | inverterDelayTime | Signal.HIGH
    }

    def "Factory에서 생성된 OrGate 동작 확인"() {
        given:
        def left = new Wire();
        def right = new Wire();
        def output = new Wire();

        expect:
        left.setSignal(initLeft)
        right.setSignal(initRight)
        agendaCircuitsFactory.newOrGate(left, right, output);
        if (run) agendaPropagate.propagate();

        agenda.getCurrentTime() == time;
        output.getSignal() == out;

        where:
        initLeft | initRight | run | time | out
        Signal.HIGH | Signal.ROW | false | 0 | Signal.ROW
        Signal.HIGH | Signal.ROW | true | orGateDelayTime | Signal.HIGH
    }

    def "Factory에서 생성된 AndGate 동작 확인"() {
        given:
        def left = new Wire();
        def right = new Wire();
        def output = new Wire();

        expect:
        left.setSignal(initLeft)
        right.setSignal(initRight)
        agendaCircuitsFactory.newAndGate(left, right, output);
        if (run) agendaPropagate.propagate();

        agenda.getCurrentTime() == time;
        output.getSignal() == out;

        where:
        initLeft | initRight | run | time | out
        Signal.HIGH | Signal.HIGH | false | 0 | Signal.ROW
        Signal.HIGH | Signal.HIGH | true | andGateDelayTime | Signal.HIGH
    }
}