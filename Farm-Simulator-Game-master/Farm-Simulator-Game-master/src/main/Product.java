package main;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import main.Farmer;

public class Product
{
	//The name of the product
	private String productName;
	
	//The ingredients for the product
	private Map<String, Integer> ingredients;
	
	//The price for the product to be sold
	private int sellPrice;
	
	//The decreased farmer's strength while making product
	private double decreaseStrength;
	
	
	//Constructor
	Product(String name, int i_sellPrice, double dec_strength)
	{
		productName = name;
		ingredients = new HashMap<>();
		sellPrice = i_sellPrice;
		decreaseStrength = dec_strength;
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
	
	public int getSellPrice()
	{
		return sellPrice;
	}
	
	public double getDecStr()
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
			} //For CropInventory
			else if(itemInven.containsKey(kindIngrd))
			{
				if(itemInven.get(kindIngrd) < ingredients.get(kindIngrd)) //hold amount < requested amount
				{
					return false;
				}
			} //For ItemInventory
		}
		
		return true;
	}
	
	public void addIngrd(String name, int totalAmount)
	{
		if(ingredients.containsKey(name))
		{
			ingredients.put(name, ingredients.get(name) + 1);
		}
		else
		{
			ingredients.put(name, 1);
		}
		return;
	}
	
	public void produce(Farmer farmer)
	{
		Map<String, Integer> cropInven = farmer.getCropInven();
		Map<String, Integer> itemInven = farmer.getItemInven();
		
		//Before using this function, "canProd()" must be called
		for(String kindIngrd : ingredients.keySet())
		{
			if(cropInven.containsKey(kindIngrd))
			{
				cropInven.subCropInven(kin)
			} //For CropInventory
			else if(itemInven.containsKey(kindIngrd))
			{
				if(itemInven.get(kindIngrd) < ingredients.get(kindIngrd)) //hold amount < requested amount
				{
					return false;
				}
			} //For ItemInventory
		}
	}
	
	
}
