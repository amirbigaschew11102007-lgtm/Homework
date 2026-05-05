import java.util.Objects;

public class Movie {
    private int Id;
    private String name;
    private String genre;
    private int year;
    private double rating;
    private int time;

    public Movie(int Id, String name, String genre, int year, double rating, int time) {
        this.Id = Id;
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movie movie = (Movie) o;
        return Id == movie.Id && year == movie.year && Double.compare(rating, movie.rating) == 0 && time == movie.time && Objects.equals(name, movie.name) && Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, genre, year, rating, time);
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
//идентификатор (уникальный номер)
//название
//жанр (например, "Drama", "Action", "Sci-Fi", "Comedy"),
//год выхода
//рейтинг (например, от 0.0 до 10.0)
//длительность (в минутах)