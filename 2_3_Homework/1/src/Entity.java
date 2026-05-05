import java.util.Objects;

public abstract class Entity<T> {
    private T id;

    public Entity(T id){
        this.id=id;
    }

    public T getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void setId(T id) {
        this.id = id;
    }
    @Override
    public abstract String toString();
}
