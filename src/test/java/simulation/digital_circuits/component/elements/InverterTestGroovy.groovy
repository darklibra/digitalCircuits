package simulation.digital_circuits.component.elements

import simulation.digital_circuits.component.Wire
import simulation.digital_circuits.component.enums.Signal
import spock.lang.Specification

class InverterTestGroovy extends Specification {
    private def input
    private def output

    def setup() {
        input = new Wire();
        output = new Wire();
        new Inverter(input, output)
    }

    def "Wire를 Inverter에 연결 하였을 경우 정상적으로 반대 값으로 설정되는지 확인"() {
        when:
        input.setSignal(Signal.ROW)

        then:
        output.getSignal() == Signal.HIGH
    }

    def "Inverter 연결 후에 Signal 설정을 하면 정상적으로 반대값이 나오는지 확인"() {
        when:
        input.setSignal(Signal.HIGH)

        then:
        output.getSignal() ==  Signal.ROW
    }

    def "Inverter 연결 후에 Signal을 null로 설정시 예외 발생 확인"() {
        when:
        input.setSignal(null)

        then:
        thrown(IllegalArgumentException.class)
    }
}
