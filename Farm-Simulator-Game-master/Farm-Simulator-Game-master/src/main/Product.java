package main;

import java.util.Map;
import java.util.HashMap;
import main.Farmer;

public class Product
{
	//The name of the product
	private String productName;
	
	//The ingredients for the product
	private Map<String, Integer> ingredients;
	
	//The price for the product to be sold
	private double sellPrice;
	
	//The decreased farmer's strength while making product
	private int decreaseStrength;
	
	
	//Constructor
	public Product(String name, double i_sellPrice, int dec_strength)
	{
		productName = name;
		ingredients = new HashMap<>();
		sellPrice = i_sellPrice;
		decreaseStrength = dec_strength;
	}
	
	public Product(Product prod)
	{
		productName = prod.productName;
		ingredients = prod.ingredients;
		sellPrice = prod.sellPrice;
		decreaseStrength = prod.decreaseStrength;
	}
	
	//Functions for returning value
	public String getName()
	{
		return productName;
	}
	
	public Map<String, Integer> getIngrd()
	{
		return ingredients;
	}
	
	public double getSellPrice()
	{
		return sellPrice;
	}
	
	public int getDecStr()
	{
		return decreaseStrength;
	}
	
	//Functions
	public boolean canProd(Farmer farmer)
	{
		Map<String, Integer> cropInven = farmer.getCropInven();
		Map<String, Integer> itemInven = farmer.getItemInven();
		
		for(String kindIngrd : ingredients.keySet())
		{
			if(cropInven.containsKey(kindIngrd))
			{
				if(cropInven.get(kindIngrd) < ingredients.get(kindIngrd)) //hold amount < requested amount
				{
					return false;
				}
			} //Find it from CropInventory
			else if(itemInven.containsKey(kindIngrd))
			{
				if(itemInven.get(kindIngrd) < ingredients.get(kindIngrd)) //hold amount < requested amount
				{
					return false;
				}
			} //Find it from ItemInventory
		}
		
		if(farmer.getFarmerStrength() < decreaseStrength)
		{
			return false;
		} //If needed Strength is bigger than his actual strength
		
		return true;
	}
	
	public void addIngrd(String name, int totalAmount)
	{
		ingredients.put(name, totalAmount);
		return;
	}
	
	public boolean produce(Farmer farmer)
	{
		Map<String, Integer> cropInven = farmer.getCropInven();
		Map<String, Integer> itemInven = farmer.getItemInven();
		
		//Before using this function, "canProd()" must be called
		for(String kindIngrd : ingredients.keySet())
		{
			int neededIngrd = ingredients.get(kindIngrd);
			
			//What I wanna produce is in the cropInven and there are ingredients more than I needed
			if(cropInven.containsKey(kindIngrd) && (farmer.getCropValue(kindIngrd) >= neededIngrd))
			{
				farmer.subCropInven(kindIngrd, neededIngrd);
				continue;
			} //For CropInventory
			
			//What I wanna produce is in the itemInven and there are ingredients more than I needed
			else if(itemInven.containsKey(kindIngrd) && (farmer.getItemValue(kindIngrd) >= neededIngrd))
			{
				farmer.subItemInven(kindIngrd, neededIngrd);
				continue;
			} //For ItemInventory
			
			return false; //It means "There's an error while producing the product"
		}
		
		if(farmer.getFarmerStrength() < decreaseStrength)
		{
			farmer.subStrength(decreaseStrength);
		}
		else return false; //Use Strength to produce the product.
		
		return true; //It means "Producing is successfully complete!"
	}
	
	
}
