package simulation.digital_circuits.agenda;

import simulation.digital_circuits.component.CircuitsAction;

public class AgendaPropagate {
    private Agenda agenda;
    public AgendaPropagate(Agenda agenda) {
        this.agenda = agenda;
    }

    public void propagate() {
        CircuitsAction action = agenda.firstItem();

        while (action != null) {
            action.run();
            agenda.removeFirstItem();
            action = agenda.firstItem();
        }
    }
}
