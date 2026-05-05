import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>(Arrays.asList("Admin", "Q", "Boba", "12", "Superpuper"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() < 4) {
                iterator.remove();
            }
        }
        List<String> melist = new ArrayList<>(Arrays.asList("Admin", "Boba", "Superpuper"));
        Assertions.assertEquals(melist, list);
    }

    @Test
    public void lambdatest2() {
        List<String> list = new ArrayList<>(Arrays.asList("Admin", "Q", "Boba", "12", "Superpuper"));
        list.removeIf(login -> login.length() < 4);
        list.forEach(login -> System.out.println(login));
        Assertions.assertFalse(list.contains("Q"));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void test2() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Ноутбук", 10_000);
        map.put("Мышка", 5_000);
        map.put("Клавиатура", 7_500);

        int discount = 15;

        map.replaceAll((product, price) -> price - (discount * price) / 100);
        map.forEach((product, price) -> System.out.println(product + " " + price));
    }

    @Test
    public void test3() {
        Function<Integer, Integer> russianTax = price -> price + (20 * price) / 100;
        Function<Integer, Integer> USATax = price -> price + (10 * price) / 100;
        ArrayList<Integer> list = new ArrayList<>();

        list.add(100);
        list.add(500);
        list.add(1000);

        list.forEach(price -> System.out.println(russianTax.apply(price)));
        list.forEach(price -> System.out.println(USATax.apply(price)));
    }

    public static <T> List<T> filterList(List<T> list, Validator<T> validator) {
        List<T> newList = new ArrayList<>();
        for (T numb : list) {
            if (validator.chek(numb)) {
                newList.add(numb);
            }
        }
        return newList;
    }

    @Test
    public void test4() {
        List<Integer> numbers = List.of(new Integer[]{1, -5, 10, -20, 33});
        System.out.println(filterList(numbers, number -> number > 0));
    }

    @Test
    public void test5() {
        List<String> words = List.of(new String[]{"apple", "banana", "apple", "orange", "banana", "apple"});
        Map<String, Integer> frequency = new HashMap<>();
        words.forEach(word -> frequency.merge(word, 1, (oldValue, newValue) -> oldValue + newValue));
        System.out.println(frequency);
    }

    @Test
    public void test6() {
        List<String> users = new ArrayList<>(Arrays.asList("Admin", "moderator_1", "guest", "super_admin", "bot_99"));
        Predicate<String> isLongEnough = login -> login.length() > 5;
        Predicate<String> containsAdmin = login -> login.toLowerCase().contains("admin");
        Predicate<String> isNotBot = login -> !login.toLowerCase().contains("bot");
        Predicate<String> complexRule = isLongEnough.and(containsAdmin).and(isNotBot);

        List<String> filter = new ArrayList<>();
        for (String user : users) {
            if (complexRule.test(user)) {
                filter.add(user);
            }
        }
        Assertions.assertEquals(1, filter.size());
        Assertions.assertEquals("super_admin", filter.get(0));
    }
}
