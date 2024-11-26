package crops;

import main.Crop;

/**
 * Potato class extending the Crop class.
 * @author Griffin Baxter and Rutger van Kruiningen
 */
public class Garlic extends Crop
{

    /**
     * Potato constructor.
     */
    public Garlic()
    {
        super("Garlic", 20.0, 50.0, 3);//Name, buy price, sell price, days to grow(harvestDays)
    }

}