package de.tud.swt.cleaningrobots.hardware;

/**
 * State interface for the state pattern.
 * 
 * @author Christopher Werner
 *
 */
public interface EnergyState {
	
	/**
	 * Switch the hardware component on.
	 * @param hc
	 */
	public void switchOn(HardwareComponent hc);
	
	/**
	 * Switch the hardware component of.
	 * @param hc
	 */
	public void switchOff(HardwareComponent hc);
	
	/**
	 * Hardware component can work or not.
	 * @return
	 */
	public boolean isActive();
}
