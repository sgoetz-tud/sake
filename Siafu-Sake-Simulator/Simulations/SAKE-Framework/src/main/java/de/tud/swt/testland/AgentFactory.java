package de.tud.swt.testland;

import de.nec.nle.siafu.model.Agent;
import de.nec.nle.siafu.model.World;
import de.tud.swt.cleaningrobots.Configuration;

public abstract class AgentFactory {

	protected int counter;
	protected Configuration configuration;
	protected World world;
	
	public AgentFactory (Configuration configuration, World world) {
		this.world = world;
		this.configuration = configuration;
		this.counter = 0;
	}
	
	/**
	 * Create only a load station without any computer.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public abstract Agent createLoadStation();
	
	/**
	 * Create a load station agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public abstract Agent createLoadStationAgent();
	
	/**
	 * Create a explore agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public abstract Agent createExploreAgent();
	
	/**
	 * Create a wipe agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public abstract Agent createWipeAgent();
	
	/**
	 * Create a hoove agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public abstract Agent createHooveAgent();
}
