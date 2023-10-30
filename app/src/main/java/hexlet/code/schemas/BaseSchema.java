package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private boolean isRequired;
    private final Map<String, Predicate<Object>> predicates = new HashMap<>();
    private boolean result;

    public final void setRequired(boolean b) {
        isRequired = b;
    }
    public final boolean getRequired() {
        return isRequired;
    }
    public final void addPredicate(String type, Predicate<Object> predicate) {
        predicates.put(type, predicate);
    }

    public final boolean isValid(Object data) {
        result = true;
        if (!isRequired &&  (data == null || data == "")) {
            return true;
        } else if (isRequired && (data == null || data == "")) {
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
