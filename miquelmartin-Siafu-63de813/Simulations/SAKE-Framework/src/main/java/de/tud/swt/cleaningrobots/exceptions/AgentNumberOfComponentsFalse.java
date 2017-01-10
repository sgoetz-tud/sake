package de.tud.swt.cleaningrobots.exceptions;

/**
 * Agent has not so much component of this name.
 * 
 * @author Christopher Werner
 *
 */
public class AgentNumberOfComponentsFalse extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1779681387579930733L;

	public AgentNumberOfComponentsFalse ()
	{
		super("The Agent has not so much Components of one Type.");
	}

}
