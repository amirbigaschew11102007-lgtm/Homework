public class Calculator<T extends Number> {
    private T number;

    //○ double add(T a, T b)
    //○ double subtract(T a, T b)
    //○ double multiply(T a, T b)
    //○ double divide(T a, T b)

    public Calculator(T number) {
        this.number = number;
    }

    public double add(T number1, T number2) {
        return number1.doubleValue() + number2.doubleValue();
    }

    public double subtract(T number1, T number2) {
        return number1.doubleValue() - number2.doubleValue();
    }

    public double multiply(T number1, T number2) {
        return number1.doubleValue() * number2.doubleValue();
    }

    public double divide(T number1, T number2) {
        if (number2.doubleValue() == 0) {
            throw new IllegalArgumentException("на ноль делить нельзя");
        }
        return number1.doubleValue() / number2.doubleValue();
    }


    public T getArray() {
        return number;
    }

    public void setArray(T number) {
        this.number = number;
    }
}
