import java.util.Objects;

public class Team {
    private int id;
    private String name;
    private String country;
    private int ranking;

    public Team(int id,String name,String country,int ranking){
        this.id=id;
        this.name=name;
        this.country=country;
        this.ranking=ranking;
    }
    @Override
    public boolean equals(Object team){
        if (team==null||getClass()!=team.getClass()){
            return false;
        }
        Team teams = (Team) team;
        return Objects.equals(id,teams.id)&&Objects.equals(name,teams.name)&&Objects.equals(country,teams.country)&&Objects.equals(ranking,teams.ranking);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id,name,country,ranking);
    }
    @Override
    public String toString(){
        return "id: "+id+" name: "+name+" country: "+country+" ranking: "+ranking;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
