import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        String str = "C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_1_KlassWork\\src\\students.csv";
        BufferedReader bf = null;
        List<Student> students=new ArrayList<>();

        try {
            FileReader fl = new FileReader(str);
            bf = new BufferedReader(fl);

            bf.readLine();

            String line = bf.readLine();
            while (line != null) {
                String[] splits= line.split(",");
                if (splits.length==4) {
                    students.add(new Student(Integer.parseInt(splits[0]), splits[1], Integer.parseInt(splits[2]), splits[3]));
                }
                line = bf.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);

        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        System.out.println(students.stream().toList());
        System.out.println(students.stream()
                .collect(Collectors.groupingBy(Student::getGroup,Collectors.counting())));
    }
}
