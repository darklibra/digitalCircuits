package simulation.digital_circuits.component.elements

import simulation.digital_circuits.component.Wire
import simulation.digital_circuits.component.enums.Signal
import spock.lang.Specification

class OrGateTestGroovy extends Specification {
    private left, right
    private output

    def setup() {
        left = new Wire();
        right = new Wire();
        output = new Wire();
        new OrGate(left, right, output)
    }

    def "OrGate Row와 High 값 입력시 High 출력 확인"() {
        when:
        left.setSignal(Signal.ROW)
        right.setSignal(Signal.HIGH)

        then:
        output.getSignal() == Signal.HIGH
    }

    def "OrGate High와 High 값 입력시 High 출력 확인"() {
        when:
        left.setSignal(Signal.HIGH)
        right.setSignal(Signal.HIGH)

        then:
        output.getSignal() == Signal.HIGH
    }

    def "OrGate High와 Row 값 입력시 High 출력 확인"() {
        when:
        left.setSignal(Signal.HIGH)
        right.setSignal(Signal.ROW)

        then:
        output.getSignal() == Signal.HIGH
    }

    def "OrGate Row와 Row 값 입력시 Row 출력 확인"() {
        when:
        left.setSignal(Signal.ROW)
        right.setSignal(Signal.ROW)

        then:
        output.getSignal() == Signal.ROW
    }
}
