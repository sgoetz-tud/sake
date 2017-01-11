package de.tud.swt.cleaningrobots.exceptions;

/**
 * The hardware component is not defined in the XML file.
 * 
 * @author Christopher Werner
 *
 */
public class HardwareComponentExistenzException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1031935982967382991L;

	public HardwareComponentExistenzException ()
	{
		super("The Hardware Component must be defined in the XML!");
	}

}
