package de.tud.swt.testland;

/**
 * Interface for different agent creation.
 * 
 * @author Christopher Werner
 *
 */
public interface ISimulatorAgentFactory {

	/**
	 * Create a load station without computational hardware agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public ISimulatorAgent createLoadStation();
	
	/**
	 * Create a active load station agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public ISimulatorAgent createLoadStationAgent();
	
	/**
	 * Create a explore agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public ISimulatorAgent createExploreAgent();
	
	/**
	 * Create a wipe agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public ISimulatorAgent createWipeAgent();
	
	/**
	 * Create a hoove agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public ISimulatorAgent createHooveAgent();
	
}
