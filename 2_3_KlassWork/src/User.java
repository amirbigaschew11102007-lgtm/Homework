import java.util.List;
import java.util.Objects;

public class User {
    private int Id;
    private String name;
    private int age;
    private String country;
    private List<Movie> movies;

    public User(int Id, String name, int age, String country, List<Movie> movies) {
        this.Id = Id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", movies=" + movies +
                '}';
    }

    @Override
    public int hashCode(){
        return Objects.hash(Id,name,age,country,movies);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Id == user.Id && age == user.age && Objects.equals(name, user.name) && Objects.equals(country, user.country) && Objects.equals(movies, user.movies);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
//идентификатор
//имя
//возраст
//страна
//список просмотренных фильмов (коллекция фильмов)