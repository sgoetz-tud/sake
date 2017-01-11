/**
 * Exception package for underlying existing exceptions.
 */
package de.tud.swt.cleaningrobots.exceptions;

/**
 * Agent has no component with this name.
 * 
 * @author Christopher Werner
 *
 */
public class AgentHasNoSuchComponent extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1798671255326056599L;

	public AgentHasNoSuchComponent (String name)
	{
		super("Agent has no Component with the name: " + name + "!");
	}

}
