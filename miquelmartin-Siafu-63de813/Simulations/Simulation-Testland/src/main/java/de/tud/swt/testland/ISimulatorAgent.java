package de.tud.swt.testland;

import de.tud.swt.cleaningrobots.AgentCore;

/**
 * Agent interface for the creation of different agent types in one factory.
 * 
 * @author Christopher Werner
 *
 */
public interface ISimulatorAgent {

	/**
	 * Makes on iteration step of the agent.
	 */
	public void wander();
	
	/**
	 * Return if the agent is finished.
	 * 
	 * @return finish state
	 */
	public boolean isFinish ();

	/**
	 * Return the underlying AgentCore of this SiafuAgent.
	 * 
	 * @return underlying agent core
	 */
	public AgentCore getAgentCore();

	/**
	 * Set the name of the agent later on.
	 * 
	 * @param name (new name of the robot)
	 */
	public void setName(String name);
	
	/**
	 * Set the different working speed of the agent.
	 * Normally don't do anything.
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed);	
}
