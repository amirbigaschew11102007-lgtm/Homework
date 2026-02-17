import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("A,B or C");
        //A
        ItemStorage<Integer> new1 = new ItemStorage<>(100);
        new1.compareWith(100);
        // Как я понял малые значения int имеют одинаковый кэш (при значениях от -128, до 127).
        // Ссылаются на одно и то же место. А для большего размера объект создается в разных местах памяти

        //B
        ItemStorage<Integer> new2 = new ItemStorage<>(200);
        new2.compareWith(200);

        //C(просто в bool)
        ItemStorage<Fraction> new3 = new ItemStorage<>(new Fraction(1,2));
        System.out.println(new3.getValue().equals(new Fraction(1, 2)));
    }
}