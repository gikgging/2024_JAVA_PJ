package main;

/**
 * Crop class where crops are extended from.
 * Here the user can grow the crop, get days left to grow and get the sell price.
 * -Must be modified by SY and HJ-
 */
public class Crop implements StoreProduct
{
	//The kind(name) of the crop
	private String name;
	
	//The price as which the user would purchase the crop.
	private double buyPrice;
	
	//The price as which the user would sell the crop.
	private double sellPrice;
	
	//The Maximum Growth for the crop
	private int growthMax;

	//The Recent Growth of the crop
	private int growthNow = 0;
	
	/**
	 * Constructor function for Crop Class with each element
	 * kind: The name of the crop.
	 * i_buyPrice: The initial purchase price of the crop.
	 * i_sellPrice: The initial sell price of the crop.
	 * i_goalGrowth: The initial number of days the crop has to grow.
	 */
	public Crop(String kind, double i_buyPrice, double i_sellPrice, int i_goalGrowth)
	{
		name = kind;
		buyPrice = i_buyPrice;
		sellPrice = i_sellPrice;
		growthMax = i_goalGrowth;
	}
	
	/**
	 * for copying a crop class (this is used when you buy an crop).
	 * @param crop Crop class.
	 */
	public Crop(Crop crop)
	{
		name = crop.getName();
		buyPrice = crop.getBuyPrice();
		sellPrice = crop.getSellPrice();
		growthMax = crop.getGrowthMax();
		growthNow = 0;
	}
	
	/**
	 * Returns true of false depending on whether the crop can be harvested.
	 * This is done by checking if the <code>daysGrown</code> is greater than or equal to <code>daysToGrow</code>.
	 * @return true if the crop can be harvested, false otherwise.
	 */
	public boolean canHarvest() //이 항목을 날씨, growth score로 바꿔서 넣으면 될듯
	{
		if (growthNow >= growthMax)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Grows the crop by increasing its <code>daysGrown</code> only if the days left to grow is greater than 0.
	 */
	public void grow()
	{
		if (getLeftGrowth() > 0)
		{
			growthNow++; //점수 산정방식을 정해야함
		}
		
	}
	
	/**
	 * Tends to the crop by the specified double <code>daysToIncrease</code>, only if the days left to grow is greater than 0.
	 * @param daysToIncrease Number of days to increase growth by.
	 */
	public void tend(double increasedGrowing)
	{
		growthNow += increasedGrowing;
		if (getLeftGrowth() < 0)
		{
			growthNow = growthMax;
		}
	}
	
	/**
	 * Returns the purchase price of the crop.
	 * @return the purchase price.
	 */
	public double getBuyPrice()
	{
		return buyPrice;
	}	
	
	/**
	 * Returns the sell price of the crop.
	 * @return the sell price.
	 */
	public double getSellPrice()
	{
		return sellPrice;
	}
	
	/**
	 * Returns the name of the crop.
	 * @return the name of the crop.
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * Returns the number of days the crop has grown.
	 * @return The days the crop has grown.
	 */
	public int getGrowthNow() 
	{
		return growthNow;
	}
	
	/**
	 * Returns the number of days the crop needs to grow.
	 * @return The days the crop needs to grow.
	 */
	public int getGrowthMax() 
	{
		return growthMax;
	}
	
	/**
	 * Calculates and returns the days the crop has left to grow by subtracting the <code>daysGrown</code> from <code>daysToGrow</code>.
	 * @return The days the crop has left to grow.
	 */
	public int getLeftGrowth() 
	{
		return growthMax - growthNow;
	}
	
}
