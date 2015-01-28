package agenda;

import component.Wire;
import component.elements.AndGate;
import component.elements.Inverter;
import component.elements.OrGate;

import java.util.Optional;

public class AgendaCircuitsFactory {
    public static String INVERTER_DELAY_NAME = Inverter.class.getName();
    public static String OR_GATE_DELAY_NAME = OrGate.class.getName();
    public static String AND_GATE_DELAY_NAME = AndGate.class.getName();

    private Agenda agenda;
    private AgendaPropagate agendaPropagate;

    public AgendaCircuitsFactory(Agenda agenda) {
        this.agenda = agenda;
    }

    public AgendaPropagate getPropagate() {
        return Optional.ofNullable(agendaPropagate).orElseGet(() -> {
            agendaPropagate = new AgendaPropagate(agenda);
            return agendaPropagate;
        });
    }

    public Inverter newInverter(Wire input, Wire output) {
        return new Inverter(input, output) {
            @Override
            protected void applyInverterAction(Wire target) {
                target.addAction( () -> agenda.addAction(agenda.getCurrentTime() + agenda.getDelayTime(INVERTER_DELAY_NAME), () ->  output.setSignal(logicalNot())));
            }
        };
    }

    public OrGate newOrGate(Wire inputA, Wire inputB, Wire output) {
        return new OrGate(inputA, inputB, output) {
            @Override
            protected void applyAndGateAction(Wire target) {
                target.addAction( () -> agenda.addAction(agenda.getCurrentTime() + agenda.getDelayTime(OR_GATE_DELAY_NAME), () ->  output.setSignal(logicalOr())));
            }
        };
    }

    public AndGate newAndGate(Wire inputA, Wire inputB, Wire output) {
        return new AndGate(inputA, inputB, output) {
            @Override
            protected void applyAndGateAction(Wire target) {
                target.addAction( () -> agenda.addAction(agenda.getCurrentTime() + agenda.getDelayTime(AND_GATE_DELAY_NAME), () ->  output.setSignal(logicalAnd())));
            }
        };
    }
}
