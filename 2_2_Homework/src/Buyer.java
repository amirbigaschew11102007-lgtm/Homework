import java.util.Arrays;

public class Buyer {
    private String name;
    private int age;
    private Product[] products;

    public Buyer(String name,int age,Product[] products) {
        this.name = name;
        this.age=age;
        this.products=products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
