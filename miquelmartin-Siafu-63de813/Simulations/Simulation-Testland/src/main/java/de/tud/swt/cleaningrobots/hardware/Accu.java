package de.tud.swt.cleaningrobots.hardware;

/**
 * The engine information and management of the agent.
 * 
 * @author Christopher Werner
 *
 */
public class Accu {
	
	//48 Wh
	private double maxWh;
	//10%
	private double minWh;
	private double actualWh;
	
	public Accu (double max)
	{
		actualWh = max;
		maxWh = max;
		minWh = 0.1 * max;
	}
	
	public Accu (double min, double max)
	{
		maxWh = max;
		minWh = min;
		actualWh = max;
	}
	
	public Accu (double min, double max, double actual)
	{
		this(min,max);
		actualWh = actual;
	}
	
	/**
	 * Load the accumulator with the value.
	 * @param loadKWh
	 */
	public void load (double loadKWh)
	{
		actualWh += loadKWh;
		if (actualWh > maxWh)
		{
			actualWh = maxWh;
		}
	}

	/**
	 * Return if the accumulator is full.
	 * @return
	 */
	public boolean isFull ()
	{
		return actualWh == maxWh;
	}
	
	/**
	 * Shrink the capacity.
	 * @param useKWh
	 */
	public void use (double useKWh)
	{
		actualWh -= useKWh;
		if (actualWh < 0)
			actualWh = 0;
	}
	
	public double getMinKWh ()
	{
		return minWh;
	}
	
	public double getMaxKWh ()
	{
		return maxWh;
	}
	
	public double getActualKWh ()
	{
		return actualWh;
	}
	
	public double getRestKWh ()
	{
		return actualWh - minWh;
	}
	
	/**
	 * Get the iterations it could do before empty.
	 * @param Energie
	 * @return
	 */
	public double getMaxFieldGoes (double Energie)
	{
		return (maxWh - minWh) / Energie;
	}
}
