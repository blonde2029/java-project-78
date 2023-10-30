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
        Predicate<Map> predicate = p -> {
            for (Map.Entry<String, BaseSchema> map : schemas.entrySet()) {
                if (!map.getValue().getRequired() && p.get(map.getKey()) == null) {
                    return true;
                } else if (!map.getValue().isValid(p.get(map.getKey()))) {
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
        Predicate<Map> predicate = i -> i.size() >= size;
        super.addPredicate("size", predicate);
        return this;
    }
}
