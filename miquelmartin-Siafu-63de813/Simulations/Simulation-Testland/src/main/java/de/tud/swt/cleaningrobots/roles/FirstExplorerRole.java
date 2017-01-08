package de.tud.swt.cleaningrobots.roles;

import de.tud.swt.cleaningrobots.AgentCore;
import de.tud.swt.cleaningrobots.AgentRole;
import de.tud.swt.cleaningrobots.goals.optional.WithoutMasterExploreOptionalGoal;

/**
 * Add the goals where no master is needed.
 */
public class FirstExplorerRole extends AgentRole {

	public FirstExplorerRole(AgentCore robotCore) {
		super(robotCore);
	}

	@Override
	public boolean createGoals() {

		WithoutMasterExploreOptionalGoal wmg = new WithoutMasterExploreOptionalGoal(this);
		if (wmg.isHardwareCorrect())
		{
			this.addGoals(wmg);
		}
		else
		{
			throw new RuntimeException("Hardeware is not correct for this goal!");
		}
		return wmg.isHardwareCorrect();
	}

}
