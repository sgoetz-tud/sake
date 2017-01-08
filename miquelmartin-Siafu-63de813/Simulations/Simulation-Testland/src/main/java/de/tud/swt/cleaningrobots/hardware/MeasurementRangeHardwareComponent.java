package de.tud.swt.cleaningrobots.hardware;

/**
 * Hardware component with a specific range to measure its values.
 * 
 * @author Christopher Werner
 *
 */
public abstract class MeasurementRangeHardwareComponent extends HardwareComponent {

	private int radius;
	
	public MeasurementRangeHardwareComponent (String name, int radius)
	{
		super(name);		
		this.radius = radius;
	}
	
	/**
	 * Get the measurement range.
	 * @return
	 */
	public int getMeasurementRange ()
	{
		return radius;
	}
}
