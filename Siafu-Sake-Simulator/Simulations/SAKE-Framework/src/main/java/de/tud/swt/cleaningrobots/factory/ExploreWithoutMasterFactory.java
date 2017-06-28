package de.tud.swt.cleaningrobots.factory;

import java.util.ArrayList;

import de.nec.nle.siafu.model.Agent;
import de.tud.swt.cleaningrobots.Configuration;
import de.tud.swt.cleaningrobots.AgentRole;
import de.tud.swt.cleaningrobots.roles.CommunicationInterfaceRole;
import de.tud.swt.cleaningrobots.roles.ExplorerRole;
import de.tud.swt.cleaningrobots.roles.FirstExplorerRole;
import de.tud.swt.cleaningrobots.roles.HooverRole;
import de.tud.swt.cleaningrobots.roles.LoadstationRole;
import de.tud.swt.cleaningrobots.roles.LoggingCsvRole;
import de.tud.swt.cleaningrobots.roles.LoggingPictureRole;
import de.tud.swt.cleaningrobots.roles.LoggingXmlRole;
import de.tud.swt.cleaningrobots.roles.WiperRole;
import de.tud.swt.testland.AgentFactory;
import de.tud.swt.testland.ICoreAdapter;

/**
 * Create the agents with the specific roles for the test case without a master robot 
 * and merge data between them.
 * 
 * @author Christopher Werner
 *
 */
public class ExploreWithoutMasterFactory extends ISimulationFactory {
		
	public ExploreWithoutMasterFactory (Configuration configuration)
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
		Agent lsa = factory.createLoadStation();
		population.add(lsa);
		
		//load if robot want role
		AgentRole rr = new LoadstationRole(((ICoreAdapter)lsa).getAgentCore());
		rr.addRole(rr);
		
		boolean proof;
		
		if (configuration.getWc().number_explore_agents > 0) {
			
			proof = false;
			if (configuration.getWc().number_hoove_agents > 0) {
				proof = true;
			}
			
			//explore agents
			for (int i = 0; i < configuration.getWc().number_explore_agents; i++) {
				Agent era = factory.createExploreAgent();
				population.add(era);
				
				AgentRole exr;
				
				if (i == 0 && configuration.getWc().number_hoove_agents > 0)
				{
					exr = new FirstExplorerRole(((ICoreAdapter)era).getAgentCore());
					exr.addRole(exr);
				}
				else
				{
					exr = new ExplorerRole(((ICoreAdapter)era).getAgentCore());
					exr.addRole(exr);
				}
				
				if (proof) {
					AgentRole exw = new CommunicationInterfaceRole(((ICoreAdapter)era).getAgentCore());
					exw.addRole(exw);
					proof = false;
				}
			}
			
			if (configuration.getWc().number_hoove_agents > 0) {
				
				proof = false;
				if (configuration.getWc().number_wipe_agents > 0) {
					proof = true;
				}
				
				//hoove agents
				for (int i = 0; i < configuration.getWc().number_hoove_agents; i++) {
					Agent hra = factory.createHooveAgent();
					population.add(hra);
					
					AgentRole hor = new HooverRole(((ICoreAdapter)hra).getAgentCore());
					hor.addRole(hor);
					
					if (proof) {
						AgentRole how = new CommunicationInterfaceRole(((ICoreAdapter)hra).getAgentCore());
						how.addRole(how);
						proof = false;
					}
				}
				
				if (configuration.getWc().number_wipe_agents > 0) {
					
					//wipe agents
					for (int i = 0; i < configuration.getWc().number_wipe_agents; i++) {
						Agent wra = factory.createWipeAgent();
						population.add(wra);
						
						AgentRole wir = new WiperRole(((ICoreAdapter)wra).getAgentCore());
						wir.addRole(wir);
					}
				}
			}			
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
		
		//example output for master follower relation
		/*for (ISimulatorAgent a: population)
		{
			a.getRobot().createAndInitializeRoleGoals();
			System.out.println("Name: " + a.getRobot().getName() + " Roles: " + a.getRobot().getRoles() + " States: " + a.getRobot().getSupportedStates());
		}*/
		
		return population;
	}
}
