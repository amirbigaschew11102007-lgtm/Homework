import java.util.List;

public class Student {
    private String name;
    private Integer age;
    private String language;
    private Double ball;
    private List<String> hobbies;

    public Student(String name,Integer age,String language,Double ball,List<String> hobbies){
        this.name=name;
        this.age=age;
        this.language=language;
        this.ball=ball;
        this.hobbies=hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getBall() {
        return ball;
    }

    public void setBall(Double ball) {
        this.ball = ball;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
