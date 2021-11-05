package ca.gbc.assignment1.services.maps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMap<T> {

    protected Map<Long, T> list = new HashMap<>();

    Long getNextId() {
        return Long.valueOf(list.size() + 1);
    }

    Set<T> getAll() {
        return new HashSet<T>(list.values());
    }

    T getById(Long id) {
        return list.get(id);
    }

    boolean save(Long id, T object) {
        try {
            list.put(id, object);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean delete(Long id) {
        try {
            list.remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
