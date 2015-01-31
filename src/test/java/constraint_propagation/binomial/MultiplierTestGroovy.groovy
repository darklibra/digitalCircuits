package constraint_propagation.binomial

import constraint_propagation.Connector
import constraint_propagation.Constraint
import spock.lang.Specification

class MultiplierTestGroovy extends Specification {
    def left, right;
    def result;
    def multiplier;

    def setup() {
        left = new Connector();
        right = new Connector();
        result = new Connector();
        multiplier = new Multiplier(left, right, result);
    }

    def "multiplier 계산 확인"() {
        expect:
        left.setValue(leftValue, multiplier);
        right.setValue(rightValue, multiplier);
        result.setValue(resultValue, multiplier);

        multiplier.newValue();

        left.getValue() == leftExpect;
        right.getValue() == rightExpect;
        result.getValue() == resultExpect;

        where:
        leftValue | rightValue | resultValue | leftExpect | rightExpect | resultExpect
        10 | 10 | null | 10 | 10 | 100
        10 | null | 100 | 10 | 10 | 100
        null | 10 | 100 | 10 | 10 | 100
    }

    def "forget 함수 테스트"() {
        given:
        left.setValue(2, multiplier);
        right.setValue(3, multiplier);

        when:
        multiplier.newValue();
        multiplier.forgetValue();

        then:
        left.hasValue() == false;
        left.getValue() == null;

        right.hasValue() == false;
        right.getValue() == null;

        result.hasValue() == false;
        result.getValue() == null;
    }
}
