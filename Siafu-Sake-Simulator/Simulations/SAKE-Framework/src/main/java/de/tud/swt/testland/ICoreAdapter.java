package de.tud.swt.testland;

import de.tud.swt.cleaningrobots.AgentCore;

public interface ICoreAdapter {

	/**
	 * Return the underlying AgentCore of this SiafuAgent.
	 * 
	 * @return underlying agent core
	 */
	public AgentCore getAgentCore();
	
	public void wander();
	
	/**
	 * Return if the agent is finished.
	 * 
	 * @return finish state
	 */
	public boolean isFinish ();
}
