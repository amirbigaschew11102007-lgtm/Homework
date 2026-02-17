import java.util.Objects;

public class Fraction extends Number {
    private int number;
    private int denominater;

    public Fraction(int number, int denominater) {
        if (denominater == 0) {
            throw new IllegalArgumentException();
        }
        setNumber(number);
        setDenominater(denominater);
    }

    public double add(Fraction dell) {
        return (double) (number * dell.getDenominater() + dell.getNumber() * denominater) / (denominater * dell.getDenominater());
    }

    public double substract(Fraction dell) {
        return (double) (number * dell.getDenominater() - dell.getNumber() * denominater) / (denominater * dell.getDenominater());
    }

    public double multiply(Fraction dell) {
        return (double) (this.number * dell.getNumber()) / (this.denominater * dell.getDenominater());
    }

    public double divide(Fraction dell) {
        return (double) (this.number * dell.getDenominater()) / (this.denominater * dell.getNumber());
    }

    public void reduce() {
        int i = 1;
        while (this.number % i == 0 && this.denominater % i == 0) {
            this.number /= i;
            this.denominater /= i;
            i++;
        }
    }

    public int gcd(int a, int b) {
        int nod = 1;
        for (int i = 2; i < max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                nod = i;
            }
        }
        return nod;
    }

    public int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    public Fraction negate() {
        setNumber(-1 * number);
        return new Fraction(number, denominater);
    }

    public boolean isProper() {
        if (Math.abs(getNumber()) < Math.abs(getDenominater())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getNumber() + "/" + getDenominater();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, denominater);
    }

    public boolean equals(Fraction dell) {
        if (this.number == dell.getNumber() && this.denominater == dell.getDenominater()) {
            return true;
        }
        return false;
    }

    @Override
    public int intValue() {
        return number / denominater;
    }

    @Override
    public long longValue() {
        return (long) number / denominater;
    }

    @Override
    public float floatValue() {
        return (float) number / denominater;
    }

    @Override
    public double doubleValue() {
        return (double) number / denominater;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDenominater() {
        return denominater;
    }

    public void setDenominater(int denominater) {
        if (denominater != 0) {
            this.denominater = denominater;
        } else {
            throw new ArithmeticException("не дели на ноль!!!");
        }
    }
}
