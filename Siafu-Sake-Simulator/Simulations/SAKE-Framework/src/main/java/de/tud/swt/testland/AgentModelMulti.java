package de.tud.swt.testland;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import de.nec.nle.siafu.behaviormodels.BaseAgentModelMulti;
import de.nec.nle.siafu.model.MultiAgent;
import de.nec.nle.siafu.model.MultiWorld;
import de.tud.swt.cleaningrobots.Configuration;
import de.tud.swt.cleaningrobots.AgentCore;
import de.tud.swt.cleaningrobots.factory.ExploreMergeMasterCalculateFactory;
import de.tud.swt.cleaningrobots.factory.ExploreMergeMasterCalculateRelativeFactory;
import de.tud.swt.cleaningrobots.factory.ExploreMergeMasterFactory;
import de.tud.swt.cleaningrobots.factory.ExploreWithoutMasterFactory;
import de.tud.swt.cleaningrobots.factory.MasterExploreFactory;
import de.tud.swt.cleaningrobots.measure.ExportFiles;
import de.tud.swt.evaluation.WorkingConfiguration;

/**
 * The AgentModelMulti class create all agents for the incoming configuration.
 * And do the wander steps always for one iteration for all agents.
 * 
 * @author Christopher Werner
 * 
 */
public class AgentModelMulti extends BaseAgentModelMulti {
	
	private long startTime;
	private Configuration config;
	
	/**
	 * Constructor for the agent model.
	 * 
	 * @param world
	 *            the simulation's world
	 */
	public AgentModelMulti(MultiWorld world, WorkingConfiguration configuration) {
		super(world, configuration);
		this.config = new Configuration(configuration);
	}

	/**
	 * Create a agents as configured that will wander around aimlessly.
	 * 
	 * @return the created agents
	 */
	@Override
	public ArrayList<MultiAgent> createAgents() {

		ArrayList<ISimulatorAgent> iAgents = new ArrayList<ISimulatorAgent>();
		ArrayList<MultiAgent> agents = new ArrayList<MultiAgent>();
		SiafuAgentFactoryMulti rfm = new SiafuAgentFactoryMulti(config, world);

		try {
			switch (configuration.config) {
				case 0:  iAgents = new MasterExploreFactory(config).createRobots(rfm);
						 break;
	            case 1:  iAgents = new ExploreWithoutMasterFactory(config).createRobots(rfm);
	                     break;	            
	            case 2:  iAgents = new ExploreMergeMasterFactory(config).createRobots(rfm);
	                     break;
	            case 3:  iAgents = new ExploreMergeMasterCalculateFactory(config).createRobots(rfm);
	                     break;
	            case 4:  iAgents = new ExploreMergeMasterCalculateRelativeFactory(config).createRobots(rfm);
	                     break;
	            default: iAgents = new MasterExploreFactory(config).createRobots(rfm);
	                     break;
	        }
		} catch (Exception ex) {
		}
		
		for (ISimulatorAgent a : iAgents)
		{
			agents.add((MultiAgent)a);
		}
		
		startTime = System.nanoTime();		
		return agents;
	}
	
	private boolean runAction (Collection<MultiAgent> agents) {
		boolean finish = true;
		//do that for each robot
		for (MultiAgent agent : agents) {
			ISimulatorAgent a = (ISimulatorAgent) agent;
			//only if robot is on
			if (!a.getAgentCore().isShutDown()) {
				a.wander();
				if (!a.isFinish())
					finish = false;
			}
		}
		return finish;
	}
	
	private boolean createDirectory(String path) {
		boolean result = false;
		File dir = new File(path);

		if (!dir.exists()) {
			try {
				result = dir.mkdirs();
			} catch (Exception e) {
				//logger.error(e);
			}
		} else {
			result = true;
		}
		return result;
	}
	
	/**
	 * Make all the agents wander around one step.
	 * If Simulations is finish save the measurement values in a JSON file.
	 * 
	 * @param agents
	 *            the list of agents
	 */
	@Override
	public void doIteration(Collection<MultiAgent> agents) {
		configuration.iteration = configuration.iteration + 1;
		
		if (runAction(agents))
		{
			//create Measurement output
			long endTime = System.nanoTime();
			
			for (MultiAgent a : agents) {
				((ISimulatorAgent)a).getAgentCore().addLastMeasurement();				
			}
			
			//make data output for all measurements
			for (MultiAgent a : agents) {
				AgentCore rc = ((ISimulatorAgent)a).getAgentCore();
				
				//save JSON document in .txt
				rc.getMeasurement().benchmarkTime = (endTime - startTime);
				String measu = rc.getMeasurement().toJson();
				
				ExportFiles ef = new ExportFiles();
				if (createDirectory("result"))
				{
					String path = "result" + File.separator + "R" + configuration.run + "_M" + configuration.map + "_S" + configuration.config + "_NE" 
							+ configuration.number_explore_agents + "_NV" + configuration.number_hoove_agents +	"_NW" + configuration.number_wipe_agents 
							+ "_F" + configuration.new_field_count + "_" + rc.getName()+ ".txt";
					ef.addLineToFile(measu, path);		
				}					
			}
			ExportFiles ef = new ExportFiles();
			if (createDirectory("result"))
			{				
				String path = "result" + File.separator + "R" + configuration.run + "_M" + configuration.map + "_S" +configuration.config + "_NE" 
						+ configuration.number_explore_agents + "_NV" + configuration.number_hoove_agents + "_NW" + configuration.number_wipe_agents 
						+ "_F" + configuration.new_field_count + "_" + "exchange.txt";
				ef.addConfigurationToFile(configuration, path);
			}			
			
			//Example console output
			System.out.println("Programm Finish!");
			System.out.println("Iterations: " + configuration.iteration);
			this.runFinish = true;
		}
	}

	/**
	 * Initialize all agents one time.
	 */
	@Override
	public void initializeAgents(Collection<MultiAgent> agents) {
		
		//example output for master follower relation
		for (MultiAgent agent: agents)
		{
			ISimulatorAgent a = (ISimulatorAgent)agent;
			a.getAgentCore().createAndInitializeRoleGoals();
			System.out.println("Name: " + a.getAgentCore().getName() + " Roles: " + a.getAgentCore().getRoles() + " States: " + a.getAgentCore().getSupportedStates());
		}
	}
}
