package component;

import com.google.common.collect.Lists;
import component.enums.Signal;

import java.util.List;

public class Wire {
    private Signal signal = Signal.ZERO;
    private List<CircuitsAction> actions = Lists.newArrayList();

    public Signal getSignal() {
        return signal;
    }

    public void setSignal(Signal signal) {
        if (this.signal == signal) return ;

        this.signal = signal;
        actions.forEach(CircuitsAction::run);
    }

    public void addAction(CircuitsAction action) {
        actions.add(action);
        action.run();
    }
}