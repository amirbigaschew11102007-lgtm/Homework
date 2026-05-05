import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Department> departments = DataGenerator_Task3.generateDepartments();
        List<Employee> employees = DataGenerator_Task3.generateEmployees();


        main();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        switch (number) {
            case 1 -> employees.stream()
                    .forEach(employee -> System.out.println("Name: " + employee.getName()
                            + " Age: " + employee.getAge()
                            + " office: " + departments.get(employee.getDepartmentId() - 1).getName()
                            + " salary: " + employee.getSalary()));

            case 2-> System.out.println(employees.stream().collect(Collectors.groupingBy(employee->departments.get(employee.getDepartmentId()-1).getName(),Collectors.summingDouble(Employee::getSalary))));

            case 3->employees.stream()
                    .filter(employee -> employee.getAge()<35)
                    .sorted(Comparator.comparing(Employee::getSalary).reversed())
                    .limit(3).forEach(System.out::println);

            case 4->System.out.println(employees.stream()
                    .max(Comparator.comparing(Employee::getSalary)));

            case 5-> {
                Map<Integer, String> map = employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                employee -> departments.get(employee.getDepartmentId()-1).getName()
                        ));
            }

            case 6-> {
                Map<Department,List<Employee>>map= employees.stream()
                        .collect(Collectors.groupingBy(
                                employee -> departments.get(employee.getDepartmentId() - 1)));
                List<String> names = employees.stream()
                        .map(Employee::getName).toList();
            }

            case 0 -> System.out.println();
        }
    }

    public static void main() {
        System.out.println("1 — Сформируйте список строк в формате:\n" +
                "Задание 2. Подсчитайте суммарный фонд зарплат по каждому отделу.\n" +
                "Выведите: название отдела → суммарная зарплата\n" +
                "\n" +
                "Задание 3. Найдите топ-3 сотрудников с наибольшей зарплатой среди тех, кому до 35 лет. Выведите в порядке убывания зарплаты\n" +
                "\n" +
                "Задание 4. Найдите сотрудника с максимальной зарплатой в компании\n" +
                "\n" +
                "Задание 5. Постройте карту Map<Integer, String>: id сотрудника → название его отдела\n" +
                "\n" +
                "Задание 6. Сгруппируйте сотрудников по отделам (Map<Department, List<Employee>>). Затем получите список имён всех сотрудников из всех отделов в одну коллекцию\n" +
                "0 — Завершить программу\n");
    }}
