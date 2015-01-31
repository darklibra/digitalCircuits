package simulation.digital_circuits.component.circuits

import org.junit.Before
import simulation.digital_circuits.component.Wire
import simulation.digital_circuits.component.enums.Signal
import spock.lang.Specification

class HalfAdderTestGroovy extends Specification {
    private left, right;
    private sum, carry;
    @Before
    public void setup() {
        left = new Wire();
        right = new Wire();
        sum = new Wire();
        carry = new Wire();

        new HalfAdder(left, right, sum, carry);
    }

    def "반가산기 연산이 정상적으로 동작하는지 확인한다."() {
        expect:
        left.setSignal(a);
        right.setSignal(b);
        carry.getSignal() == c;
        sum.getSignal() == s;

        where:
        a | b | c | s
        Signal.ROW | Signal.ROW | Signal.ROW | Signal.ROW
        Signal.ROW | Signal.HIGH | Signal.ROW | Signal.HIGH
        Signal.HIGH | Signal.ROW | Signal.ROW | Signal.HIGH
        Signal.HIGH | Signal.HIGH | Signal.HIGH | Signal.ROW

    }
}
