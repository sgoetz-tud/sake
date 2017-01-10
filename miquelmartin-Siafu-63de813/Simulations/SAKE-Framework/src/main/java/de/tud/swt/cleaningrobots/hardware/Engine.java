package de.tud.swt.cleaningrobots.hardware;

/**
 * The actuator component of a agent.
 * 
 * @author Christopher Werner
 *
 */
public class Engine extends HardwareComponent {

	public Engine ()
	{
		super("MOTOR");
		//0
		offEnergie = 0.0;
		//19Wh
		onEnergie = caluculateEnergie(19.0);
		//19Wh
		workEnergie = caluculateEnergie(19.0);
		//0
		outEnergie = 0.0;
	}

	@Override
	public ComponentTypes getComponentType() {
		return ComponentTypes.ACTUATOR;
	}
}
