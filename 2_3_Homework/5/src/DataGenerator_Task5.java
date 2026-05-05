import java.util.Arrays;
import java.util.List;

public class DataGenerator_Task5 {

    public static List<Subscription> generateSubscriptions() {
        return Arrays.asList(
                new Subscription(1, "Netflix",         699, true),
                new Subscription(2, "YouTube Premium", 299, true),
                new Subscription(3, "Кинопоиск",       199, false),
                new Subscription(4, "START",            149, false),
                new Subscription(5, "MORE.TV",          249, true)
        );
    }

    public static List<User> generateUsers() {
        return Arrays.asList(
                new User(1,  "Алина",    22, 1, 45,  Arrays.asList("Комедия", "Триллер")),
                new User(2,  "Борис",    35, 2, 30,  Arrays.asList("Документальное", "Спорт")),
                new User(3,  "Вера",     19, 3, 20,  Arrays.asList("Аниме", "Комедия")),
                new User(4,  "Глеб",     28, 1, 60,  Arrays.asList("Фантастика", "Боевик")),
                new User(5,  "Диана",    41, 4, 15,  Arrays.asList("Драма")),
                new User(6,  "Егор",     24, 5, 50,  Arrays.asList("Триллер", "Ужасы")),
                new User(7,  "Жанна",    33, 2, 25,  Arrays.asList("Мелодрама", "Комедия")),
                new User(8,  "Захар",    17, 3, 18,  Arrays.asList("Аниме", "Фантастика")),
                new User(9,  "Ирина",    45, 4, 10,  Arrays.asList("Документальное")),
                new User(10, "Кирилл",   26, 5, 55,  Arrays.asList("Боевик", "Фантастика")),
                new User(11, "Лиза",     20, 1, 40,  Arrays.asList("Мелодрама", "Драма")),
                new User(12, "Максим",   38, 2, 22,  Arrays.asList("Спорт", "Документальное")),
                new User(13, "Надежда",  29, 3, 12,  Arrays.asList("Комедия")),
                new User(14, "Олег",     23, 5, 48,  Arrays.asList("Ужасы", "Триллер")),
                new User(15, "Полина",   31, 4,  8,  Arrays.asList("Драма", "Мелодрама"))
        );
    }
}