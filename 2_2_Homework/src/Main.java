import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Buyer> buyers = List.of(
                new Buyer("Аня", 18, new Product[]{new Product(19.99, "Boil1"), new Product(39.99, "bear2")}),
                new Buyer("Иван", 20, new Product[]{new Product(19.99, "Boil1")}),
                new Buyer("Борис", 19, new Product[]{new Product(19.99, "Boil1")}),
                new Buyer("Света", 21, new Product[]{new Product(19.99, "Boil1"), new Product(19.99, "Boil2"), new Product(19.99, "Boil3"), new Product(39.99, "bear2")}),
                new Buyer("Света", 21, new Product[]{new Product(19.99, "Boil1"), new Product(19.99, "Boil3")}),
                new Buyer("Света", 21, new Product[]{new Product(19.99, "Boil1")}),
                new Buyer("Иван", 20, new Product[]{new Product(19.99, "Boil1")}));

        //1
        System.out.println("==1=============================");
        buyers.stream()
                .collect(Collectors.groupingBy(
                        Buyer::getName,
                        Collectors.summingInt(buyer -> (int) Arrays.stream(buyer.getProducts())
                                .map(Product::getName)
                                .distinct()
                                .count()))
                ).entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).ifPresent(buyer -> System.out.println("Person: " + buyer.getKey() + "\nCount product: " + buyer.getValue()));
        //Найти пользователя с максимальным количеством уникальных товаров
        //Вывести: имя пользователя и сколько уникальных товаров он заказывал

        //2
        System.out.println("==2=============================");
        //Найти товары, которые встречаются хотя бы в одном заказе каждого пользователя. То есть товар, который заказывал и Аня, и Боря, и Витя (короче всех, кто есть в системе)
        //Вывести список названий таких товаров (если нет ни одного – вывести сообщение
        System.out.println(buyers.stream()
                .flatMap(buyer1 -> Arrays.stream(buyer1.getProducts())
                        .map(Product::getName)
                        .collect(Collectors.toSet())
                        .stream()
                        .filter(name -> buyers.stream()
                                .allMatch(buyer -> Arrays.stream(buyer.getProducts())
                                        .anyMatch(p -> p.getName().equals(name)))))
                .findFirst()
                .get());

        //3
        System.out.println("==3=============================");
        System.out.println("Общее среднее: " + buyers.stream()
                .collect(Collectors.averagingDouble(buyer -> Arrays.stream(buyer.getProducts()).count())));

        buyers.stream()
                .collect(Collectors.groupingBy(
                        Buyer::getName,
                        Collectors.averagingDouble(buyer -> Arrays.stream(buyer.getProducts()).count())))
                .forEach((name, countOrders) -> System.out.println("Пользователь " + name + ": " + countOrders + " товара на заказ"));

        //4
        System.out.println("==4=============================");
        int minOrderCount = buyers.stream()
                .mapToInt(buyer -> buyer.getProducts().length)
                .min()
                .orElse(0);

        System.out.println("Min count orders: " + minOrderCount);
        System.out.println("Min count orders: " + buyers.stream()
                .filter(buyer -> buyer.getProducts().length == minOrderCount).toList());

        //5
        System.out.println("==5=============================");
        //короче, создаём мап из имён и заказов в чистом виде
        Map<String, List<Buyer>> byName = buyers.stream()
                .collect(Collectors.groupingBy(Buyer::getName));

        byName.entrySet().stream()
                //создаём цельный список из товаров для покупателя
                .flatMap(entry -> {// каждый отдельный покупатель
                    String buyerName = entry.getKey();
                    List<Buyer> sameNameBuyers = entry.getValue();
                    //именно тут мы их и объединяем

                    Map.Entry<String, Long> maxCount = sameNameBuyers.stream()
                            .flatMap(buyer -> Arrays.stream(buyer.getProducts()))
                            .toList()
                            // лист из продуктов одного покупателя
                            .stream()
                            .collect(Collectors.groupingBy(
                                    Product::getName,
                                    Collectors.counting()))
                            //группируем по Имя, количество
                            .entrySet().stream()//тк он мар мы должны перед стримом сделать его entrySet()
                            .max(Map.Entry.comparingByValue())
                            .orElse(null);
                    //выделяем максимальное количество, иначе выводим null (без него ругался)

                    if (maxCount == null) {
                        return Stream.empty();
                    }//избегаем exception в случае пустоты

                    String line = String.format(
                            "%s чаще всего заказывает: %s (%d раза)",//s - String, d - double
                            buyerName,
                            maxCount.getKey(),
                            maxCount.getValue()
                    );// шаблон вывода

                    return Stream.of(line);
                }).forEach(System.out::println);

        //6
        System.out.println("==6=============================");
        //Список пользователей, которые заказывали все товары из заданного списка
        //Допустим, у нас есть какой-то набор проверки»: список из 2–3 конкретных товаров (например, «Молоко» и «Хлеб»)
        //Найти всех пользователей, которые заказывали каждый из этих товаров (хотя бы по одному разу за всё время)
        //Вывести их имена. Если таких нет – написать об этом
        Set<String> allproducts = buyers.stream()
                .flatMap(buyer -> Arrays.stream(buyer.getProducts()))
                .map(Product::getName)
                .collect(Collectors.toSet());
        // все продукты

        byName.entrySet().stream()
                .flatMap(entry -> {
                    String name = entry.getKey();
                    List<Buyer> products = entry.getValue();

                    Set<String> allbuy = products.stream()
                            .flatMap(buyer -> Arrays.stream(buyer.getProducts()))
                            .map(Product::getName)
                            .collect(Collectors.toSet());//создали Сет из продуктов каждого пользователя


                    if (allbuy.containsAll(allproducts)) {
                        return Stream.of(
                                String.format(
                                "%s подходит под условие (молодец, купил всё!)",
                                name)
                        );
                    }
                    return Stream.of(
                            "не молодец"
                    );
                }).forEach(System.out::println);
    }
}