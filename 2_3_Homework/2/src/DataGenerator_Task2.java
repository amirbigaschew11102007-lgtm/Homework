import java.util.Arrays;
import java.util.List;

public class DataGenerator_Task2 {

    public static List<Team> generateTeams() {
        return Arrays.asList(
                new Team(1, "NaVi",        "Польша",        1),
                new Team(2, "Astral",    "Дания",          2),
                new Team(3, "FaZe Clan",   "Международная",  3),
                new Team(4, "Team Spirit", "Россия",          5),
                new Team(5, "Cloud9",      "США",             8)
        );
    }

    public static List<Player> generatePlayers() {
        return Arrays.asList(
                new Player(1,  "s1mple",     26, 1, 9.8),
                new Player(2,  "electroNic", 24, 1, 8.5),
                new Player(3,  "b1t",        20, 1, 8.2),
                new Player(4,  "device",     28, 2, 9.1),
                new Player(5,  "dupreeh",    29, 2, 8.0),
                new Player(6,  "Magisk",     26, 2, 8.3),
                new Player(7,  "rain",       30, 3, 8.6),
                new Player(8,  "karrigan",   33, 3, 7.9),
                new Player(9,  "broky",      21, 3, 8.8),
                new Player(10, "chopper",    23, 4, 7.5),
                new Player(11, "sh1ro",      22, 4, 9.0),
                new Player(12, "nafany",     19, 4, 7.8),
                new Player(13, "Axile",      20, 5, 7.6),
                new Player(14, "HObbit",     26, 5, 8.1),
                new Player(15, "Perfecto",   23, 5, 7.7)
        );
    }
}