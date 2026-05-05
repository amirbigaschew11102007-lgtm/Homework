import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Part1_Profiles {
    public static void main(String[] args) {
        List<PlayerProfile> playerProfiles = new ArrayList<>();
        playerProfiles.add(new PlayerProfile("Alex", 18, 122323443, true));
        playerProfiles.add(new PlayerProfile("Domentos", 2, 12234443, false));
        playerProfiles.add(new PlayerProfile("Utopia", 15, 1223436753, true));

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_2_KlassWork\\src\\profiles.dat"));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_2_KlassWork\\src\\profiles.dat"))) {

            for (PlayerProfile playerProfile : playerProfiles) {
                objectOutputStream.writeObject(playerProfile.toString());
            }
            try {
                while (true) {
                    PlayerProfile playerProfile = (PlayerProfile) objectInputStream.readObject();
                    System.out.println(playerProfile.toString());
                }
            } catch (EOFException e) {
                System.out.println("Считаны все объекты из файла");
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
