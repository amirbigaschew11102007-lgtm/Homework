import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotelApp {
    public static void main(String[] args) {
        List<Room> rooms = DataGenerator_Task1.generateRooms();
        List<Client> clients = DataGenerator_Task1.generateClients();
        List<Booking> bookings = DataGenerator_Task1.generateBookings(clients, rooms);

        main();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        switch (number) {
            case 1 -> bookings
                    .forEach(book -> System.out.println("Клиент: " + book.getClient().getName()
                            + ", Номер: " + book.getRoom().getRoomNumber()
                            + ", Заезд: " + book.getCheckInDate() + ", Выезд: " + book.getCheckOutDate()));
            case 2 -> {
                int match = scanner.nextInt();
                bookings.forEach(booking -> System.out.println(booking.getRoom().getRoomNumber() + " выручка -> " + (booking.getCheckOutDate().getDayOfMonth() - booking.getCheckInDate().getDayOfMonth()) * match));
            }
            case 3 -> {
//                Вывести топ-3 самых дорогих номера среди тех, что были забронированы хотя бы раз
                int match = scanner.nextInt();
                Map<String, Integer> books = bookings.stream().collect(Collectors.groupingBy(booking -> booking.getRoom().getRoomNumber(), Collectors.summingInt(booking -> (booking.getCheckOutDate().getDayOfMonth() - booking.getCheckInDate().getDayOfMonth()) * match)));
                books.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).forEach(book -> System.out.println(book.getKey() + " -> " + book.getValue()));
            }
            case 4 -> {
                int match = scanner.nextInt();
                Map<String, Integer> countBooks = bookings.stream()
                        .collect(Collectors.groupingBy(
                                booking -> booking.getClient().getName(),
                                Collectors.summingInt(
                                        booking -> (booking.getCheckOutDate().getDayOfMonth()
                                                - booking.getCheckInDate().getDayOfMonth()) * match)));
                System.out.println(countBooks.entrySet().stream().max(Map.Entry.comparingByValue()));
            }
            case 5 -> {
                int match = scanner.nextInt();
                Map<String, Double> map = bookings.stream()
                        .collect(Collectors.groupingBy(booking -> booking.getRoom().getRoomNumber(), Collectors.summingDouble(booking -> match)));
            }
            case 6 -> {
                Map<Client, List<Booking>> clientListMap = bookings.stream()
                        .collect(Collectors.groupingBy(Booking::getClient));
                clientListMap.entrySet().stream().forEach(filter->System.out.println(filter.getKey()+" -> "+filter.getValue().stream().map(Booking::getCheckInDate).toList()));
            }
        }
    }

    public static void main() {
        System.out.println("1 — Вывести всех клиентов и их бронирования\n" +
                "2 — Вывести суммарную выручку по каждому номеру\n" +
                "3 — Вывести топ-3 самых дорогих номера среди тех, что были забронированы хотя бы раз\n" +
                "4 — Найти клиента с наибольшей суммарной стоимостью всех бронирований\n" +
                "5 — Вывести Map<String, Double>: номер комнаты → цена за ночь\n" +
                "6 – Вывести список всех дат заезда (checkInDate) по всем клиентам\n" +
                "0 — Завершить программу\n");
    }
}
