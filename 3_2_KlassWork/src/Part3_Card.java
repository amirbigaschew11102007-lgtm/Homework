import java.io.*;

public class Part3_Card {
    public static void main(String[] args) {
        try (StringWriter stringWriter = new StringWriter();
             BufferedWriter bufferedWriter = new BufferedWriter(stringWriter)) {
            bufferedWriter.write("Карточка игрока\n" +
                    "Ник: ShadowKnight\n" +
                    "Уровень: 42\n" +
                    "Счёт: 198400\n" +
                    "Статус: Онлайн\n");
            bufferedWriter.flush();

            StringReader stringReader = new StringReader(stringWriter.toString());
            BufferedReader bufferedReader = new BufferedReader(stringReader);

            int i = 1;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("#" + i + ": " + line);
                i++;
            }
        } catch (IOException e) {

        }
    }
}