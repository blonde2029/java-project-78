package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        super.isRequired = false;
        Predicate<Object> predicate = i -> i instanceof Integer || i == null;
        super.addPredicate("integer", predicate);
    }

    public NumberSchema required() {
        super.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> predicate = i -> i != null && (Integer) i > 0;
        super.addPredicate("positive", predicate);
        return this;
    }

    public NumberSchema range(Integer start, Integer end) {
        Predicate<Object> predicate1 = i -> start == null || (Integer) i >= start;
        super.addPredicate("start", predicate1);
        Predicate<Object> predicate2 = i -> end == null || (Integer) i <= end;
        super.addPredicate("end", predicate2);
        return this;
    }
}
