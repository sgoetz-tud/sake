package de.tud.swt.cleaningrobots.factory;

import java.util.ArrayList;

import de.nec.nle.siafu.model.Agent;
import de.tud.swt.cleaningrobots.Configuration;
import de.tud.swt.testland.AgentFactory;

/**
 * Abstract Factory class to create the different strategies.
 * 
 * @author Christopher Werner
 *
 */
public abstract class ISimulationFactory {
	
	protected Configuration configuration;
	
	public ISimulationFactory (Configuration configuration)
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
	public abstract ArrayList<Agent> createRobots(AgentFactory factory);
}
