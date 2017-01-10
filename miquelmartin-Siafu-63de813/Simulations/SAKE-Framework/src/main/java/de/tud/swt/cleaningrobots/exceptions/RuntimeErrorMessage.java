package de.tud.swt.cleaningrobots.exceptions;

/**
 * Send a run time error with die incoming message.
 * 
 * @author Christopher Werner
 *
 */
public class RuntimeErrorMessage extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3676414553057719545L;

	public RuntimeErrorMessage (String message)
	{
		super(message);
	}
}
