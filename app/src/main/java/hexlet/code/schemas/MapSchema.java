package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {
    public MapSchema() {
        super.setRequired(false);
        Predicate<Object> predicate = i -> i instanceof Map<?, ?>;
        super.addPredicate("map", predicate);
    }

    public void shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> predicate = p -> {
            for (Map.Entry<String, BaseSchema> map : schemas.entrySet()) {
                if (!map.getValue().getRequired() && ((Map) p).get(map.getKey()) == null) {
                    return true;
                } else if (!map.getValue().isValid(((Map) p).get(map.getKey()))) {
                    return false;
                }
            }
            return true;
        };
        super.addPredicate("shape", predicate);
    }
    public MapSchema required() {
        super.setRequired(true);
        return  this;
    }

    public MapSchema sizeof(Integer size) {
        Predicate<Object> predicate = i -> ((Map) i).size() >= size;
        super.addPredicate("size", predicate);
        return this;
    }
}
