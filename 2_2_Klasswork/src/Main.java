import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Аня", 19, "Java", 4.5, List.of("Теннис", "Кино")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")),
                new Student("Борис", 19, "Java", 4.0, List.of("Кино", "Чтение")),
                new Student("Света", 21, "C++", 4.0, List.of("Музыка", "Игры")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")));
//1

//        students.stream()
//                .skip(1)
//                .limit(3)
//                .filter(student -> student.getAge() > 19)
//                .map(Student::getName)
//                .forEach(System.out::println);
//
//        System.out.println(students.stream()
//                .filter(student -> student.getAge() > 19)
//                .count());

        //2
//        List<String>Language=students.stream()
//                .map(Student::getLanguage)
//                .distinct()
//                .sorted()
//                .collect(Collectors.toList());
//
//        Language.stream()
//                .forEach(System.out::println);

        //3
//        boolean java = students.stream()
//                .anyMatch(student -> student.getLanguage().equals("Java"));
//        boolean all18 = students.stream()
//                .allMatch(student -> student.getAge()>=18);
//        boolean ball30= students.stream()
//                .noneMatch(student -> student.getBall()<3.0);
//        System.out.println(java);
//        System.out.println(all18);
//        System.out.println(ball30);

        //4
        Set<String> hobby = students.stream()
                .flatMap(student -> student.getHobbies().stream())
                .collect(Collectors.toSet());
        System.out.println(hobby);

        Map<String,List<Student>> mapByLanguage = students.stream()
                        .collect(Collectors.groupingBy(Student::getLanguage));

        System.out.println(mapByLanguage);

//        String line = students.stream()
//                .filter(student->student.getBall() >5.0)
//                .map(Student::getName)
//                .collect(Collectors.joining(", "));
//
//        System.out.println(line);

//        5

//        Optional<Student> studentOptional=students.stream()
//                .filter(student -> student.getBall()==5.0)
//                .findFirst();
//
//        studentOptional.ifPresentOrElse(student -> System.out.println(student.getName()),()->System.out.println("Челочка нет)"));

    }
}