package hexlet.code;

public class StringSchema {
    private boolean isRequired;
    int minValueLength;
    private String containsValue;
    public StringSchema() {
        this.isRequired = false;
        this.minValueLength = 0;
        this.containsValue = "";
    }

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }
    public StringSchema minLength(int length) {
        this.minValueLength = length;
        return this;
    }
    public StringSchema contains(String content) {
        this.containsValue = content;
        return this;
    }
    public boolean isValid(Object data) {
        boolean result = true;
        if (!isRequired) {
            return true;
        }
        if (data == null && isRequired) {
            return false;
        }
        if (data.toString().length() < minValueLength) {
            result = false;
        }
        if (!data.toString().contains(containsValue)) {
            result = false;
        }
        return result;
    }
}
