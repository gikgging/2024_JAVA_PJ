package main;

import crops.Cabbage;
import crops.Garlic;
import crops.Pepper;
import crops.Rice;
import crops.Wheat;

import items.Compost;
import items.Egg;
import items.Namool;
import items.RedBull;

import java.util.ArrayList;

/**
 * Store class where the user can purchase Crops, Animals and Items from.
 * @author Griffin Baxter and Rutger van Kruiningen
 */
public class Store
{

	/**
	 * The crops the store has for sale.
	 */
	private ArrayList<Crop> cropsInStore = new ArrayList<Crop>();

	/**
	 * The items the store has for sale.
	 */
	private ArrayList<Item> itemsInStore = new ArrayList<Item>();
	
	
	private ArrayList<Product> productsInStore = new ArrayList<Product>();
	
	/**
	 * Constructor function for Store Class, this constructor takes a variable <code>initAnimalHappiness</code> and gives all animals that base happiness.
	 * This Constructor also fills the crops, animals and items for sale Array Lists with values.
	 * @param initAnimalHappiness The initial animal happiness.
	 */
	public Store()
	{
		// Crops
		cropsInStore.add(new Cabbage());
		cropsInStore.add(new Garlic());
		cropsInStore.add(new Pepper());
		cropsInStore.add(new Rice());
		cropsInStore.add(new Wheat());
		
		// Items
		// The bonus for crops is an increase in the days grown
		itemsInStore.add(new Compost());
		
		// The bonus for the farmer increases his strength
		itemsInStore.add(new RedBull());
		
		// The ingredients for some product
		itemsInStore.add(new Egg());
		itemsInStore.add(new Namool());
	}
	
	/**
	 * Returns the cropsForSale ArrayList.
	 * @return The cropsForSale.
	 */
	public ArrayList<Crop> getCropsInStore()
	{
		return cropsInStore;
	}
	
	/**
	 * Returns the itemsForSale ArrayList.
	 * @return The itemsForSale.
	 */
	public ArrayList<Item> getItemsInStore()
	{
		return itemsInStore;
	}
	
	/**
	 * return Crop at <code>index</code> to be purchased.
	 * @param index Index of crop to buy.
	 * @return The Crop at specified <code>index</code>.
	 */
	public Crop buyCrops(int index)
	{
		return cropsInStore.get(index);
	}
	
	/**
	 * return Item at <code>index</code> to be purchased.
	 * @param index Index of item to buy.
	 * @return The Item at specified <code>index</code>.
	 */
	public Item buyItems(int index)
	{
		return itemsInStore.get(index);
	}
	
}
