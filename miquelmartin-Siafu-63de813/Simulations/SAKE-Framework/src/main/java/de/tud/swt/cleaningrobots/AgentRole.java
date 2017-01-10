package de.tud.swt.cleaningrobots;

import java.util.ArrayList;
import java.util.List;

import de.tud.swt.cleaningrobots.goals.Goal;

/**
 * Abstract agent role for role-based pattern.
 * 
 * @author Christopher Werner
 *
 */
public abstract class AgentRole extends Agent {
	
	protected AgentCore core;
	private List<Goal> roleGoals;
	
	public AgentRole (AgentCore robotCore) {
		this.core = robotCore;
		this.roleGoals = new ArrayList<Goal>();
	}
	
	/**
	 * Run over all goals and initialize them.
	 */
	public void initializeGoals () {
		//initialize all goals
		for (Goal g : roleGoals)
		{
			g.initialize();
		}			
	}
	
	/**
	 * Create the specific goals for each role.
	 * @return
	 */
	public abstract boolean createGoals();
		
	protected boolean addGoals(Goal goal) {
		this.roleGoals.add(goal);
		return this.core.addGoal(goal);
	}
	
	/**
	 * Get the RobotCore object of this role.
	 * @return
	 */
	public AgentCore getRobotCore() {
		return core;
	}	

	@Override
	public boolean addRole(AgentRole role) {
		return this.core.addRole(role);
		
	}

	@Override
	public boolean hasRole(AgentRole role) {
		return this.core.hasRole(role);
	}

	@Override
	public boolean removeRole(AgentRole role) {
		return this.core.removeRole(role);		
	}
	
	@Override
	public String toString() {
		return core.getName() + super.toString();
	}

}
