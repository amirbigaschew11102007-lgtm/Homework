import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
        List<Player> players = DataGenerator_Task2.generatePlayers();
        List<Team> teams = DataGenerator_Task2.generateTeams();

        main();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        switch (number) {
            case 1 -> players
                    .forEach(player -> {
                        Team team = teams.get(player.getTeamId() - 1);
                        System.out.println("Name: " + player.getNickname()
                                + "\nAge: " + player.getAge()
                                + "\nTeam: " + team.getName());
                    });
            case 2 -> System.out.println(players.stream()
                    .collect(Collectors.groupingBy(
                            player -> teams.get(player.getTeamId() - 1).getName(),
                            Collectors.summingDouble(player -> player.getRating() / teams.size()))));

            case 3 -> players.stream()
                    .filter(player -> player.getAge() > 20)
                    .sorted(Comparator.comparing(Player::getRating).reversed())
                    .limit(3)
                    .forEach(player -> System.out.println(player + " "));

            case 4 -> System.out.println(players.stream()
                    .min(Comparator.comparing(Player::getAge)));

            case 5 -> {
                Map<Integer, String> map = players.stream()
                        .collect(toMap(
                                Player::getId,
                                Player::getNickname
                        ));
            }
            case 6 -> {
                Map<Team,List<Player>>teamListMap=players.stream()
                        .collect(Collectors.groupingBy(
                                player -> teams.get(player.getTeamId()-1),
                                Collectors.toList()));
                List<String> list = players.stream()
                        .map(Player::getNickname)
                        .toList();
            }
            case 0->System.out.println();
        }

    }

    public static void main() {
        System.out.println("1 — Вывести всех игроков и их команды\n" +
                "2 — Вывести средний рейтинг\n" +
                "3 — Найдите топ-3 игроков с наивысшим рейтингом среди тех, кому 21 год и старше.\n" +
                "4 — Найдите самого молодого игрока во всём списке\n" +
                "5 — Постройте карту Map<Integer, String>: id игрока → его никнейм\n" +
                "6 – Сгруппируйте игроков по командам (Map<Team, List<Player>>). Затем получите список " +
                "никнеймов всех игроков из всех команд в одну коллекцию\n" +
                "0 — Завершить программу\n");
    }
}
