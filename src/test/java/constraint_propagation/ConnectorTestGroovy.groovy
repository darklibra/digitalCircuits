package constraint_propagation

import spock.lang.Specification

class ConnectorTestGroovy extends Specification {
    def connector;

    def setup() {
        connector = new Connector();
    }

    def "설정한 값이 정상적으로 저장되는지 확인"() {
        given:
        def value = 6;

        when:
        connector.setValue(value, null);

        then:
        connector.getValue() == value;
    }

    def "forgetValue 함수 동작 학인"() {
        when:
        connector.setValue(6, null);
        connector.forgetValue();

        then:
        connector.hasValue() == false;
        connector.getValue() == null;
    }

    def "forgetValue 함수 호출 전에 같은 값으로 setValue 함수를 실행 확인"() {
        given:
        def value = 6;

        when:
        connector.setValue(value, null);
        connector.setValue(value, null);

        then:
        connector.getValue() == value
    }

    def "forgetValue 함수 호출 전에 다른 값으로 setValue 함수를 실행 하면 에러 출력 확인"() {
        when:
        connector.setValue(6, null);
        connector.setValue(7, null);

        then:
        thrown(RuntimeException.class)
    }

    def "connect함수를 통해 constraint를 연결 할 때 값이 없으면 constraint의 newValue 함수 호출 확인"() {
        given:
        def constraint = Mock(Constraint.class);

        when:
        connector.setValue(6, null);
        connector.connect(constraint)

        then:
        1 * constraint.newValue();
    }

    def "connect함수를 통해 constraint를 연결 할 때 값이 없으면 constraint의 newValue 함수 호출 없음 확인"() {
        given:
        def constraint = Mock(Constraint.class);

        when:
        connector.connect(constraint)

        then:
        0 * constraint.newValue();
    }
}
