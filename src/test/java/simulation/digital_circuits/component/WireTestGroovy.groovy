package simulation.digital_circuits.component

import simulation.digital_circuits.component.enums.Signal
import spock.lang.Specification

class WireTestGroovy extends Specification {
    def "Set과 Get이 잘되는지 확인"() {
        given:
        def wire = new Wire();

        when:
        wire.setSignal(Signal.HIGH)

        then:
        wire.getSignal() == Signal.HIGH
    }

    def "action과 setSignal 함수가 실행 될 때, action에 저장한 함수가 실행 하는지 확인"() {
        given:
        def wire = new Wire()
        def CircuitsAction action = Mock(CircuitsAction.class);

        when:
        wire.addAction(action)
        wire.setSignal(Signal.HIGH)

        then:
        2 * action.run()
    }
}
