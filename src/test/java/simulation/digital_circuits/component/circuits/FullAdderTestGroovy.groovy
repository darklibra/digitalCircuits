package simulation.digital_circuits.component.circuits

import org.junit.Before
import simulation.digital_circuits.component.Wire
import simulation.digital_circuits.component.enums.Signal
import spock.lang.Specification

class FullAdderTestGroovy extends Specification {
    private left, right, cin;
    private sum, carry;

    @Before
    public void setup() {
        left = new Wire();
        right = new Wire();
        cin = new Wire();
        sum = new Wire();
        carry = new Wire();

        new FullAdder(left, right, cin, sum, carry);
    }

    def "전가산기 연산이 정상적으로 동작하는지 확인한다."() {
        expect:
        left.setSignal(a);
        right.setSignal(b);
        cin.setSignal(x);
        carry.getSignal() == c;
        sum.getSignal() == s;

        where:
        a | b | x | c | s
        Signal.ROW | Signal.ROW | Signal.ROW | Signal.ROW | Signal.ROW
        Signal.ROW | Signal.ROW | Signal.HIGH | Signal.ROW | Signal.HIGH
        Signal.ROW | Signal.HIGH | Signal.ROW | Signal.ROW | Signal.HIGH
        Signal.ROW | Signal.HIGH | Signal.HIGH | Signal.HIGH | Signal.ROW
        Signal.HIGH | Signal.ROW | Signal.ROW | Signal.ROW | Signal.HIGH
        Signal.HIGH | Signal.ROW | Signal.HIGH | Signal.HIGH | Signal.ROW
        Signal.HIGH | Signal.HIGH | Signal.ROW | Signal.HIGH | Signal.ROW
        Signal.HIGH | Signal.HIGH | Signal.HIGH | Signal.HIGH | Signal.HIGH
    }
}
