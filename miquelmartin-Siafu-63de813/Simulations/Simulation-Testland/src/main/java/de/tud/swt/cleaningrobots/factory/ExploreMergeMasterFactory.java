package de.tud.swt.cleaningrobots.factory;

import java.util.ArrayList;

import de.tud.swt.cleaningrobots.Configuration;
import de.tud.swt.cleaningrobots.AgentRole;
import de.tud.swt.cleaningrobots.roles.ExplorerRandomFollowerRole;
import de.tud.swt.cleaningrobots.roles.FollowerRole;
import de.tud.swt.cleaningrobots.roles.HooverRandomFollowerRole;
import de.tud.swt.cleaningrobots.roles.LoadstationRole;
import de.tud.swt.cleaningrobots.roles.LoggingCsvRole;
import de.tud.swt.cleaningrobots.roles.LoggingPictureRole;
import de.tud.swt.cleaningrobots.roles.LoggingXmlRole;
import de.tud.swt.cleaningrobots.roles.MasterRole;
import de.tud.swt.cleaningrobots.roles.MergeMasterRole;
import de.tud.swt.cleaningrobots.roles.WiperRandomFollowerRole;
import de.tud.swt.testland.ISimulatorAgentFactory;
import de.tud.swt.testland.ISimulatorAgent;

/**
 * Create the agents with the specific roles for the test case where the master has followers 
 * and merge data between them.
 * 
 * @author Christopher Werner
 *
 */
public class ExploreMergeMasterFactory extends IAgentFactory {
	
	public ExploreMergeMasterFactory (Configuration configuration)
	{
		super(configuration);
	}
	
	/**
	 * Create the number of agents from the working configuration.
	 * 
	 * @param world
	 *            the world where the agents will work
	 * @return an ArrayList with the created agents
	 */
	@Override
	public ArrayList<ISimulatorAgent> createRobots(ISimulatorAgentFactory factory) {
		
		ArrayList<ISimulatorAgent> population = new ArrayList<ISimulatorAgent>();	
		
		//loadstation agent
		ISimulatorAgent lsa = factory.createLoadStationAgent();
		population.add(lsa);
		
		if (configuration.getWc().number_explore_agents > 0) {
			MasterRole mre = new MergeMasterRole(lsa.getAgentCore());
			mre.addRole(mre);		
			
			//explore agents
			for (int i = 0; i < configuration.getWc().number_explore_agents; i++) {
				ISimulatorAgent era = factory.createExploreAgent();
				population.add(era);		
				
				FollowerRole fre = new ExplorerRandomFollowerRole(era.getAgentCore(), mre);
				fre.addRole(fre);
				mre.getFollowers().add(fre);
			}
		
			if (configuration.getWc().number_hoove_agents > 0) {
				MasterRole mrh = new MergeMasterRole(lsa.getAgentCore());
				mrh.addRole(mrh);

				//hoove agents
				for (int i = 0; i < configuration.getWc().number_hoove_agents; i++) {
					ISimulatorAgent hra = factory.createHooveAgent();
					population.add(hra);
					
					FollowerRole frh = new HooverRandomFollowerRole(hra.getAgentCore(), mrh);
					frh.addRole(frh);
					mrh.getFollowers().add(frh);
				}
				mrh.getFollowers().add(mre);
							
				if (configuration.getWc().number_wipe_agents > 0) {
					MasterRole mrw = new MergeMasterRole(lsa.getAgentCore());
					mrw.addRole(mrw);
					
					//wipe agents
					for (int i = 0; i < configuration.getWc().number_wipe_agents; i++) {
						ISimulatorAgent wra = factory.createWipeAgent();
						population.add(wra);
						
						FollowerRole frw = new WiperRandomFollowerRole(wra.getAgentCore(), mrw);
						frw.addRole(frw);
						mrw.getFollowers().add(frw);
					}
					mrw.getFollowers().add(mrh);
				}				
			}			
			AgentRole rr = new LoadstationRole(lsa.getAgentCore());
			rr.addRole(rr);
		}
		
		//add the logging roles to every agent
		if (configuration.getWc().csvSave)
		{
			for (ISimulatorAgent a: population)
			{
				LoggingCsvRole csvRole = new LoggingCsvRole(a.getAgentCore());
				csvRole.addRole(csvRole);
			}
		}
		if (configuration.getWc().pngSave)
		{
			for (ISimulatorAgent a: population)
			{
				LoggingPictureRole pngRole = new LoggingPictureRole(a.getAgentCore());
				pngRole.addRole(pngRole);
			}
		}
		if (configuration.getWc().xmlSave)
		{
			for (ISimulatorAgent a: population)
			{
				LoggingXmlRole xmlRole = new LoggingXmlRole(a.getAgentCore());
				xmlRole.addRole(xmlRole);
			}
		}
		
		//example output for correct robots
		/*for (ISimulatorAgent a: population)
		{
			a.getRobot().createAndInitializeRoleGoals();
			System.out.println("Name: " + a.getRobot().getName() + " Roles: " + a.getRobot().getRoles() + " States: " + a.getRobot().getSupportedStates());
		}*/
		return population;
	}
}
