package constraint_propagation

import spock.lang.Specification

class ConstantTestGroovy extends Specification {
    def constant, connector;
    def value;

    def setup() {
        value = 10;
        connector = new Connector();
        constant = new Constant(value, connector);

    }

    def "Constant에 연결된 connector에 값이 정상적으로 전달 되었는지 확인."() {
        expect:
        connector.hasValue() == true;
        connector.getValue() == value;
    }

    def "Constant newValue 함수 호출 시 UnsupportedOperationException 오류 발생 확인."() {
        when:
        constant.newValue();

        then:
        thrown(UnsupportedOperationException.class)
    }

    def "Constant forgetValue 함수 호출 시 UnsupportedOperationException 오류 발생 확인."() {
        when:
        constant.forgetValue();

        then:
        thrown(UnsupportedOperationException.class)
    }
}
