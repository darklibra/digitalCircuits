package constraint_propagation.converter;

import constraint_propagation.Connector;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CelsiusFahrenheitTest {
    private CelsiusFahrenheit celsiusFahrenheit;
    private Connector celsius;
    private Connector fahrenheit;

    @Before
    public void setup() {
        celsius = new Connector();
        fahrenheit = new Connector();
        celsiusFahrenheit = new CelsiusFahrenheit(celsius, fahrenheit);
    }

    @Test
    public void test() {
        celsius.setValue(25, null);
        assertThat(fahrenheit.getValue()).isEqualTo(77);
    }

    @Test(expected = RuntimeException.class)
    public void test_1() {
        celsius.setValue(25, null);
        fahrenheit.setValue(200, null);
    }

    @Test
    public void test_2() {
        fahrenheit.setValue(77, null);
        assertThat(celsius.getValue()).isEqualTo(25);
    }
}
