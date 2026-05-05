import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        BufferedReader br = null;
        List<String> lines = new ArrayList<>();
        try {
            //winda
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_1_KlassWork\\src\\task_4_win.txt");
            InputStreamReader isr = new InputStreamReader(fileInputStream, "windows-1251");
            br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            //8
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_1_KlassWork\\src\\task_4_win.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            for (String lin:lines){
                bufferedWriter.write(lin);
                bufferedWriter.newLine();
            }

            }catch(IOException e){
                System.out.println(e);
            }finally{
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
