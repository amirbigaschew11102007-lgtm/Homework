import java.io.*;

public class Part5_Parser {
    public static void main(String[] args){
        try (PushbackReader inputStream = new PushbackReader(new FileReader("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_2_KlassWork\\src\\commands.txt"))){
            int b;
            while ((b = inputStream.read()) != -1) {
                if (b == '#') {

                    int charr;
                    while ((charr = inputStream.read()) != -1 && charr != '\n') {
                        continue;
                    }

                } else {
                    inputStream.unread(b);

                    ByteArrayOutputStream command = new ByteArrayOutputStream();

                    int newChar;
                    while ((newChar = inputStream.read()) != -1 && newChar != '\n') {
                        command.write(newChar);
                    }
                    System.out.println("Команда: " + command);
                }
            }
        }catch (IOException e){

        }
    }
}
