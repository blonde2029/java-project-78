package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private boolean isRequired;
    private final Map<String, Predicate> predicates = new HashMap<>();
    private boolean result;

    public void setRequired(boolean b) {
        isRequired = b;
    }
    public boolean getRequired() {
        return isRequired;
    }
    public void addPredicate(String type, Predicate predicate) {
        predicates.put(type, predicate);
    }

    public boolean isValid(Object data) {
        result = true;
        if (!isRequired && !(data instanceof Map<?, ?>) && (data == null || data == "")) {
            return true;
        } else if (isRequired && (data == null || data == "")) {
            return false;
        }

        for (Map.Entry<String, Predicate> entry : predicates.entrySet()) {
            Predicate<Object> predicate = entry.getValue();
            if (!predicate.test(data)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
