package hexlet.code;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {
    public NumberSchema() {
        super.setRequired(false);
        Predicate<Object> predicate = i -> i instanceof Integer || i == null;
        super.addPredicate("integer", predicate);
    }

    public NumberSchema required() {
        super.setRequired(true);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> predicate = i -> i != null ? i > 0 : false;
        super.addPredicate("positive", predicate);
        return this;
    }

    public NumberSchema range(Integer start, Integer end) {
        Predicate<Integer> predicate1 = i -> start != null ? i >= start : true;
        super.addPredicate("start", predicate1);
        Predicate<Integer> predicate2 = i -> end != null ? i <= end : true;
        super.addPredicate("end", predicate2);
        return this;
    }
}
