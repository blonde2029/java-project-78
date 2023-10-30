package hexlet.code;


import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class App {
    public static void main(String[] args) {
        Validator v1 = new Validator();

        NumberSchema schema1 = v1.number();

// Пока не вызван метод required(), null считается валидным
        schema1.isValid(null); // true
        schema1.positive().isValid(null);
        schema1.required();

        System.out.println(schema1.isValid(null)); // false
        System.out.println(schema1.isValid("5")); // false
        System.out.println(schema1.isValid(10));

        Validator v = new Validator();

        MapSchema schema = v.map();

// shape позволяет описывать валидацию для значений каждого ключа объекта Map
// Создаем набор схем для проверки каждого ключа проверяемого объекта
// Для значения каждого ключа - своя схема
        Map<String, BaseSchema> schemas = new HashMap<>();

// Определяем схемы валидации для значений свойств "name" и "age"
// Имя должно быть строкой, обязательно для заполнения
        schemas.put("name", v.string().required());
// Возраст должен быть положительным числом
        schemas.put("age", v.number().positive());

// Настраиваем схему `MapSchema`
// Передаем созданный набор схем в метод shape()
        schema.shape(schemas);

// Проверяем объекты
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        schema.isValid(human1); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        System.out.println(schema.isValid(human2)); // true

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        System.out.println(schema.isValid(human3)); // false

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        System.out.println(schema.isValid(human4)); //false
    }
}
