package de.tud.swt.cleaningrobots.goals.optional;

import de.tud.swt.cleaningrobots.AgentRole;
import de.tud.swt.cleaningrobots.behaviours.DiscoverBehaviour;
import de.tud.swt.cleaningrobots.behaviours.LoadIfAtLoadStationBehaviour;
import de.tud.swt.cleaningrobots.behaviours.MoveBehaviour;
import de.tud.swt.cleaningrobots.behaviours.DiscoverAroundAtDestinationBehaviour;
import de.tud.swt.cleaningrobots.behaviours.merge.MergeAllAlwaysNearBehaviour;
import de.tud.swt.cleaningrobots.goals.OptionalGoal;

/**
 * Non optional goal to discover the world without any control of a master. 
 * 
 * @author Christopher Werner
 *
 */
public class WithoutMasterExploreOptionalGoal extends OptionalGoal {

	private DiscoverBehaviour d;
	private DiscoverAroundAtDestinationBehaviour s;
	private MoveBehaviour m;
	private MergeAllAlwaysNearBehaviour merge;
	private LoadIfAtLoadStationBehaviour load;
	private boolean allGoalsWork;
	
	public WithoutMasterExploreOptionalGoal(AgentRole role) {
		super(role);
		
		this.allGoalsWork = true;
		
		this.s = new DiscoverAroundAtDestinationBehaviour(role);
		System.out.println("Correct SeeAround: " + s.isHardwarecorrect());
		if (s.isHardwarecorrect()) {
			behaviours.add(s);
		} else {
			correct = false;
		}
		
		this.d = new DiscoverBehaviour(role, false);
		System.out.println("Correct Discover: " + d.isHardwarecorrect());
		if (d.isHardwarecorrect()) {
			behaviours.add(d);
		} else {
			correct = false;
		}
		
		this.m = new MoveBehaviour(role);
		System.out.println("Correct Move: " + m.isHardwarecorrect());
		if (m.isHardwarecorrect()) {
			behaviours.add(m);
		} else {
			correct = false;
		}
		
		this.merge = new MergeAllAlwaysNearBehaviour(role, false);
		System.out.println("Correct Near Merge: " + merge.isHardwarecorrect());
		if (merge.isHardwarecorrect()) {
			behaviours.add(merge);
		} else {
			correct = false;
		}
		
		this.load = new LoadIfAtLoadStationBehaviour(role);
		System.out.println("Correct LoadIfAtLoadStation: " + load.isHardwarecorrect());
		if (load.isHardwarecorrect()) {
			behaviours.add(load);
		} else {
			correct = false;
		}
	}

	@Override
	public boolean preCondition() {		
		if (this.getAgentCore().getWorld().getNextUnknownFieldPosition() != null)
			return true;
		return false;
	}

	@Override
	public boolean postCondition() {
		//must look if the discover behavior is finish
		if (this.allGoalsWork && this.d.isFinishDiscovering())
		{
			behaviours.remove(m);
			behaviours.remove(s);
			behaviours.remove(d);
		}
		//always return false because it should not be finished
		return false;
	}
}
