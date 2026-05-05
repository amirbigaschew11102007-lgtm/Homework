import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

public class NetflixApp {

    public static void main(String[] args) {
        List<Movie> movies = NetflixDataGenerator.generateMovies();
        List<User> users = NetflixDataGenerator.generateUsers(movies);

        // Здесь вы пишете свои решения:
        // tasksA(users, movies); tasksB(...); и т.д.
        System.out.println("Movies: " + movies.size());
        System.out.println("Users: " + users.size());

        //2.1
        System.out.println("2.1=====================================");
        users.stream()
                .flatMap(user -> user.getMovies().stream())
                .distinct()
                .sorted(Comparator.comparing(Movie::getName))
                .toList()
                .forEach(movoe -> System.out.println(movoe.getName()));

        //2.2
        System.out.println("2.2=====================================");
        movies.stream().sorted(Comparator.comparing(Movie::getName))
                .sorted(Comparator.comparing(Movie::getRating).reversed())
                .filter(movie -> movie.getRating() >= 8)
//                .sorted(Comparator.comparing(Movie::getName))
//                .map(movie -> movie.getRating()!=movie.getRating()?movie.getRating():movie.stream().sorted(Comparator.comparing(Movie::getName)))
                .forEach(movie -> System.out.println(movie.getRating() + " " + movie.getName()));
        //2.3
        System.out.println("2.3=====================================");
        users.stream()
                .filter(user -> user.getAge() >= 18)
                .filter(user -> user.getMovies().size() >= 1)
                .toList()
                .forEach(user -> System.out.println("Name: " + user.getName() + ", Age: " + user.getAge() + ", Movies: " + user.getMovies().size()));
        //2.4
        System.out.println("2.4=====================================");
        System.out.println(users.stream()
                .flatMap(user -> user.getMovies().stream())
                .count());

        //3.1
        System.out.println("3.1=====================================");
        System.out.println(movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre)));
        //3.2
        System.out.println("3.2=====================================");
        System.out.println(movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting())));
        //3.3
        System.out.println("3.3=====================================");
        users.forEach(user -> System.out.println(user.getName() + " " + user.getMovies().size()));

        //3.4
        System.out.println("3.4=====================================");
        users.stream()
                .forEach(user -> System.out.println(user.getName() + " - " + user
                        .getMovies()
                        .stream()
                        .max(Comparator
                                .comparingInt(Movie::getTime))));
        //4.1
        System.out.println("4.1=====================================");

        System.out.println(users.stream()
                .filter(user -> user.getAge() > 17 && user.getAge() < 26)//короче сначала фильтруем по age
                .flatMap(user -> user.getMovies().stream())// потом делаем из некого списка из пользователей единый список из их Movies
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()))//группируем по Genre и записываем их количество
                .entrySet().stream()// не понял зачем, но надо, чтобы дальше писать
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())//сортируем по количеству и reverсаем по убыванию
                .map(Map.Entry::getKey)//для каждого элемента оставляем только ключ
                .toList()// приводим к Listу
                .getFirst());//берём только первый элемент

        //4.2
        System.out.println("4.2=====================================");
        System.out.println(users.stream()
                .flatMap(user -> user.getMovies().stream())
                .collect(Collectors.groupingBy(Movie::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(3).toList());

        //4.3
        System.out.println("4.3=====================================");
//        System.out.println(users.stream()
//                .collect(Collectors.groupingBy(User::getCountry,Collectors.counting(user -> user.getMovies().stream().mapToDouble(Movie::getRating)))));
        System.out.println(users.stream()
                .collect(Collectors.groupingBy(//собираем в колекцию и группирируем как Country и Summ/sizeMovies
                        User::getCountry,
                        Collectors.summingDouble(user ->//собираем в единое число, сумму Double
                                user.getMovies().stream()
                                        .mapToDouble(Movie::getRating)// гарантируем, сто там Double
                                        .sum() / user.getMovies().size()//Суммируем и делим на количество
                        )
                )));
        //4.4
        System.out.println("4.4=====================================");
        System.out.print("ТОП-фильмы: ");
        users.stream()
                .flatMap(user -> user.getMovies().stream())
                .filter(movie -> movie.getRating() >= 5.0)
                .collect(Collectors.groupingBy(Movie::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(key -> System.out.print(key.getKey() + " (" + key.getValue() + " просмотров); "));
        System.out.println();

        //5.1

        System.out.println("5.1=====================================");
        System.out.println(isMovie(users, "Spider-Man: Into the Spider-Verse"));

        //5.2
        System.out.println("5.2=====================================");
        isMovieValue(users, "Spider-Man: Into the Spider-Verse");

        //5.3 //рах это моя личная задача, то решил сделать не Map<String, Optional<Movies>>, а Map<String, String>>
        System.out.println("5.3=====================================");
        System.out.println(users.stream()
                .collect(Collectors.toMap(//что делает toMap?
                        User::getName,
                        user -> user.getMovies().stream()
                                .max(Comparator.comparing(Movie::getRating))//ищем максимальный фильм по рейтингу
                                .map(Movie::getName)
                                .orElse("Нет фильмов"))));

        //6.1
        System.out.println("6.1=====================================");
//        System.out.println(users.stream()
//                .collect(Collectors.toMap(
//                        User::getMovies,
//                        user -> user.getMovies()
//                )));
        System.out.println(users.stream()
                .flatMap((User user1) -> user1.getMovies().stream())
                .collect(Collectors.groupingBy(Movie::getName, Collectors.counting())));
        //6.2
        System.out.println("6.2=====================================");
        //6.3
        System.out.println("6.3=====================================");
        System.out.println("Позор всего человечества: "+users.stream()
                .filter(user -> user.getMovies().size() >= 15 && user.getMovies().stream()
                        .mapToDouble(Movie::getRating)
                        .sum() / user.getMovies().size() >= 7.5).map(User::getName).toList());
        //посмотрел не меньше 15 фильмов
        //средний рейтинг просмотренных им фильмов не ниже 7.5
        //Вернуть Optional<User>

    }

    public static Optional<Movie> isMovie(List<User> users, String name) {
        return users.stream()
                .flatMap(user -> user.getMovies().stream())
                .filter(movie -> movie.getName().equals(name))
                .findFirst();
    }

    public static void isMovieValue(List<User> users, String name) {
        if (users.stream()
                .flatMap(user -> user.getMovies().stream())
                .noneMatch(movie -> movie.getName().equals(name))) {
            Movie moviy = (Movie) users.stream()
                    .flatMap(user -> user.getMovies().stream())
                    .filter(movie -> movie.getName().equals(name))
                    .collect(Collectors.toSet()).stream().limit(1);
            System.out.println("Нашли фильм: " + moviy.getName() + "(rating: " + moviy.getRating() + ")");
        } else {
            System.out.println("Фильм не найден");
        }
    }
}