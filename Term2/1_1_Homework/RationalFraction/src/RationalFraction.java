public class RationalFraction {
    private int chisl;
    private int znam;

    public RationalFraction() {
        this.chisl = 0;
        this.znam = 1;
    }

    public RationalFraction(int chisl, int znam) {
        this.chisl = chisl;
        this.znam = znam;
    }

    public void reduce() {
        int i = 1;
        while (this.chisl % i == 0 && this.znam % i == 0) {
            this.chisl /= i;
            this.znam /= i;
            i++;
        }
        System.out.println(toString());
    }

    //тут изменил для красоты
    public void add(RationalFraction number_2) {
        if (this.znam != number_2.getZnam()) {
            new RationalFraction(this.chisl * number_2.getZnam() + number_2.getChisl() * this.znam, this.znam * number_2.getZnam()).reduce();
        }
    }

    public void add2(RationalFraction number_2) {
        if (this.znam != number_2.getZnam()) {
            this.chisl = this.chisl * number_2.getZnam() + number_2.getChisl() * this.znam;
            this.znam *= number_2.getZnam();
        }
    }

    public void sub(RationalFraction number_2) {
        if (this.znam != number_2.getZnam()) {
            new RationalFraction(this.chisl * number_2.getZnam() - number_2.getChisl() * this.znam, this.znam * number_2.getZnam()).reduce();
        }
    }

    public void sub2(RationalFraction number_2) {
        if (this.znam != number_2.getZnam()) {
            this.chisl = this.chisl * number_2.getZnam() - number_2.getChisl() * this.znam;
            this.znam *= number_2.getZnam();
        }
    }

    public void mult(RationalFraction number_2) {
        new RationalFraction(this.chisl * number_2.getChisl(), this.znam * number_2.getZnam()).reduce();
    }

    public void mult2(RationalFraction number_2) {
        this.chisl *= number_2.getChisl();
        this.znam *= number_2.getZnam();
    }

    public void div(RationalFraction number_2) {
        new RationalFraction(this.chisl * number_2.getZnam(), this.znam * number_2.getChisl());
    }

    public void div2(RationalFraction number_2) {
        this.chisl *= number_2.getZnam();
        this.znam *= number_2.getChisl();
    }

    public String toString() {
        return chisl + "/" + znam + "=" + (chisl / znam);
    }

    public String value() {
        return String.format("%.1f", this.chisl / this.znam);
    }

    public boolean equals(RationalFraction number_2) {
        if ((this.chisl / this.znam) == (number_2.getChisl() / number_2.getZnam())) {
            return true;
        }
        return false;
    }

    public int numberPart() {
        return (this.chisl - this.chisl % this.znam) / this.znam;
    }

    public int getChisl() {
        return chisl;
    }

    public int getZnam() {
        return znam;
    }
}
