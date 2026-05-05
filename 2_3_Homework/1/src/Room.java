import java.util.Objects;

public class Room extends Entity<Integer>{
    private String roomNumber;
    private double pricePerNight;
    private int capacity;

    public Room(Integer id,String roomNumber,double pricePerNight, int capacity) {
        super(id);
        this.roomNumber=roomNumber;
        this.pricePerNight=pricePerNight;
        this.capacity=capacity;
    }

    @Override
    public boolean equals(Object room){
        if (room==null || getClass()!=room.getClass()){
            return false;
        }
        Room rooms = (Room) room;
        return Objects.equals(roomNumber,rooms.roomNumber)&&Objects.equals(pricePerNight,rooms.pricePerNight)&&Objects.equals(capacity,rooms.capacity);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(),roomNumber,pricePerNight,capacity);
    }

    @Override
    public String toString() {
        return roomNumber+"\n"+pricePerNight+"\n"+capacity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
