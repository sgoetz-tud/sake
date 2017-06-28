package de.tud.swt.cleaningrobots.factory;

import java.util.ArrayList;

import de.nec.nle.siafu.model.Agent;
import de.tud.swt.cleaningrobots.Configuration;
import de.tud.swt.cleaningrobots.AgentRole;
import de.tud.swt.cleaningrobots.roles.ExplorerControlMasterRole;
import de.tud.swt.cleaningrobots.roles.ExplorerControlledFollowerRole;
import de.tud.swt.cleaningrobots.roles.FollowerRole;
import de.tud.swt.cleaningrobots.roles.HooverControlMasterRole;
import de.tud.swt.cleaningrobots.roles.HooverControlledFollowerRole;
import de.tud.swt.cleaningrobots.roles.LoadstationRole;
import de.tud.swt.cleaningrobots.roles.LoggingCsvRole;
import de.tud.swt.cleaningrobots.roles.LoggingPictureRole;
import de.tud.swt.cleaningrobots.roles.LoggingXmlRole;
import de.tud.swt.cleaningrobots.roles.MasterRole;
import de.tud.swt.cleaningrobots.roles.WiperControlMasterRole;
import de.tud.swt.cleaningrobots.roles.WiperControlledFollowerRole;
import de.tud.swt.testland.AgentFactory;
import de.tud.swt.testland.ICoreAdapter;

/**
 * Create the agents with the specific roles for the test case with a master robot and many follower robots. 
 * Where the master merge data and calculate all destination and make all moves.
 * 
 * @author Christopher Werner
 *
 */
public class MasterExploreFactory extends ISimulationFactory {
	
	public MasterExploreFactory (Configuration configuration)
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
	public ArrayList<Agent> createRobots(AgentFactory factory) {
		
		ArrayList<Agent> population = new ArrayList<Agent>();	
		
		//loadstation agent
		Agent lsa = factory.createLoadStationAgent();
		population.add(lsa);
		
		if (configuration.getWc().number_explore_agents > 0) {
			MasterRole mre = new ExplorerControlMasterRole(((ICoreAdapter)lsa).getAgentCore());
			mre.addRole(mre);			
			
			//explore agents
			for (int i = 0; i < configuration.getWc().number_explore_agents; i++) {
				Agent era = factory.createExploreAgent();
				population.add(era);		
				
				FollowerRole fre = new ExplorerControlledFollowerRole(((ICoreAdapter)era).getAgentCore(), mre);
				fre.addRole(fre);
				mre.getFollowers().add(fre);
			}
			
			if (configuration.getWc().number_hoove_agents > 0) {
				MasterRole mrh = new HooverControlMasterRole(((ICoreAdapter)lsa).getAgentCore());
				mrh.addRole(mrh);
				
				//hoove agents
				for (int i = 0; i < configuration.getWc().number_hoove_agents; i++) {
					Agent hra = factory.createHooveAgent();
					population.add(hra);
					
					FollowerRole frh = new HooverControlledFollowerRole(((ICoreAdapter)hra).getAgentCore(), mrh);
					frh.addRole(frh);
					mrh.getFollowers().add(frh);
				}
								
				if (configuration.getWc().number_wipe_agents > 0) {
					MasterRole mrw = new WiperControlMasterRole(((ICoreAdapter)lsa).getAgentCore());
					mrw.addRole(mrw);
					
					//wipe agents
					for (int i = 0; i < configuration.getWc().number_wipe_agents; i++) {
						Agent wra = factory.createWipeAgent();
						population.add(wra);
						
						FollowerRole frw = new WiperControlledFollowerRole(((ICoreAdapter)wra).getAgentCore(), mrw);
						frw.addRole(frw);
						mrw.getFollowers().add(frw);
					}
				}
				
			}			
			AgentRole rr = new LoadstationRole(((ICoreAdapter)lsa).getAgentCore());
			rr.addRole(rr);
		}	
		
		//add the logging roles to every agent
		if (configuration.getWc().csvSave)
		{
			for (Agent a: population)
			{
				LoggingCsvRole csvRole = new LoggingCsvRole(((ICoreAdapter)a).getAgentCore());
				csvRole.addRole(csvRole);
			}
		}
		if (configuration.getWc().pngSave)
		{
			for (Agent a: population)
			{
				LoggingPictureRole pngRole = new LoggingPictureRole(((ICoreAdapter)a).getAgentCore());
				pngRole.addRole(pngRole);
			}
		}
		if (configuration.getWc().xmlSave)
		{
			for (Agent a: population)
			{
				LoggingXmlRole xmlRole = new LoggingXmlRole(((ICoreAdapter)a).getAgentCore());
				xmlRole.addRole(xmlRole);
			}
		}
		return population;
	}
}
