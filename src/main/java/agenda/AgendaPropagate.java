package agenda;

import component.CircuitsAction;

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
