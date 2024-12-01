package products;

import main.Product;

/**
 * Bibimbap class extending the Product class.
 */

public class Bibimbap extends Product
{
	public Bibimbap()
	{
		super("Bibimbap", 470.0, 17); //Name, SalePrice(double), Strength(int)
		super.addIngrd("Rice", 4);
		super.addIngrd("Cabbage", 1);
		super.addIngrd("Galic", 1);
		super.addIngrd("Pepper", 2);
	}
}

