package de.tud.swt.cleaningrobots.roles;

import de.tud.swt.cleaningrobots.AgentCore;
import de.tud.swt.cleaningrobots.AgentRole;
import de.tud.swt.cleaningrobots.goals.optional.LoadIfAgentWantGoal;

/**
 * Add the goal to load agents if they wand.
 * 
 * @author Christopher Werner
 * 
 */
public class LoadstationRole extends AgentRole {

	public LoadstationRole(AgentCore robotCore) {
		super(robotCore);
	}

	@Override
	public boolean createGoals() {
		
		LoadIfAgentWantGoal lirwg = new LoadIfAgentWantGoal(this);		
		if (lirwg.isHardwareCorrect())
		{
			this.addGoals(lirwg);
		}
		else
		{
			throw new RuntimeException("Hardeware is not correct for this goal!");
		}
		return lirwg.isHardwareCorrect();
	}

}
