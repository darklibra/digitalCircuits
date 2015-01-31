package simulation.digital_circuits.agenda

import org.junit.Before
import simulation.digital_circuits.component.CircuitsAction
import simulation.digital_circuits.component.Wire
import simulation.digital_circuits.component.circuits.FullAdder
import simulation.digital_circuits.component.elements.AndGate
import simulation.digital_circuits.component.enums.Signal
import spock.lang.Specification

class AgendaTestGroovy extends Specification {
    private agenda, action;
    @Before
    public void setup() {
        agenda = new Agenda();
        action = Mock(CircuitsAction.class)
    }

    def "일정 있는 상태이 정상동작 하는지 확인"() {
        when:
        agenda.addAction(1, action);

        then:
        agenda.isEmpty() == false
    }

    def "이미 지난 시간에 시간을 가지고 새로운 이벤트로 등록 하면 오류가 발생하는지 확인"() {
        when:
        agenda.setCurrentTime(3);
        agenda.addAction(2, action);

        then:
        thrown(IllegalArgumentException.class)
    }

    def "firstItem을 사용하여 Action을 가져오면 Agenda 시간이 Action이 처음 저장될 때 입력한 시간으로 변경되는지 확인"() {
        given:
        def saveTime = 2;

        when:
        agenda.addAction(saveTime, action);
        agenda.firstItem();

        then:
        agenda.getCurrentTime() == saveTime;
    }

    def "일정에서 가장 작은 시간에 처음으로 입력한 Action을 firstItem 함수에서 정상적으로 가져오는지 확인"() {
        when:
        agenda.addAction(1, action);
        agenda.addAction(2, Mock(CircuitsAction.class));

        then:
        agenda.firstItem() == action;
    }

    def "firstItem으로 아이템 삭제 시에 입력한 순서대로 삭제 되는지 확인"() {
        when:
        agenda.addAction(1, Mock(CircuitsAction.class));
        agenda.addAction(1, action);
        agenda.removeFirstItem();

        then:
        agenda.firstItem() == action;
    }

    def "removeFirstItem이 낮은 시간순으로 삭제 되는지 확인"() {
        when:
        agenda.addAction(2, action);
        agenda.addAction(1, Mock(CircuitsAction.class));
        agenda.removeFirstItem();

        then:
        agenda.firstItem() == action;
    }

    def "이름을 사용하여 지연 시간을 정상적으로 가져 오는지 확인"() {
        given:
        def delayName = AndGate.class.getName();
        def delayTime = 3;

        when:
        agenda.setDelayTime(delayName, delayTime);

        then:
        agenda.getDelayTime(delayName) == delayTime;
    }
}
