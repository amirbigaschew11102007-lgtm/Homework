import java.util.Objects;

public class Client extends Entity<Integer> {
    private String Name;

    public Client(Integer id, String name) {
        super(id);
        Name = name;
    }

    @Override
    public boolean equals(Object client){
        if (client==null||getClass()!=client.getClass()){
            return false;
        }
        Client clients =(Client) client;
        return Objects.equals(Name,clients.Name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(),Name);
    }

    @Override
    public String toString() {
        return Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
