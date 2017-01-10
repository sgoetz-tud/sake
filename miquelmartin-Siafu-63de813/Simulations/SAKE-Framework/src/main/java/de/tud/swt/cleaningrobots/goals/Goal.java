/**
 * Overall goal package with abstract goal classes.
 */
package de.tud.swt.cleaningrobots.goals;

import java.util.Collection;

import de.tud.swt.cleaningrobots.AgentCore;
import de.tud.swt.cleaningrobots.model.State;

/**
 * The abstract Goal class for all goal methods.
 * 
 * @author Christopher Werner
 *
 */
public abstract class Goal {

	private AgentCore agent;
	protected boolean optional;
	
	public Goal (AgentCore core)
	{		
		this.agent = core;
	}
	
	/*public Goal (RobotRole role)
	{
		this.robotRole = role;		
		this.robot = role.getRobotCore();
	}*/
	
	/**
	 * Get the agent core only for the role code.
	 * @return
	 */
	protected AgentCore getAgentCore() {
		return agent;
	}
	
	/**
	 * Return if it is an optional goal.
	 * @return
	 */
	public abstract boolean isOptional ();
	
	/**
	 * Do all actions to finish the goal.
	 */
	public abstract void run();
	
	/**
	 * Return if the goal could run.
	 * @return
	 */
	public abstract boolean preCondition ();
	
	/**
	 * Return if the goal is finished with work.
	 * @return
	 */
	public abstract boolean postCondition ();
	
	/**
	 * Return if the agent has the correct hardware to finish the goal.
	 * @return
	 */
	public abstract boolean isHardwareCorrect ();
	
	/**
	 * Get a list of the supported states from the goal.
	 * @return
	 */
	public abstract Collection<State> getSupportedStates();
	
	/**
	 * Initialize the goal and all its behaviours.
	 */
	public abstract void initialize ();
}
