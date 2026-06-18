package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
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
        
        System.out.println("\n--- UC4: Ordered Train Formation ---");
        LinkedList<String> orderedFormation = new LinkedList<>();
        orderedFormation.add("Engine");
        orderedFormation.add("Sleeper");
        orderedFormation.add("AC");
        orderedFormation.add("Cargo");
        orderedFormation.add("Guard");
        
        System.out.println("Initial ordered formation: " + orderedFormation);
        
        // Insert Pantry Car (maybe middle? The req just says "Insert: Pantry Car". Let's use standard add or we can add it to a specific index. The concepts mention addFirst, addLast, but maybe just `orderedFormation.add(3, "Pantry Car");`)
        // Wait, "Concepts: LinkedList, addFirst(), addLast(), removeFirst(), removeLast()".
        // Let's use these.
        orderedFormation.addFirst("New Engine");
        orderedFormation.addLast("New Guard");
        // But req says "Insert: Pantry Car". I'll add it in the middle.
        orderedFormation.add(3, "Pantry Car");
        
        orderedFormation.removeFirst();
        orderedFormation.removeLast();
        
        System.out.println("Final ordered formation: " + orderedFormation);
    }
}
