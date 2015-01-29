package constraint_propagation;

import com.google.common.collect.Sets;

import java.util.Optional;
import java.util.Set;

public class Connector {
    private Integer value;
    private Constraint informant;
    private Set<Constraint> constraints = Sets.newHashSet();

    public boolean hasValue() {
        return value != null;
    }

    public void setValue(Integer value, Constraint informant) {
        if (!hasValue()) {
            this.value = value;
            this.informant = informant;
            constraints.stream()
                    .filter((e) -> e != informant)
                    .forEach(Constraint::newValue);
        } else if (this.value != value) throw new RuntimeException();
    }

    public Integer getValue() {
        return value;
    }

    public void forgetValue(Constraint informant) {
        if (this.informant != informant) return;
        value = null;
        constraints.stream()
                .filter((e) -> e != informant)
                .forEach(Constraint::forgetValue);
    }

    public void connect(Constraint constraint) {
        Optional.ofNullable(constraint).ifPresent((c) -> constraints.add(c));
        if (hasValue()) constraint.newValue();
    }

}
