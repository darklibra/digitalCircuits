package component;

import com.google.common.collect.Lists;

import java.util.List;

public class Wire {
    public static final byte ZERO = 0;
    public static final byte ONE = 1;

    private byte signal = ZERO;
    private List<CircuitsAction> actions = Lists.newArrayList();

    public byte getSignal() {
        return signal;
    }

    public void setSignal(byte signal) {
        if (this.signal == signal) return ;

        this.signal = signal;
        actions.forEach(CircuitsAction::run);
    }

    public void addAction(CircuitsAction action) {
        actions.add(action);
        action.run();
    }

    public static boolean validSignal(Wire target) {
        return target.getSignal() == ONE || target.getSignal() == ZERO;
    }
}