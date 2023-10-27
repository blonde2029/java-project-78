package hexlet.code;


import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();

        MapSchema schema = v.map();

        schema.isValid(null); // true

        schema.required();

        schema.isValid(null); // false
        schema.isValid(new HashMap()); // true

    }
}
