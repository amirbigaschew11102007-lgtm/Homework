import java.io.*;
import java.util.zip.InflaterInputStream;

public class Part4_Logs {
    public static void main(String[] args){
        try (InputStream reader1 = new FileInputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_2_KlassWork\\src\\session1.log");
             InputStream reader2 = new FileInputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_2_KlassWork\\src\\session2.log")){
            SequenceInputStream sequenceInputStream = new SequenceInputStream(reader1, reader2);
            InputStreamReader inputStreamReader = new InputStreamReader(sequenceInputStream,"UTF-8");
        }catch (IOException e){

        }
    }
}
