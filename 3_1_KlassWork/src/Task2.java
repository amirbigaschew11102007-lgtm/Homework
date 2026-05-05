import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args){
        String put = "C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_1_KlassWork\\src\\numbers.txt";
        BufferedReader bufferedReader = null;
        List<List<Integer>> numbers=new ArrayList<>();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            FileReader fileReader = new FileReader(put);
            bufferedReader = new BufferedReader(fileReader);
            fileWriter = new FileWriter("file_1.txt");
            bufferedWriter = new BufferedWriter(fileWriter);

            String line = bufferedReader.readLine();
            while (line!=null){
                numbers.add(Arrays.stream(line.split(" ")).map(Integer::parseInt).toList());
                line=bufferedReader.readLine();
            }
            List<Integer> lists=numbers.stream().flatMap(Collection::stream).toList();


            String count = "count = "+numbers.toArray().length * numbers.getFirst().size();
            String sum = "sum = "+lists.stream().mapToInt(number -> number).sum();
            String min = "min = "+lists.stream().mapToInt(number->number).min();
            String max = "max = "+lists.stream().mapToInt(number->number).max();
            String aver = "aver = " + lists.stream().collect(Collectors.averagingInt(number->number));

            bufferedWriter.write(count);
            bufferedWriter.newLine();

            bufferedWriter.write(sum);
            bufferedWriter.newLine();

            bufferedWriter.write(min);
            bufferedWriter.newLine();

            bufferedWriter.write(max);
            bufferedWriter.newLine();

            bufferedWriter.write(aver);
            bufferedWriter.newLine();
        } catch(IOException e){
            System.out.println(e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
