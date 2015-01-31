package simulation.digital_circuits.agenda

import org.junit.Before
import simulation.digital_circuits.component.CircuitsAction
import simulation.digital_circuits.component.elements.AndGate
import spock.lang.Specification

class AgendaPropagateTestGroovy extends Specification {
    private agenda, action, agendaPropagate;

    @Before
    public void setup() {
        agenda = new Agenda();
        action = Mock(CircuitsAction.class);
        agendaPropagate = new AgendaPropagate(agenda);
    }

    def "AgendaPropagate의 propagate 함수를 호출 시 등록된 Action을 실행 및 시간을 변경 하는지 확인"() {
        given:
        def saveTime = 2;

        when:
        agenda.addAction(saveTime, action);
        agendaPropagate.propagate();

        then:
        1 * action.run();
        agenda.getCurrentTime() == saveTime;
    }

    def "등록된 Action이 propagate함수를 실행하면 모두 실행 되는지 테스트 한다."() {
        def lastActionTime = 4
        when:
        agenda.addAction(2, action);
        agenda.addAction(2, action);
        agenda.addAction(lastActionTime, action);
        agendaPropagate.propagate();

        then:
        3 * action.run();
        agenda.getCurrentTime() == lastActionTime;
    }
}
