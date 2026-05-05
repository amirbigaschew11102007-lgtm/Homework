import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
    List<Movie> movies =DataGenerator_Task4.generateMovies();
    List<Director> directors =DataGenerator_Task4.generateDirectors();

        main();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        switch (number) {
            case 1 ->movies
                    .forEach(movie -> System.out.println("Фильм:"+ movie.getTitle()+"("+movie.getYear()+")"+", Режиссёр: "+directors.get(movie.getDirectorId()-1).getName()+", Рейтинг: "+movie.getRating()));
            case 2-> System.out.println(movies.stream()
                    .collect(Collectors.groupingBy(movie->directors.get(movie.getDirectorId()-1).getName(),Collectors.summingDouble(movie->movie.getRating()/movies.size()))));
            case 3->System.out.println(movies.stream()
                    .filter(movie -> movie.getYear()>2010)
                    .sorted(Comparator.comparing(Movie::getRating).reversed())
                    .limit(3)
                    .toList());
            case 4->System.out.println(movies.stream().min(Comparator.comparing(Movie::getRating)));
            case 5->{
                Map<String,Double> map=movies.stream()
                        .collect(Collectors.toMap(
                                Movie::getTitle,
                                Movie::getRating
                        ));
            }
            case 6-> {
                Map<Director,List<Movie>>map = movies.stream()
                        .collect(Collectors.groupingBy(movie -> directors.get(movie.getDirectorId() - 1),Collectors.toList()));
                List<String> names=movies.stream()
                        .map(Movie::getTitle).toList();
            }case 0 -> System.out.println();
        }
    }

    public static void main() {
        System.out.println("Задание 1. Сформируйте список строк в формате:\n" +
                "Фильм: <title> (<year>), Режиссёр: <name>, Рейтинг: <rating>\n" +
                "Задание 2. Подсчитайте средний рейтинг фильмов каждого режиссёра.\n" +
                "Выведите: имя режиссёра → средний рейтинг\n" +
                "Задание 3. Найдите топ-3 фильма с наивысшим рейтингом среди вышедших после 2010 года. Выведите в порядке убывания рейтинга\n" +
                "Задание 4. Найдите фильм с минимальным рейтингом во всём списке\n" +
                "Задание 5. Постройте карту Map<String, Double>: название фильма → его рейтинг\n" +
                "Задание 6. Сгруппируйте фильмы по режиссёрам (Map<Director, List<Movie>>). Затем получите список названий всех фильмов из всех групп в одну коллекцию\n" +
                "0 — Завершить программу\n");
    }}