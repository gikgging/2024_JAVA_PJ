package crops;

import main.Crop;

/**
 * Parsnip class extending the Crop class.
 * @author Griffin Baxter and Rutger van Kruiningen
 */
public class Pepper extends Crop
{

    /**
     * Parsnip constructor.
     */
    public Pepper()
    {
        super("Pepper", 15.0, 40.0, 2);//Name, buy price, sell price, days to grow(harvestDays)
    }

}