package de.tud.swt.testland;

import de.nec.nle.siafu.exceptions.PlaceNotFoundException;
import de.nec.nle.siafu.model.Agent;
import de.nec.nle.siafu.model.World;
import de.tud.swt.cleaningrobots.Configuration;
import de.tud.swt.cleaningrobots.hardware.Hoover;
import de.tud.swt.cleaningrobots.hardware.LoadStation;
import de.tud.swt.cleaningrobots.hardware.LookAroundSensor;
import de.tud.swt.cleaningrobots.hardware.Engine;
import de.tud.swt.cleaningrobots.hardware.Computer;
import de.tud.swt.cleaningrobots.hardware.Wiper;
import de.tud.swt.cleaningrobots.hardware.Wlan;

/**
 * With user interface report in Siafu.
 * Create the different agent types for the simulation.
 * 
 * @author Christopher Werner
 *
 */
public class SAgentFactory extends AgentFactory {
		
	public SAgentFactory (Configuration configuration, World world) {
		super(configuration, world);
	}
	
	/**
	 * Create only a load station without any computer.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	@Override
	public Agent createLoadStation() {		
		counter++;
		try {
			SAgent agent = new SAgent("Robbi_" + counter, "Master",	world, configuration);

			//add hardware components
			agent.getAgentCore().addHardwareComponent(new LoadStation());
			
			return agent;
		} catch (PlaceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Create a load station agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	@Override
	public Agent createLoadStationAgent() {
		counter++;
		try {
			SAgent agent = new SAgent("Robbi_" + counter, "Master",	world, configuration);
			
			//add hardware components
			agent.getAgentCore().addHardwareComponent(new Computer());
			agent.getAgentCore().addHardwareComponent(new LoadStation());
			agent.getAgentCore().addHardwareComponent(new Wlan());
				
			return agent;
		} catch (PlaceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	/**
	 * Create a explore agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	@Override
	public Agent createExploreAgent() {
		counter++;
		try {
			SAgent agent = new SAgent("Robbi_" + counter, "HumanMagenta", world, configuration);

			//add hardware components
			agent.getAgentCore().addHardwareComponent(new Computer());
			agent.getAgentCore().addHardwareComponent(new Wlan());
			agent.getAgentCore().addHardwareComponent(new Engine());
			agent.getAgentCore().addHardwareComponent(new LookAroundSensor());	
				
			return agent;
		} catch (PlaceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Create a wipe agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	@Override
	public Agent createWipeAgent() {
		counter++;
		try {
			SAgent agent = new SAgent("Robbi_" + counter, "HumanYellow", world, configuration);
			
			//add hardware components
			agent.getAgentCore().addHardwareComponent(new Computer());
			agent.getAgentCore().addHardwareComponent(new Wlan());
			agent.getAgentCore().addHardwareComponent(new Engine());
			agent.getAgentCore().addHardwareComponent(new Wiper());
				
			return agent;
		} catch (PlaceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	/**
	 * Create a hoove agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	@Override
	public Agent createHooveAgent() {
		counter++;
		SAgent agent;
		try {
			agent = new SAgent("Robbi_" + counter, "HumanGreen",	world, configuration);
			
			//add hardware components
			agent.getAgentCore().addHardwareComponent(new Computer());
			agent.getAgentCore().addHardwareComponent(new Wlan());
			agent.getAgentCore().addHardwareComponent(new Engine());
			agent.getAgentCore().addHardwareComponent(new Hoover());
				
			return agent;
		} catch (PlaceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}

}
