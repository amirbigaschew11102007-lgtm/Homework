import java.util.Arrays;
import java.util.List;

public class DataGenerator_Task3 {

    public static List<Department> generateDepartments() {
        return Arrays.asList(
                new Department(1, "Разработка",  "Москва"),
                new Department(2, "Маркетинг",   "Санкт-Петербург"),
                new Department(3, "Бухгалтерия", "Москва"),
                new Department(4, "HR",          "Казань"),
                new Department(5, "Аналитика",   "Новосибирск")
        );
    }

    public static List<Employee> generateEmployees() {
        return Arrays.asList(
                new Employee(1,  "Иван Козлов",       28, 120000, 1),
                new Employee(2,  "Анна Смирнова",      35,  95000, 1),
                new Employee(3,  "Пётр Волков",         42,  85000, 1),
                new Employee(4,  "Ольга Новикова",      26,  70000, 2),
                new Employee(5,  "Сергей Морозов",      31,  75000, 2),
                new Employee(6,  "Татьяна Попова",      45,  90000, 2),
                new Employee(7,  "Алексей Соколов",     29,  80000, 3),
                new Employee(8,  "Наталья Лебедева",    52, 110000, 3),
                new Employee(9,  "Дмитрий Зайцев",      24,  65000, 4),
                new Employee(10, "Елена Павлова",        38,  72000, 4),
                new Employee(11, "Михаил Семёнов",       41,  68000, 4),
                new Employee(12, "Юлия Орлова",          27,  95000, 5),
                new Employee(13, "Владимир Яковлев",     33, 105000, 5),
                new Employee(14, "Кристина Фёдорова",    22,  60000, 5),
                new Employee(15, "Роман Петров",          48, 130000, 1)
        );
    }
}