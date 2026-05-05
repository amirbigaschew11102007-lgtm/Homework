import java.util.Objects;

public class Subscription {
    private int id;
    private String serviceName;
    private double monthlyCost;
    private boolean isPremium;

    public Subscription(int id, String serviceName, double monthlyCost, boolean isPremium) {
        this.id = id;
        this.serviceName = serviceName;
        this.monthlyCost = monthlyCost;
        this.isPremium = isPremium;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", monthlyCost=" + monthlyCost +
                ", isPremium=" + isPremium +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return id == that.id && Objects.equals(monthlyCost, that.monthlyCost) && isPremium == that.isPremium && Objects.equals(serviceName, that.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceName, monthlyCost, isPremium);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}
