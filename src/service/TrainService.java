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
}
