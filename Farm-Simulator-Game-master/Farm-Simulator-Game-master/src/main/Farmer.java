package main;

import java.util.HashMap;
import java.util.Map;
import main.Crop;
import main.Item;

/**
 * Farmer class where the users farmer is.
 * Here the users farmer gets set up.
 */

public class Farmer 
{

	//The name of the farmer.
	private String farmerName;
	
	//The Strength of the farmer.
	private int farmerStrength;
	
	//The days passed of the farmer on the farm, starts at 1.
	private int farmerDays;
	
	//The inventory for crops
	private Map<String, Integer> cropInventory = new HashMap<>();
	
	//The inventory for items
	private Map<String, Integer> itemInventory = new HashMap<>();
	
	/**
	 * Constructor function for Farmer Class
	 * Name: Name of the farmer.
	 * Days: The Days passed while farming.
	 * Strength: The Strength of the farmer.
	 */
	public Farmer(String name, int strength, int days)
	{
		farmerName = name;
		farmerStrength = strength;
		farmerDays = days;
		
		//Initialize cropInventory
		cropInventory.put("Cabbage", 0);
		cropInventory.put("Garlic", 0);
		cropInventory.put("Pepper", 0);
		cropInventory.put("Rice", 0);
		cropInventory.put("Wheat", 0);
		
		//Initialize itemInventory
		itemInventory.put("Compost", 0);
		itemInventory.put("Egg", 0);
		itemInventory.put("Namool", 0);
		itemInventory.put("RedBull", 0);
	}
	
	//Function to increase the days passed of the farmer on the farm, increases the days passed by 1
	public void increaseDaysPassed()
	{
		farmerDays++;
	}
	
	//Returns the farmer's strength.
	public int getFarmerStrength()
	{
		return farmerStrength;
	}
	
	//Returns the days passed for the farmer.
	public int getDays()
	{
		return farmerDays;
	}
	
	//Returns the farmer's name.
	public String getFarmerName()
	{
		return farmerName;
	}
	
	//Returns Inventory for Crops
	public Map<String, Integer> getCropInven()
	{
		return cropInventory;
	}
	
	//Returns Inventory for Items
	public Map<String, Integer> getItemInven()
	{
		return itemInventory;
	}
	
	//Add an Item in Crop Inventory
	public void addCropInven(Crop crop)
	{
		String name = crop.getName();
		if(cropInventory.containsKey(name))
		{
			cropInventory.put(name, cropInventory.get(name)+1);
		}
		return;
	}
	
	//Add an Item in Item Inventory
	public void addItemInven(Item item)
	{
		String name = item.getName();
		if(itemInventory.containsKey(name))
		{
			itemInventory.put(name, itemInventory.get(name)+1);
		}
		return;
	}
	
	//Remove an Item from Crop Inventory
	public void subCropInven(Crop crop)
	{
		String name = crop.getName();
		if(cropInventory.containsKey(name))
		{
			Integer value = getCropValue(crop);
			if(value != null && value > 0)
			{
				cropInventory.put(name, value-1);
			}
			else
			{
				cropInventory.put(name, 0);
			}
		}
		return;
	}
	
	//Remove an Item from Item Inventory
	public void subItemInven(Item item)
	{
		String name = item.getName();
		if(itemInventory.containsKey(name))
		{
			Integer value = getItemValue(item);
			if(value != null && value > 0)
			{
				itemInventory.put(name, value-1);
			}
			else
			{
				itemInventory.put(name, 0);
			}
		}
		return;
	}
	
	//Returns value of the crop (when it doesn't exist -> null)
	public Integer getCropValue(Crop crop) 
	{
		String name = crop.getName();
		if(cropInventory.containsKey(name))
		{
			return cropInventory.get(name);
		}
		else
			return null;
	}
	
	//Returns value of the item (when it doesn't exist -> null)
	public Integer getItemValue(Item item) 
	{
		String name = item.getName();
		if(itemInventory.containsKey(name))
		{
			return itemInventory.get(name);
		}
		else
			return null;
	}
}
