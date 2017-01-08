package de.tud.swt.testland;

import de.nec.nle.siafu.model.MultiWorld;
import de.tud.swt.cleaningrobots.Configuration;
import de.tud.swt.cleaningrobots.hardware.Hoover;
import de.tud.swt.cleaningrobots.hardware.LoadStation;
import de.tud.swt.cleaningrobots.hardware.LookAroundSensor;
import de.tud.swt.cleaningrobots.hardware.Engine;
import de.tud.swt.cleaningrobots.hardware.Computer;
import de.tud.swt.cleaningrobots.hardware.Wiper;
import de.tud.swt.cleaningrobots.hardware.Wlan;
import de.tud.swt.cleaningrobots.model.Position;

/**
 * Without user interface report in Siafu.
 * Create the different agent types for the simulation.
 * 
 * @author Christopher Werner
 *
 */
public class SiafuAgentFactoryMulti implements ISimulatorAgentFactory {
	
	private int counter;
	protected Configuration configuration;
	private Position position;
	private MultiWorld world;
	
	public SiafuAgentFactoryMulti (Configuration configuration, MultiWorld world) {
		this.configuration = configuration;
		this.world = world;
		//X: 139 Y: 133 hall / labyrinth
		//X: 199 Y: 206 faculty
		switch (configuration.getWc().map) {
			case 0:  this.position = new Position(139, 133);
					 break;
	        case 1:  this.position = new Position(139, 133);
	                 break;	            
	        case 2:  this.position = new Position(199, 206);
	                 break;
	        case 3:  this.position = new Position(199, 206);
	                 break;
	        default: this.position = new Position(139, 133);
	                 break;
		}
		counter = 0;
	}
	
	/**
	 * Create a load station agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public ISimulatorAgent createLoadStationAgent() {
		counter++;
		SiafuAgentMulti agent = new SiafuAgentMulti("Robbi_" + counter, position, world, configuration);
		
		//add hardware components
		agent.getAgentCore().addHardwareComponent(new Computer());
		agent.getAgentCore().addHardwareComponent(new LoadStation());
		agent.getAgentCore().addHardwareComponent(new Wlan());
		
		return agent;
	}
	
	/**
	 * Create a load station without computer.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public ISimulatorAgent createLoadStation() {
		counter++;
		SiafuAgentMulti agent = new SiafuAgentMulti("Robbi_" + counter, position, world, configuration);
		
		//add hardware components
		agent.getAgentCore().addHardwareComponent(new LoadStation());
		
		return agent;
	}
	
	/**
	 * Create a explore agent.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	public ISimulatorAgent createExploreAgent() {
		counter++;
		SiafuAgentMulti agent = new SiafuAgentMulti("Robbi_" + counter, position, world, configuration);
		
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
	public ISimulatorAgent createWipeAgent() {
		counter++;
		SiafuAgentMulti agent = new SiafuAgentMulti("Robbi_" + counter, position, world, configuration);
		
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
	public ISimulatorAgent createHooveAgent() {
		counter++;
		SiafuAgentMulti agent = new SiafuAgentMulti("Robbi_" + counter, position, world, configuration);
		
		//add hardware components
		agent.getAgentCore().addHardwareComponent(new Computer());
		agent.getAgentCore().addHardwareComponent(new Wlan());
		agent.getAgentCore().addHardwareComponent(new Engine());
		agent.getAgentCore().addHardwareComponent(new Hoover());
		
		return agent;
	}

}
