package model;

public class PassengerBogie extends Bogie {
    private int seatCapacity;

    public PassengerBogie(String id, String name, String type, int capacity, int seatCapacity) {
        super(id, name, type, capacity);
        this.seatCapacity = seatCapacity;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    @Override
    public String toString() {
        return "PassengerBogie{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", seatCapacity=" + seatCapacity +
                '}';
    }
}
