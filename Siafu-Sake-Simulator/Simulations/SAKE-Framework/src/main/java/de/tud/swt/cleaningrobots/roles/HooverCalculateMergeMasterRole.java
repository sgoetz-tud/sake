package de.tud.swt.cleaningrobots.roles;

import de.tud.swt.cleaningrobots.AgentCore;
import de.tud.swt.cleaningrobots.goals.optional.CalculateHooveAgentPositionGoal;

/**
 * Add the goal to calculate new hoove destinations for all followers.
 * 
 * @author Christopher Werner
 * 
 */
public class HooverCalculateMergeMasterRole extends MergeMasterRole {

	public HooverCalculateMergeMasterRole(AgentCore robotCore) {
		super(robotCore);
	}
	
	@Override
	public boolean createGoals() {
		boolean result = super.createGoals();
		
		CalculateHooveAgentPositionGoal crpg = new CalculateHooveAgentPositionGoal(this);
		if (crpg.isHardwareCorrect())
		{
			this.addGoals(crpg);
		}
		else
		{
			throw new RuntimeException("Hardeware is not correct for this goal!");
		}
		return result && crpg.isHardwareCorrect();
	}

}
