package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {
    public StringSchema() {
        super.setRequired(false);
        Predicate<Object> predicate = i -> i instanceof String;
        super.addPredicate("string", predicate);
    }

    public StringSchema required() {
        super.setRequired(true);
        return this;
    }
    public StringSchema minLength(Integer length) {
        Predicate<String> predicate = i -> i.length() >= length;
        super.addPredicate("length", predicate);
        return this;
    }
    public StringSchema contains(String content) {
        Predicate<String> predicate = i -> i.contains(content);
        super.addPredicate("contains", predicate);
        return this;
    }
}
