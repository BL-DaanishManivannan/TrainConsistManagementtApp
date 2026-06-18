package app;

import java.util.ArrayList;
import java.util.List;

public class TrainApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Train Consist Management App");
        
        List<String> train = new ArrayList<>();
        System.out.println("Initial bogie count: " + train.size());
        
        train.add("Sleeper");
        train.add("AC Chair");
        train.add("First Class");
        
        train.remove("AC Chair");
        
        boolean hasSleeper = train.contains("Sleeper");
        System.out.println("Contains Sleeper: " + hasSleeper);
        System.out.println("Final consist: " + train);
    }
}
