package de.tud.swt.cleaningrobots;

import java.util.HashSet;
import java.util.Set;

import de.tud.swt.cleaningrobots.model.State;

/**
 * The abstract behavior class to create a behavior. 
 * 
 * @author Christopher Werner
 *
 */
public abstract class Behaviour {
	
	protected AgentCore agentCore;
	protected AgentRole agentRole;
	protected Demand demand;
	protected boolean hardwarecorrect;	
	protected Set<State> supportedStates;

	public Behaviour(AgentRole role){
		this(role.getRobotCore());
		this.agentRole = role;	
	}
	
	private Behaviour(AgentCore robot){
		this.agentCore = robot;
		this.supportedStates = new HashSet<State>();
		this.demand = new Demand(robot);
		this.addSupportedStates();
		this.addHardwareComponents();
		this.hardwarecorrect = demand.isCorrect();		
	}
	
	/**
	 * Add the supported states for each behavior.
	 * Run in the constructor.
	 */
	protected abstract void addSupportedStates ();
	
	/**
	 * Add the hardware components for each behavior.
	 * Run in the constructor.
	 */
	protected abstract void addHardwareComponents ();
	
	/**
	 * Does the actions implemented by the behavior
	 * @return value not important for results
	 * @throws Exception
	 */
	public abstract boolean action() throws Exception;
	
	/**
	 * Initialize some classes if needed before the first run.
	 */
	public abstract void initialiseBehaviour ();
		
	/**
	 * Gives back true if the agent has the needed Hardware.
	 * @return <b>true</b> hardware exists and <b>false</b> agent has not the right hardware
	 */
	public boolean isHardwarecorrect() {
		return hardwarecorrect;
	}
	
	/**
	 * Returns a copy of the SupportedStates Collection. 
	 * @return List of states that the behavior work with.
	 */
	public Set<State> getSupportedStates ()	{
		return supportedStates;
	}
}
