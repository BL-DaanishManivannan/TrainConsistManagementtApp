package service;

import model.Bogie;
import model.GoodsBogie;
import model.Train;

import java.util.Arrays;
import java.util.List;

public class TrainService {
    private static final List<String> ALLOWED_CARGO = Arrays.asList("Food Cargo", "Chemical Cargo", "Coal", "General");
    private static final int MAX_TRAIN_CAPACITY = 1000;

    public boolean validateConsist(Train train) {
        if (train.getTotalCapacity() > MAX_TRAIN_CAPACITY) {
            System.out.println("Validation failed: Train capacity exceeds limit.");
            return false;
        }

        for (Bogie bogie : train.getBogies()) {
            if (bogie instanceof GoodsBogie) {
                GoodsBogie goodsBogie = (GoodsBogie) bogie;
                if (!ALLOWED_CARGO.contains(goodsBogie.getCargoType())) {
                    System.out.println("Validation failed: Not allowed cargo type - " + goodsBogie.getCargoType());
                    return false;
                }
            }
        }
        
        System.out.println("Validation passed: Consist is safe and valid.");
        return true;
    }

    public void generateReport(Train train) {
        System.out.println("--- Train Consist Report ---");
        System.out.println("Total Bogies: " + train.getBogies().size());
        
        int passengerCapacity = 0;
        int cargoCapacity = 0;
        
        System.out.println("Formation Sequence:");
        for (int i = 0; i < train.getBogies().size(); i++) {
            Bogie bogie = train.getBogies().get(i);
            System.out.println("  " + (i + 1) + ". " + bogie.getId() + " (" + bogie.getType() + ")");
            
            if (bogie instanceof model.PassengerBogie) {
                passengerCapacity += ((model.PassengerBogie) bogie).getSeatCapacity();
            } else if (bogie instanceof GoodsBogie) {
                cargoCapacity += ((GoodsBogie) bogie).getLoadCapacity();
            }
        }
        
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Cargo Capacity: " + cargoCapacity);
        
        boolean isSafe = validateConsist(train);
        System.out.println("Safety Status: " + (isSafe ? "SAFE" : "UNSAFE"));
        System.out.println("----------------------------");
    }
}
