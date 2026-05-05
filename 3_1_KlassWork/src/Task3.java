import java.io.*;

public class Task3 {
    public static void main(String[] args){
        BufferedInputStream bufferedInputStreamr= null;
        try {
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_1_KlassWork\\src\\images.jpg");
            bufferedInputStreamr=new BufferedInputStream(fileInputStream);

            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_1_KlassWork\\src\\cat-copy.jpeg");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);


            byte[] buffer = new byte[4096];  // Буфер 4KB
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Файл успешно скопирован: " + bufferedOutputStream);

        }catch (IOException e){
            System.out.println(e);

        }finally {
            try {
                if (bufferedInputStreamr!=null){
                    bufferedInputStreamr.close();
                }
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }
}
