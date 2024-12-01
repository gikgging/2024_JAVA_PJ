package main;

import crops.Cabbage;
import crops.Garlic;
import crops.Pepper;
import crops.Rice;
import crops.Wheat;

public class CropFactory {
    public static Crop createCrop(String cropName) {
        switch(cropName) {
            case "Cabbage":
                return new Cabbage();
            case "Garlic":
                return new Garlic();
            case "Pepper":
                return new Pepper();
            case "Rice":
                return new Rice();
            case "Wheat":
                return new Wheat();
            default:
                return null;
        }
    }
}
