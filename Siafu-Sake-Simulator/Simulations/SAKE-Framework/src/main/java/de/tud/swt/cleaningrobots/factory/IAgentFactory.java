package de.tud.swt.cleaningrobots.factory;

import java.util.ArrayList;

import de.tud.swt.cleaningrobots.Configuration;
import de.tud.swt.testland.SiafuAgent;
import de.tud.swt.testland.SiafuAgentFactory;

/**
 * Abstract Factory class to create the different strategies.
 * 
 * @author Christopher Werner
 *
 */
public abstract class IAgentFactory {
	
	protected Configuration configuration;
	
	public IAgentFactory (Configuration configuration)
	{
		this.configuration = configuration;
	}

	/**
	 * Create a number of random agents.
	 * 
	 * @param world
	 *            the world where the agents will dwell
	 * @return an ArrayList with the created agents
	 */
	public abstract ArrayList<SiafuAgent> createRobots(SiafuAgentFactory factory);
}
