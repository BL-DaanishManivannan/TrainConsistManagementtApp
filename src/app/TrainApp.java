package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        
        System.out.println("\n--- UC3: Unique Bogie IDs ---");
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BOGIE-001");
        bogieIds.add("BOGIE-002");
        bogieIds.add("BOGIE-001"); // Intentionally duplicate
        System.out.println("Final unique bogie IDs: " + bogieIds);
    }
}
