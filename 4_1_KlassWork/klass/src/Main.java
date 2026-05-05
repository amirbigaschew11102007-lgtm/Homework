import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        task1();
        task2();
    }

    public static void task1() {
        List<String> list = new ArrayList<>();
        try (BufferedOutputStream bufferedInputStream = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\4_1_KlassWork\\klass\\src\\result_1.txt"))) {
            try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Счастье\\IdeaProjects\\Proga\\4_1_KlassWork\\4_1_Classwork\\access.log"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(list);

            List<List<String>> newList = new ArrayList<>(4);
            for (int i = 0; i < 4; i++) {
                newList.add(new ArrayList<>());
            }

            int k = 0;
            for (String item : list) {
                newList.get(k).add(item);
                k++;
                if (k == 4) {
                    k = 0;
                }
            }

            List<Thread> threads = new ArrayList<>();
            List<LogAnalyzer> logAnalyzers = new ArrayList<>();
//        =================================
            for (List<String> chunk : newList) {
                LogAnalyzer logAnalyzer = new LogAnalyzer(chunk);
                logAnalyzers.add(logAnalyzer);
                Thread thread = new Thread(logAnalyzer);
                threads.add(thread);
                thread.start();
            }
            for (Thread thread : threads) {
                thread.join();
            }
            int sumErrorCount = 0;
            int sumApiUsersCount = 0;
            for (LogAnalyzer logAnalyzer : logAnalyzers) {
                sumErrorCount += logAnalyzer.getErrorCount();
                sumApiUsersCount += logAnalyzer.getApiUsersCount();
            }

            bufferedInputStream.write(sumErrorCount);
            bufferedInputStream.write(sumApiUsersCount);

            System.out.println(sumErrorCount);
            System.out.println(sumApiUsersCount);
//            File[] txtxFile = bufferedInputStream.listFiles(
//                    (dir,name) -> name.endsWith("result_1.txt");
//            )
        } catch (IOException e) {

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void task2(){

    }
}