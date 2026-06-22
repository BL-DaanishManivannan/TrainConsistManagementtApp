package model;

import java.util.LinkedList;
import java.util.List;

public class Train {
    private LinkedList<Bogie> bogies;

    public Train() {
        this.bogies = new LinkedList<>();
    }

    public void addBogie(Bogie bogie) {
        bogies.add(bogie);
    }

    public void removeBogie(Bogie bogie) {
        bogies.remove(bogie);
    }

    public List<Bogie> getBogies() {
        return bogies;
    }

    public int getTotalCapacity() {
        return bogies.stream().mapToInt(Bogie::getCapacity).sum();
    }

    @Override
    public String toString() {
        return "Train{" +
                "bogies=" + bogies +
                '}';
    }
}
