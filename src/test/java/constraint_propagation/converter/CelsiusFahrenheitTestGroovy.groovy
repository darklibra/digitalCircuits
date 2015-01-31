package constraint_propagation.converter

import constraint_propagation.Connector
import constraint_propagation.Constraint
import spock.lang.Specification

class CelsiusFahrenheitTestGroovy extends Specification {
    def celsius, fahrenheit;
    def celsiusFahrenheit;

    def setup() {
        celsius = new Connector();
        fahrenheit = new Connector();
        celsiusFahrenheit = new CelsiusFahrenheit(celsius, fahrenheit);
    }

    def "섭씨 -> 화씨 변경 확인"() {
        when:
        celsius.setValue(25, null);

        then:
        fahrenheit.getValue() == 77;
    }

    def "화씨 -> 섭씨 변경 확인"() {
        when:
        fahrenheit.setValue(77, null);

        then:
        celsius.getValue() == 77;
    }

    def "forgetValue전에 다른 값을 반대쪽에서 설정하면 오류 출력 확인"() {
        when:
        celsius.setValue(25, null);
        fahrenheit.setValue(200, null);

        then:
        thrown(RuntimeException.class);
    }
}
