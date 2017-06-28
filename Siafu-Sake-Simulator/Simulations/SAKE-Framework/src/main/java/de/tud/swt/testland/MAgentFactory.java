package de.tud.swt.testland;

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
public class MAgentFactory extends AgentFactory {
		
	public MAgentFactory (Configuration configuration, World world) {
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
		MAgent agent = new MAgent("Robbi_" + counter, "Master",	world, configuration);

		//add hardware components
		agent.getAgentCore().addHardwareComponent(new LoadStation());
			
		return agent;
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
		MAgent agent = new MAgent("Robbi_" + counter, "Master",	world, configuration);
			
		//add hardware components
		agent.getAgentCore().addHardwareComponent(new Computer());
		agent.getAgentCore().addHardwareComponent(new LoadStation());
		agent.getAgentCore().addHardwareComponent(new Wlan());
			
		return agent;
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
		MAgent agent = new MAgent("Robbi_" + counter, "HumanMagenta", world, configuration);

		//add hardware components
		agent.getAgentCore().addHardwareComponent(new Computer());
		agent.getAgentCore().addHardwareComponent(new Wlan());
		agent.getAgentCore().addHardwareComponent(new Engine());
		agent.getAgentCore().addHardwareComponent(new LookAroundSensor());	
			
		return agent;
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
		MAgent agent = new MAgent("Robbi_" + counter, "HumanYellow", world, configuration);
			
		//add hardware components
		agent.getAgentCore().addHardwareComponent(new Computer());
		agent.getAgentCore().addHardwareComponent(new Wlan());
		agent.getAgentCore().addHardwareComponent(new Engine());
		agent.getAgentCore().addHardwareComponent(new Wiper());
			
		return agent;
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
		MAgent agent = new MAgent("Robbi_" + counter, "HumanGreen",	world, configuration);

		//add hardware components
		agent.getAgentCore().addHardwareComponent(new Computer());
		agent.getAgentCore().addHardwareComponent(new Wlan());
		agent.getAgentCore().addHardwareComponent(new Engine());
		agent.getAgentCore().addHardwareComponent(new Hoover());
			
		return agent;
	}

}
