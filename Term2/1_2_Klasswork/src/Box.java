public class Box<T extends Number> {
    private T number;

    public Box(T number) {
        this.number = number;
    }

    public T createNew() {
        return number;
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }
}
