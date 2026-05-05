import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DataGenerator_Task1 {

    public static List<Room> generateRooms() {
        return Arrays.asList(
                new Room(1, "101", 3500.0, 1),
                new Room(2, "102", 4000.0, 2),
                new Room(3, "201", 5500.0, 2),
                new Room(4, "202", 7000.0, 3),
                new Room(5, "301", 9500.0, 4),
                new Room(6, "302", 12000.0, 4),
                new Room(7, "401", 15000.0, 2),
                new Room(8, "402", 18000.0, 4)
        );
    }

    public static List<Client> generateClients() {
        return Arrays.asList(
                new Client(1, "Алексей Петров"),
                new Client(2, "Мария Иванова"),
                new Client(3, "Дмитрий Сидоров"),
                new Client(4, "Екатерина Козлова"),
                new Client(5, "Иван Смирнов")
        );
    }

    public static List<Booking> generateBookings(List<Client> clients, List<Room> rooms) {
        return Arrays.asList(
                new Booking(1,  clients.get(0), rooms.get(0), LocalDate.of(2025, 1, 10), LocalDate.of(2025, 1, 15)),
                new Booking(2,  clients.get(0), rooms.get(4), LocalDate.of(2025, 3, 5),  LocalDate.of(2025, 3, 10)),
                new Booking(3,  clients.get(1), rooms.get(1), LocalDate.of(2025, 1, 12), LocalDate.of(2025, 1, 14)),
                new Booking(4,  clients.get(1), rooms.get(2), LocalDate.of(2025, 4, 20), LocalDate.of(2025, 4, 25)),
                new Booking(5,  clients.get(2), rooms.get(3), LocalDate.of(2025, 2, 1),  LocalDate.of(2025, 2, 7)),
                new Booking(6,  clients.get(2), rooms.get(4), LocalDate.of(2025, 5, 15), LocalDate.of(2025, 5, 20)),
                new Booking(7,  clients.get(3), rooms.get(5), LocalDate.of(2025, 2, 14), LocalDate.of(2025, 2, 18)),
                new Booking(8,  clients.get(3), rooms.get(6), LocalDate.of(2025, 6, 1),  LocalDate.of(2025, 6, 5)),
                new Booking(9,  clients.get(4), rooms.get(4), LocalDate.of(2025, 1, 20), LocalDate.of(2025, 1, 25)),
                new Booking(10, clients.get(4), rooms.get(7), LocalDate.of(2025, 3, 10), LocalDate.of(2025, 3, 15))
        );
    }
}