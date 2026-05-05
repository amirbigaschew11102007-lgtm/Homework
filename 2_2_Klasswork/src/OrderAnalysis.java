import java.util.*;
import java.util.stream.Collectors;

public class OrderAnalysis {
    public static void main(String[] args) {

        Product p1 = new Product(13046, "paper");
        Product p2 = new Product(14523, "butter");
        Product p3 = new Product(26447, "meet");
        Product p4 = new Product(26447, "milk");

        List<Order> orders = List.of(new Order(1, new User(21, "Амир"), Arrays.asList(p1, p2, p3, p4)),
                new Order(2, new User(22, "Ишхан"), Arrays.asList(p1, p2, p3, p4)),
                new Order(3, new User(23, "Артур"), Arrays.asList(p1, p4)),
                new Order(4, new User(24, "Оля"), Arrays.asList(p1, p2, p3)),
                new Order(3, new User(23, "Артур"), Arrays.asList(p2, p3)),
                new Order(3, new User(23, "Артур"), Arrays.asList(p2, p4)));
//1
        System.out.println("=========================");
        System.out.println(orders.stream()
                .map(Order::getProduct)
                .map(HashSet::new)
                .collect(Collectors.toSet()));
//2
        System.out.println("=========================");
        List<Product> products = orders.stream()
                .flatMap(order -> order.getProduct().stream())
                .toList();

        System.out.println(products.stream()
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting())));
//3 Для каждого товара вывести, какие пользователи его заказывали
        System.out.println("=========================");
        Map<String, Set<User>> payProduct = orders.stream()
                .flatMap(order -> order.getProduct().stream().map(product -> new AbstractMap.SimpleEntry<>(product.getName(), order.getUser()))
                ).collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toSet())));

        payProduct.forEach((product, users) -> users.forEach(user -> System.out.println(user.getName() + " = " + product)));

//4
        System.out.println("=========================");

        List<Integer> lists = orders.stream()
                .map(Order::getProduct)
                .map(product -> product.toArray().length)
                .toList();
        System.out.println(max(lists));

//5
        System.out.println("=========================");
        List<User> names = orders.stream()
                .map(Order::getUser)
                .toList();

        Map<String, Long> nameCounts = names.stream()
                .collect(Collectors.groupingBy(User::getName, Collectors.counting()));

        List<String> sortedNames = nameCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(nameCounts);
        System.out.println(sortedNames);
    }

    public static int max(List<Integer> array) {
        int max = 0;
        for (int numb : array) {
            if (numb > max) {
                max = numb;
            }
        }
        return max;
    }
}
