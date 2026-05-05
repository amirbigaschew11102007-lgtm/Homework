import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task_1_In_Class {
    public static void main(String[] args) {
        String path = "C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_1_KlassWork\\src\\file_1.txt";
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Message " + e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e){
                System.out.println("Ошибка при закрытии файла "+e);
            }
        }
    }
}
