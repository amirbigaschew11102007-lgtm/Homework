import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private int age;
    private int subscriptionId;
    private int watchHoursPerMonth;
    private List<String> anmes;

    public User(int id, String name, int age, int subscriptionId, int watchHoursPerMonth,List<String> anmes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subscriptionId = subscriptionId;
        this.watchHoursPerMonth = watchHoursPerMonth;
        this.anmes=anmes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", subscriptionId=" + subscriptionId +
                ", watchHoursPerMonth=" + watchHoursPerMonth +
                ", anmes="+anmes+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(anmes,user.anmes)&&id == user.id && age == user.age && subscriptionId == user.subscriptionId && watchHoursPerMonth == user.watchHoursPerMonth && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, subscriptionId, watchHoursPerMonth);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public int getWatchHoursPerMonth() {
        return watchHoursPerMonth;
    }

    public void setWatchHoursPerMonth(int watchHoursPerMonth) {
        this.watchHoursPerMonth = watchHoursPerMonth;
    }

    public List<String> getAnmes() {
        return anmes;
    }

    public void setAnmes(List<String> anmes) {
        this.anmes = anmes;
    }
}
