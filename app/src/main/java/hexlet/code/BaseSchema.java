package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseSchema {
    private final Map<String, Object> conditions = new HashMap<>();
    public void addCondition(String type, Object value) {
        conditions.put(type, value);
    }

    public boolean isValid(Object data) {
        boolean isRequired = (boolean) conditions.get("isRequired");
        if (!isRequired) {
            return true;
        }
        if ((data == null || data == "")) {
            return false;
        }
        if (conditions.get("type").equals("String")) {
            if (!(data instanceof String)) {
                return false;
            }
            if (data.toString().length() < (int) conditions.get("minValueLength")) {
                return false;
            }
            if (!data.toString().contains(conditions.get("containsValue").toString())) {
                return  false;
            }
        }
        if (conditions.get("type").equals("Number")) {
            if (!(data instanceof Integer)) {
                return false;
            }
            if ((boolean) conditions.get("needPositive") && Integer.parseInt(data.toString()) <= 0) {
                return false;
            }
            Integer startRange = (Integer) conditions.get("startRange");
            Integer endRange = (Integer) conditions.get("endRange");
            if (startRange != null && Integer.parseInt(data.toString()) < startRange) {
                return false;
            }
            if (endRange != null && Integer.parseInt(data.toString()) > endRange) {
                return false;
            }
        }
        if (conditions.get("type").equals("Map")) {
            if (!(data instanceof Map)) {
                return false;
            }
            Integer size = (Integer) conditions.get("size");
            if (size != null && ((Map) data).size() < size) {
                return false;
            }
        }
        return true;
    }
}
