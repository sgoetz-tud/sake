package de.tud.swt.cleaningrobots.hardware;

/**
 * The Computer component of a agent.
 * 
 * @author Christopher Werner
 *
 */
public class Computer extends HardwareComponent {

	public Computer ()
	{
		super("RECHNER");
		//0,5Wh
		offEnergie = caluculateEnergie(5.0);
		//5Wh
		onEnergie = caluculateEnergie(5.0);
		//5Wh
		workEnergie = caluculateEnergie(5.0);
		//5Wh
		outEnergie = caluculateEnergie(0.5);
	}
	
	@Override
	public ComponentTypes getComponentType() {
		return ComponentTypes.COMPUTER;
	}

}
