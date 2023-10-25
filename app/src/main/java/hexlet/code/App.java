package hexlet.code;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();

        StringSchema schema = v.string();

        // Пока не вызван метод required(), null и пустая строка считаются валидным
        System.out.println(schema.isValid("")); // true
        System.out.println(schema.isValid(null)); // true

    }
}
