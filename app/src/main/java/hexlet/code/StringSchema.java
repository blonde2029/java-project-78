package hexlet.code;

public class StringSchema extends BaseSchema {
    public StringSchema() {
        super.addCondition("type", "String");
        super.addCondition("isRequired", false);
        super.addCondition("minValueLength", 0);
        super.addCondition("containsValue", "");
    }

    public StringSchema required() {
        super.addCondition("isRequired", true);
        return this;
    }
    public StringSchema minLength(Integer length) {
        super.addCondition("minValueLength", length);
        return this;
    }
    public StringSchema contains(String content) {
        super.addCondition("containsValue", content);
        return this;
    }
}
