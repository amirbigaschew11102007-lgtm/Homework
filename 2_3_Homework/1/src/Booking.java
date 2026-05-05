import java.time.LocalDate;
import java.util.Objects;

public class Booking extends Entity<Integer> {
    private Client client;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Booking(Integer id, Client client, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        super(id);
        this.client = client;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate=checkOutDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(client, booking.client) && Objects.equals(room, booking.room) && Objects.equals(checkInDate, booking.checkInDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), client, room, checkInDate);
    }

    @Override
    public String toString() {
        return client+"\n"+room+"\n"+checkInDate+"\n"+checkOutDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
