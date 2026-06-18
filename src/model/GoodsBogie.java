package model;

public class GoodsBogie extends Bogie {
    private int loadCapacity;
    private String cargoType;

    public GoodsBogie(String id, String name, String type, int capacity, int loadCapacity, String cargoType) {
        super(id, name, type, capacity);
        this.loadCapacity = loadCapacity;
        this.cargoType = cargoType;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public String getCargoType() {
        return cargoType;
    }

    @Override
    public String toString() {
        return "GoodsBogie{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", loadCapacity=" + loadCapacity +
                ", cargoType='" + cargoType + '\'' +
                '}';
    }
}
