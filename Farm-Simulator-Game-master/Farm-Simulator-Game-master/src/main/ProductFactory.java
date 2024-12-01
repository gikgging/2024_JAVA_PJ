package main;

import products.Baguette;
import products.Bibimbap;
import products.Bread;
import products.Kimchi;

public class ProductFactory {
    public static Product createProduct(String productName) {
        switch(productName) {
            case "Baguette":
                return new Baguette();
            case "Bibimbap":
                return new Bibimbap();
            case "Bread":
                return new Bread();
            case "Kimchi":
                return new Kimchi();
            default:
                return null; 
        }
    }
}
