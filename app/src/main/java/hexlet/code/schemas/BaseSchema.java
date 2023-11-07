package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected boolean isRequired;
    private final Map<String, Predicate<Object>> predicates = new LinkedHashMap<>();

    public final void addPredicate(String type, Predicate<Object> predicate) {
        predicates.put(type, predicate);
    }

    public final boolean isValid(Object data) {
        boolean result = true;
        if (!isRequired && data == null) {
            return true;
        } else if (isRequired && data == null) {
            return false;
        }

        for (Map.Entry<String, Predicate<Object>> entry : predicates.entrySet()) {
            Predicate<Object> predicate = entry.getValue();
            if (!predicate.test(data)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
