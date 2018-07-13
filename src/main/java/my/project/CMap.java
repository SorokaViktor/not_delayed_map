package my.project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class CMap {
    private ConcurrentMap<String, Long> _map = new ConcurrentHashMap();
    private ConcurrentSkipListSet<String> _set = new ConcurrentSkipListSet<>();
    private final Long delay;

    public CMap(Long delay) {
        this.delay = delay;
    }

    public boolean put(String key) {
        long currentTime = System.currentTimeMillis();
        Long storedTime = _map.put(key, currentTime);
        if (storedTime != null) {
            boolean result = (storedTime + delay) > currentTime;
            if (result) {
                _set.add(key);
            }
            return result;
        } else {
            return false;
        }
    }

    public Set<String> getNotDelayedKeys() {
        return _set;
    }
    public Set<String> gerAndDecimateDelayedKeys() {
        //TOD
        return null;
    }
}
