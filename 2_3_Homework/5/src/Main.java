import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        List<User> users = DataGenerator_Task5.generateUsers();
        List<Subscription> subscriptions = DataGenerator_Task5.generateSubscriptions();

        main();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        switch (number) {
            case 1 -> users.stream()
                    .forEach(user -> System.out.println(
                            "Пользователь:" + user.getName()
                                    + ", Возраст: " + user.getAge()
                                    + ", Сервис: " + subscriptions.get(user.getSubscriptionId() - 1).getServiceName()
                                    + ", Премиум: " + subscriptions.get(user.getSubscriptionId() - 1).isPremium()
                                    + ", Часов в месяц:" + user.getWatchHoursPerMonth()));
            case 2->System.out.println(users.stream()
                    .collect(Collectors.groupingBy(user->subscriptions.get(user.getSubscriptionId()-1).getServiceName(),Collectors.summingInt(User::getWatchHoursPerMonth))));
            case 3->users.stream()
                    .filter(user -> user.getAge()<30)
                    .sorted(Comparator.comparing(User::getWatchHoursPerMonth).reversed())
                    .limit(3).forEach(System.out::println);
            case 4->System.out.println(users.stream().min(Comparator.comparing(User::getWatchHoursPerMonth)));
            case 5->{
                Map<String,Boolean> map = users.stream()
                        .collect(Collectors.toMap(User::getName, user -> subscriptions.get(user.getSubscriptionId()-1).isPremium()));
            }
            case 6->System.out.println(users.stream().flatMap(user -> user.getAnmes().stream()).toList());
            case 0 -> System.out.println();
        }
    }

    public static void main() {
        System.out.println("Задание 1. Сформируйте список строк в формате:\n" +
                "Пользователь: <name>, Возраст: <age>, Сервис: <serviceName>, Премиум: <да/нет>, Часов в месяц: <watchHours>\n" +
                "Задание 2. Подсчитайте суммарное количество часов просмотра по каждому сервису.\n" +
                "Выведите: название сервиса → суммарные часы\n" +
                "Задание 3. Найдите топ-3 пользователей по количеству часов просмотра среди тех, кому до 30 лет. Выведите в порядке убывания часов\n" +
                "Задание 4. Найдите пользователя с минимальным количеством часов просмотра\n" +
                "Задание 5. Постройте карту Map<String, Boolean>: имя пользователя → является ли его подписка премиум\n" +
                "Задание 6. У каждого пользователя есть список просмотренных жанров (List<String> genres). Получите список всех жанров по всем пользователям (с повторениями)\n"
                + "0 — Завершить программу\n");
    }
}
