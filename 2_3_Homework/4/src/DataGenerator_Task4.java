import java.util.Arrays;
import java.util.List;

public class DataGenerator_Task4 {

    public static List<Director> generateDirectors() {
        return Arrays.asList(
                new Director(1, "Кристофер Нолан",   1970),
                new Director(2, "Квентин Тарантино", 1963),
                new Director(3, "Дени Вильнёв",      1967),
                new Director(4, "Джордан Пил",       1979),
                new Director(5, "Пон Джун-хо",       1969)
        );
    }

    public static List<Movie> generateMovies() {
        return Arrays.asList(
                new Movie(1,  "Начало",                  2010, 8.8, 1),
                new Movie(2,  "Интерстеллар",             2014, 8.6, 1),
                new Movie(3,  "Оппенгеймер",              2023, 8.4, 1),
                new Movie(4,  "Криминальное чтиво",       1994, 8.9, 2),
                new Movie(5,  "Джанго освобождённый",     2012, 8.4, 2),
                new Movie(6,  "Однажды в Голливуде",      2019, 7.6, 2),
                new Movie(7,  "Прибытие",                 2016, 7.9, 3),
                new Movie(8,  "Бегущий по лезвию 2049",  2017, 8.0, 3),
                new Movie(9,  "Дюна",                     2021, 8.0, 3),
                new Movie(10, "Прочь",                    2017, 7.7, 4),
                new Movie(11, "Мы",                       2019, 6.8, 4),
                new Movie(12, "Нет",                      2022, 7.0, 4),
                new Movie(13, "Паразиты",                 2019, 8.5, 5),
                new Movie(14, "Воспоминания об убийстве", 2003, 8.1, 5),
                new Movie(15, "Мать",                     2009, 7.8, 5)
        );
    }
}