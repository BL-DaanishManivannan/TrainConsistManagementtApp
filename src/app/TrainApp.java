package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import model.Bogie;

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
        
        System.out.println("\n--- UC5: Ordered Unique Formation ---");
        Set<String> uniqueOrderedFormation = new LinkedHashSet<>();
        uniqueOrderedFormation.add("Engine");
        uniqueOrderedFormation.add("Sleeper");
        uniqueOrderedFormation.add("Cargo");
        uniqueOrderedFormation.add("Guard");
        
        System.out.println("Initial unique ordered formation: " + uniqueOrderedFormation);
        
        uniqueOrderedFormation.add("Sleeper"); // Attempt duplicate insertion
        
        System.out.println("Final unique ordered formation: " + uniqueOrderedFormation);
        
        System.out.println("\n--- UC6: Bogie Capacity Mapping ---");
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        
        System.out.println("Bogie Capacity Mappings:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        System.out.println("\n--- UC7: Sort Bogies by Capacity ---");
        List<Bogie> bogiesList = new ArrayList<>();
        bogiesList.add(new Bogie("Sleeper", 72));
        bogiesList.add(new Bogie("AC Chair", 56));
        bogiesList.add(new Bogie("First Class", 24));
        bogiesList.add(new Bogie("Cargo", 120));
        
        Collections.sort(bogiesList, (b1, b2) -> Integer.compare(b1.getCapacity(), b2.getCapacity()));
        
        System.out.println("Bogies sorted by capacity:");
        for (Bogie bogie : bogiesList) {
            System.out.println(bogie);
        }
        
        System.out.println("\n--- UC8: Filter Bogies Using Streams ---");
        int threshold = 50;
        List<Bogie> filteredBogies = bogiesList.stream()
            .filter(b -> b.getCapacity() > threshold)
            .collect(Collectors.toList());
            
        System.out.println("Bogies with capacity > " + threshold + ":");
        for (Bogie bogie : filteredBogies) {
            System.out.println(bogie);
        }
        
        System.out.println("\n--- UC9: Aggregate Capacity Analytics ---");
        int totalCapacity = bogiesList.stream().mapToInt(Bogie::getCapacity).sum();
        double averageCapacity = bogiesList.stream().mapToInt(Bogie::getCapacity).average().orElse(0.0);
        int maxCapacity = bogiesList.stream().mapToInt(Bogie::getCapacity).max().orElse(0);
        int minCapacity = bogiesList.stream().mapToInt(Bogie::getCapacity).min().orElse(0);
        
        System.out.println("Total Capacity: " + totalCapacity);
        System.out.println("Average Capacity: " + averageCapacity);
        System.out.println("Maximum Capacity: " + maxCapacity);
        System.out.println("Minimum Capacity: " + minCapacity);
    }
}
