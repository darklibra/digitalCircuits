package constraint_propagation.binomial

import constraint_propagation.Connector
import spock.lang.Specification

class AdderTestGroovy extends Specification {
    def left, right;
    def result;
    def Adder;

    def setup() {
        left = new Connector();
        right = new Connector();
        result = new Connector();
        Adder = new Adder(left, right, result);
    }

    def "multiplier 계산 확인"() {
        expect:
        left.setValue(leftValue, Adder);
        right.setValue(rightValue, Adder);
        result.setValue(resultValue, Adder);

        Adder.newValue();

        left.getValue() == leftExpect;
        right.getValue() == rightExpect;
        result.getValue() == resultExpect;

        where:
        leftValue | rightValue | resultValue | leftExpect | rightExpect | resultExpect
        1 | 2 | null | 1 | 2 | 3
        1 | null | 3 | 1 | 2 | 3
        null | 2 | 3 | 1 | 2 | 3
    }

    def "forget 함수 테스트"() {
        given:
        left.setValue(2, Adder);
        right.setValue(3, Adder);

        when:
        Adder.newValue();
        Adder.forgetValue();

        then:
        left.hasValue() == false;
        left.getValue() == null;

        right.hasValue() == false;
        right.getValue() == null;

        result.hasValue() == false;
        result.getValue() == null;
    }
}
