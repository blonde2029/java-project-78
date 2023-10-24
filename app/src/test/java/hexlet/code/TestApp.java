package hexlet.code;

import org.junit.jupiter.api.Test;

public class TestApp {
    @Test
    public void testValidator1() {
        Validator v = new Validator();

        StringSchema schema = v.string();

        // Пока не вызван метод required(), null и пустая строка считаются валидным
        schema.isValid(""); // true
        schema.isValid(null); // true

        schema.required();

        schema.isValid(null); // false
        schema.isValid(""); // false
        schema.isValid(5); // false
        schema.isValid("what does the fox say"); // true
        schema.isValid("hexlet"); // true

        schema.contains("wh").isValid("what does the fox say"); // true
        schema.contains("what").isValid("what does the fox say"); // true
        schema.contains("whatthe").isValid("what does the fox say"); // false

        schema.isValid("what does the fox say"); // false
    }

}
