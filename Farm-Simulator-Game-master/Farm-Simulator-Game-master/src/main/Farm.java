package main;

import java.util.ArrayList;

/**
 * Farm class where the users farm gets managed.
 * Here the user can get set the farm type, tend to their farm and tend to their crops.
 */
public class Farm
{
	
	//Farm Name
	private String farmName;
	
	//Crops ArrayList
	private ArrayList<Crop> crops = new ArrayList<Crop>(); //이게 뭐야 쓰읍
	
	//Items ArrayList
	private ArrayList<Item> items = new ArrayList<Item>();
	
	//Products ArrayList
	private ArrayList<Product> prods = new ArrayList<Product>();
	
	//Money the farm has
	private double money;
	
	/**
	 * Initial money owned when the game started.
	 */
	private double initMoney;
	
	/**
	 * Total crop space available.
	 */
	private int cropSpace;
	
	//Farmer who is working on the farm
	private Farmer farmer;
	
	
	/**
	 * Constructor function for Farm Class, this constructor initialises variables <code>farmName</code> and Sets the farm type.
	 * @param name The name of the farmer.
	 * @param type The type of the farmer in String format.
	 */
	public Farm(String name, String type, Farmer initFarmer) 
	{
        farmName = name;
        setFarmType(type);
        farmer = initFarmer;
    }
	
	/**
	 * Sets the farm type from the <code>type</code> String, and uses if statements to set the farm type.
	 * @param type Type of the farm.
	 */
	public void setFarmType(String type)
	{
		if (type == "Normal") // Normal Farm
		{
			initMoney = 150;
			cropSpace = 10;
		}
		else if (type == "Rich") // Rich Farm
		{
			initMoney = 200;
			cropSpace = 10;
		}
		else if (type == "Happy") // Happy Farm
		{
			initMoney = 100;
			cropSpace = 10;
		}
		else // Large Farm
		{
			initMoney = 100;
			cropSpace = 20;
		}
		money = initMoney;	
	}
	
	/**
	 * Tends to the Farm to make animals happier and increase space available, returns true if there are animals to increase their happiness, otherwise returns false.
	 * @return true if there are animals, false otherwise.
	 */
	public boolean tendFarm()
	{
		cropSpace++;
		return increaseHappinessAllAnimals();
	}
	
	/**
	 * Calculates the available free space.
	 * @return Returns the available free space.
	 */
	public int calculateFreeSpace() 
	{
		return cropSpace - crops.size();
	}
	
	/**
	 * Increase the money the farm has by the indicated difference (<code>alpha</code>).
	 * @param alpha The increase of money.
	 */
	public void increaseMoney(double alpha)
	{
		money += alpha;
	}

	/**
	 * Decrease the money the farm has by the indicated difference (<code>alpha</code>).
	 * @param alpha The decrease of money.
	 */
	public void decreaseMoney(double alpha)
	{
		money -= alpha;
	}
	
	/**
	 * Returns true if any of the crops owned can be harvested, false otherwise. Used to determine whether to harvest crops or not.
	 * @return true if crops can be harvested, false otherwise.
	 */
	public boolean canHarvestCrops() 
	{
		for(Crop crop: crops)
		{
			if (crop.canHarvest())
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A function that harvests all crops that can be harvested.
	 * Loops through all crops owned and checks if they can be harvested. If they can, they get harvested.
	 * The function then returns the total money made from harvesting the crops.
	 * @return The total money made form harvesting the crops.
	 */
	public double harvestAvailableCrops() //Inventory로 저장되게끔 수정
	{
		double moneyMade = 0;
		
		ArrayList<Crop> cropsToRemove = new ArrayList<Crop>();
		
		for(Crop crop: crops)
		{
			if (crop.canHarvest())
			{
				cropsToRemove.add(crop);
				moneyMade += crop.getSellPrice();
			}
		}
		
		for (Crop crop: cropsToRemove) 
		{
			crops.remove(crops.indexOf(crop));
		}
		
		return moneyMade;
	}
	
	/**
	 * A function to grow all of the crops owned, it does this by looping through all of the crops and calling their grow method.
	 */
	public void growCrops()
	{
		for(Crop crop: crops) 
		{
			crop.grow();
		}
	}
	
	/**
	 * Tends to specific crops with the name cropName and increases their growth time by daysToIncrease
	 * @param cropName The name of the crop.
	 * @param daysToIncrease The days to increase the crop growth by.
	 */
	public void tendSpecificCrops(String cropName, double daysToIncrease)
	{
		for(Crop crop: crops) 
		{
			if (crop.getName() == cropName)
			{
				crop.tend(daysToIncrease);
			}
		} 
	}

	
	/**
	 * Increase crops owned from the crop passed through the method  by adding it to the <code>crops</code> ArrayList.
	 * @param crop The crop being purchased.
	 */
	public void increaseCrops(Crop crop)
	{
		crops.add(new Crop(crop));
		farmer.addCropInven(crop.getName()); //SY added it
		money -= crop.getBuyPrice();
	}
	
	/**
	 * Increase items owned from the item passed through the method  by adding it to the <code>items</code> ArrayList.
	 * @param item The item being purchased.
	 */
	public void increaseItems(Item item)
	{
		items.add(new Item(item));
		farmer.addItemInven(item.getName()); //SY added it
		money -= item.getBuyPrice();
	}
	
	public void decreaseCrops(Crop crop) // It decreased one by one & SY added it
	{
		crops.remove(crops.indexOf(crop));
		farmer.subCropInven(crop.getName(), 1);
		return;
	}
	
	/**
	 * Removes an item from the <code>items</code> ArrayList by finding the item and then removing it.
	 * @param item The item to remove.
	 */
	public void decreaseItems(Item item) // It decreased one by one & It's the original form
	{
		items.remove(items.indexOf(item));
		farmer.subItemInven(item.getName(), 1); //SY added it
		return;
	}
	
	public void decreaseProds(Product prod) // It decreased one by one & SY added it
	{
		prods.remove(prods.indexOf(prod));
		farmer.subProductInven(prod.getName(), 1);
		return;
	}
	
	/**
	 * Returns the crops in String format by having one crop per line. adds it to the <code>cropString</code> passed in through the method.
	 * @param cropsString Initial String to be added to and returned.
	 * @param crops Crops to be added to the crop string.
	 * @return A String with the format of one crop per line.
	 */
	public String returnCropsString(String cropsString, ArrayList<Crop> crops) 
	{
		int index = 0;
		for(Crop crop: crops) 
		{
			index++;
			cropsString += index + ". " + crop.getName() + "\n";
		}
		return cropsString;
	}
	
	/**
	 * Returns the items in String format by having one item per line. adds it to the <code>itemString</code> passed in through the method.
	 * Only adds items with the specified <code>itemType</code>
	 * @param itemString Initial String to be added to and returned.
	 * @param itemType The type of the item.
	 * @param index Index to start counting from.
	 * @return A String with the format of one item per line.
	 */
	public String returnItemsString(String itemString, String itemType, int index) 
	{
		for(Item item: items) 
		{
			if (item.getType() == itemType)
			{
				index++;
				itemString += index + ". " + item.getName() + "\n";
			}
		}
		return itemString;
	}
	
	/**
	 * Returns the current available money for the farm.
	 * @return Money available.
	 */
	public double getMoney()
	{
		return money;
	}
	
	/**
	 * Returns the profit the farm has made by subtracting <code>initMoney</code> from <code>money</code>.
	 * @return The profit of the farm.
	 */
	public double getProfit()
	{
		return money - initMoney;
	}
	
	/**
	 * Returns the farm name from the <code>farmName</code> variable.
	 * @return The farm name.
	 */
	public String getFarmName() 
	{
		return farmName;
	}
	
	/**
	 * Returns the crops the farm currently has planted from the crops ArrayList.
	 * @return An ArrayList of crops owned.
	 */
	public ArrayList<Crop> getCrops() 
	{
		return crops;
	}
	
	/**
	 * Returns the items the farm currently owns from the items ArrayList.
	 * @return An ArrayList of items owned.
	 */
	public ArrayList<Item> getItems() 
	{
		return items;
	}
	
	public ArrayList<Product> getProds()
	{
		return prods;
	}
	
	/**
	 * Returns the total crop space the farm has.
	 * @return The crop space.
	 */
	public int getCropSpace() 
	{
		return cropSpace;
	}
	
}