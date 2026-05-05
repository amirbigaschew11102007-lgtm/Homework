public class ItemStorage<T> {
    private T value;

    public ItemStorage(T value){
        this.value=value;
    }

    public void compareWith(T otherValue){
        if (otherValue==null || getValue()==null){
            System.out.println("Опачки! Ревизия невозможна, объект не найден");
        } else if(otherValue.hashCode()==value.hashCode() && (otherValue).equals(value) && otherValue==value){
            System.out.println("Значения идентичны. Контроль качества пройден");
        } else {System.out.println("Значения не идентичны. Контроль качества не пройден");}
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
