package hexlet.code;

public class NumberSchema extends BaseSchema {
    public NumberSchema() {
        super.addCondition("type", "Number");
        super.addCondition("isRequired", false);
        super.addCondition("needPositive", false);
        super.addCondition("startRange", null);
        super.addCondition("endRange", null);
    }

    public NumberSchema required() {
        super.addCondition("isRequired", true);
        return this;
    }

    public NumberSchema positive() {
        super.addCondition("needPositive", true);
        return this;
    }

    public NumberSchema range(Integer start, Integer end) {
        super.addCondition("startRange", start);
        super.addCondition("endRange", end);
        return this;
    }
}
