package agenda;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import component.CircuitsAction;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Agenda {
    Map<Integer, List<CircuitsAction>> schedules = Maps.newTreeMap();
    Map<String, Integer> delays = Maps.newHashMap();
    int currentTime;

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public boolean isEmpty() {
        return schedules.isEmpty();
    }

    public void addAction(int time, CircuitsAction action) {
        if (currentTime > time) throw new IllegalArgumentException("Invalid time");

        List<CircuitsAction> actions  = Optional.ofNullable(schedules.get(time)).orElseGet(() -> {
            schedules.put(time, Lists.newLinkedList());
            return schedules.get(time);
        });

        actions.add(action);
    }

    public CircuitsAction firstItem() {
        if (schedules.isEmpty()) return null;

        Integer key = schedules.keySet().iterator().next();
        if (key == null) return null;

        List<CircuitsAction> actions = schedules.get(key);
        currentTime = key;

        return actions.get(0);
    }

    public void removeFirstItem() {
        if (schedules.isEmpty()) return ;

        Integer key = schedules.keySet().iterator().next();
        if (key == null) return;

        List<CircuitsAction> actions = schedules.get(key);
        actions.remove(0);

        if (actions.size() <= 0) schedules.remove(key);
    }

    public void setDelayTime(String name, int dealy) {
        delays.put(name, dealy);
    }

    public int getDelayTime(String name) {
        return Optional.ofNullable(delays.get(name)).orElse(0);
    }
}
