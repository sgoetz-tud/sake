package de.tud.swt.cleaningrobots.roles;

import de.tud.swt.cleaningrobots.AgentCore;
import de.tud.swt.cleaningrobots.goals.MasterGoal;
import de.tud.swt.cleaningrobots.goals.nonoptional.WipeLoadGoal;
import de.tud.swt.cleaningrobots.goals.optional.WlanLoadIfAgentWantMergeGoal;

/**
 * Add the goals for search a new relative destination for wipe agents.
 * 
 * @author Christopher Werner
 * 
 */
public class WiperRelativeFollowerRole extends FollowerRole {

	public WiperRelativeFollowerRole(AgentCore robotCore, MasterRole master) {
		super(robotCore, master);
	}

	@Override
	public boolean createGoals() {
		
		WipeLoadGoal wlg = new WipeLoadGoal(this, true);
		WlanLoadIfAgentWantMergeGoal wlmmg = new WlanLoadIfAgentWantMergeGoal(this);
		
		MasterGoal mg = new MasterGoal(core);
		mg.subGoals.add(wlg);
		mg.subGoals.add(wlmmg);
		
		if (mg.isHardwareCorrect())
		{
			this.addGoals(mg);
		}
		else
		{
			throw new RuntimeException("Hardeware is not correct for this goal!");
		}
		return mg.isHardwareCorrect();		
	}

}
