/*
 * Copyright NEC Europe Ltd. 2006-2007
 * 
 * This file is part of the context simulator called Siafu.
 * 
 * Siafu is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * Siafu is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Classes for the connection between Siafu and SAKE.
 * Must be configured and name in the simulation package.
 */
package de.tud.swt.testland;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import de.nec.nle.siafu.behaviormodels.BaseAgentModel;
import de.nec.nle.siafu.model.Agent;
import de.nec.nle.siafu.model.World;
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
 * The AgentModel class create all agents for the incoming configuration.
 * And do the wander steps always for one iteration for all agents.
 * Use the normal World from Siafu which uses the GUI.
 * 
 * @author Christopher Werner
 * 
 */
public class AgentModel extends BaseAgentModel {
	
	private long startTime;
	private Configuration config;
	
	/**
	 * Constructor for the agent model.
	 * 
	 * @param world
	 *            the simulation's world
	 */
	public AgentModel(World world, WorkingConfiguration configuration) {
		super(world, configuration);
		this.config = new Configuration(configuration);
	}

	/**
	 * Create a agents as configured that will wander around aimlessly.
	 * 
	 * @return the created agents
	 */
	@Override
	public ArrayList<Agent> createAgents() {
		
		ArrayList<ISimulatorAgent> iAgents = new ArrayList<ISimulatorAgent>();
		ArrayList<Agent> agents = new ArrayList<Agent>();
		SiafuAgentFactory rf = new SiafuAgentFactory(config, world);

		try {
			switch (configuration.config) {
				case 0:  iAgents = new MasterExploreFactory(config).createRobots(rf);
						 break;
	            case 1:  iAgents = new ExploreWithoutMasterFactory(config).createRobots(rf);
	                     break;	            
	            case 2:  iAgents = new ExploreMergeMasterFactory(config).createRobots(rf);
	                     break;
	            case 3:  iAgents = new ExploreMergeMasterCalculateFactory(config).createRobots(rf);
	                     break;
	            case 4:  iAgents = new ExploreMergeMasterCalculateRelativeFactory(config).createRobots(rf);
	                     break;
	            default: iAgents = new MasterExploreFactory(config).createRobots(rf);
	                     break;
	        }
		} catch (Exception ex) {
		}
		
		for (ISimulatorAgent a : iAgents)
		{
			agents.add((Agent)a);
		}
		
		startTime = System.nanoTime();
		return agents;
	}
	
	private boolean runAction (Collection<Agent> agents) {
		boolean finish = true;
		//do that for each robot
		for (Agent agent : agents) {
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
	public void doIteration(Collection<Agent> agents) {
		configuration.iteration = configuration.iteration + 1;
				
		if (runAction(agents))
		{
			long endTime = System.nanoTime();
			
			//do evaluation output
			for (Agent a : agents) {
				((ISimulatorAgent)a).getAgentCore().addLastMeasurement();				
			}
			
			//make data output for all measurements
			for (Agent a : agents) {
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
	public void initializeAgents(Collection<Agent> agents) {
		
		//example output for master follower relation
		for (Agent agent: agents)
		{
			ISimulatorAgent a = (ISimulatorAgent)agent;
			a.getAgentCore().createAndInitializeRoleGoals();
			System.out.println("Name: " + a.getAgentCore().getName() + " Roles: " + a.getAgentCore().getRoles() + " States: " + a.getAgentCore().getSupportedStates());
		}
	}
}
