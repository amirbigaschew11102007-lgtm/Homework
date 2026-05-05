//import java.io.*;
//
//public class Part2_Records {
//    public static void main(String[] args) {
//        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_2_KlassWork\\src\\profiles.dat"));
//        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_2_KlassWork\\src\\records.dat"))) {
//            try {
//                int i=0;
//                while (true){
//                    dataOutputStream.writeInt(dataInputStream.readInt());
//                    dataOutputStream.writeUTF(dataInputStream.readUTF());
//                    System.out.println("#"+i+": " + dataInputStream.readInt()+" - "+dataInputStream.readUTF());
//                    i++;
//                }
//            }catch (EOFException e){
//
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

import java.io.*;


public class Part2_Records {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_2_KlassWork\\src\\records.dat"));
             DataInputStream dis = new DataInputStream(new FileInputStream("C:\\Users\\Счастье\\IdeaProjects\\Proga\\3_2_KlassWork\\src\\records.dat"))) {
            dos.writeInt(198400);
            dos.writeUTF("ShadowKnight");

            dos.writeInt(175000);
            dos.writeUTF("IceDragon");

            dos.writeInt(160200);
            dos.writeUTF("NightOwl");

            dos.writeInt(145000);
            dos.writeUTF("StarBlaze");

            dos.writeInt(132000);
            dos.writeUTF("IronFist");

            System.out.println("Top 5:");
            for (int i = 1; i < 6; i++) {
                int score = dis.readInt();
                String nick = dis.readUTF();
                System.out.println("#" + i + " : " + score + " — " + nick);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
