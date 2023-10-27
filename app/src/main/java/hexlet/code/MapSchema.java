package hexlet.code;

public class MapSchema extends BaseSchema {
    public MapSchema() {
        super.addCondition("type", "Map");
        super.addCondition("isRequired", false);
        super.addCondition("size", null);
    }

    public MapSchema required() {
        super.addCondition("isRequired", true);
        return  this;
    }

    public MapSchema sizeof(Integer size) {
        super.addCondition("size", size);
        return this;
    }
}
