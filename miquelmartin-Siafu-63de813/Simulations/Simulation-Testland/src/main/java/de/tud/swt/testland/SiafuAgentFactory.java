package de.tud.swt.testland;

import de.nec.nle.siafu.exceptions.PlaceNotFoundException;
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
public class SiafuAgentFactory implements ISimulatorAgentFactory {
	
	private int counter;
	private Configuration configuration;
	private World world;
	
	public SiafuAgentFactory (Configuration configuration, World world) {
		this.world = world;
		this.configuration = configuration;
		this.counter = 0;
	}
	
	/**
	 * Create only a load station without any computer.
	 * 
	 * @param world
	 *            the world to create it in
	 * @return the new agent
	 */
	@Override
	public ISimulatorAgent createLoadStation() {
		try {
			counter++;
			SiafuAgent agent = new SiafuAgent("Robbi_" + counter, world
					.getRandomPlaceOfType("Center").getPos(), "Master",
					world, configuration);

			//add hardware components
			agent.getAgentCore().addHardwareComponent(new LoadStation());
			
			return agent;
		} catch (PlaceNotFoundException e) {
			throw new RuntimeException(
					"You didn't define the right type of places", e);
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
	public ISimulatorAgent createLoadStationAgent() {
		try {
			counter++;
			SiafuAgent agent = new SiafuAgent("Robbi_" + counter, world
					.getRandomPlaceOfType("Center").getPos(), "Master",
					world, configuration);
			
			//add hardware components
			agent.getAgentCore().addHardwareComponent(new Computer());
			agent.getAgentCore().addHardwareComponent(new LoadStation());
			agent.getAgentCore().addHardwareComponent(new Wlan());
			
			return agent;
		} catch (PlaceNotFoundException e) {
			throw new RuntimeException(
					"You didn't define the right type of places", e);
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
	public ISimulatorAgent createExploreAgent() {
		try {
			counter++;
			SiafuAgent agent = new SiafuAgent("Robbi_" + counter, world
					.getRandomPlaceOfType("Center").getPos(), "HumanMagenta",
					world, configuration);

			//add hardware components
			agent.getAgentCore().addHardwareComponent(new Computer());
			agent.getAgentCore().addHardwareComponent(new Wlan());
			agent.getAgentCore().addHardwareComponent(new Engine());
			agent.getAgentCore().addHardwareComponent(new LookAroundSensor());	
			
			return agent;
		} catch (PlaceNotFoundException e) {
			throw new RuntimeException(
					"You didn't define the right type of places", e);
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
	public ISimulatorAgent createWipeAgent() {
		try {
			counter++;
			SiafuAgent agent = new SiafuAgent("Robbi_" + counter, world
					.getRandomPlaceOfType("Center").getPos(), "HumanYellow",
					world, configuration);
			
			//add hardware components
			agent.getAgentCore().addHardwareComponent(new Computer());
			agent.getAgentCore().addHardwareComponent(new Wlan());
			agent.getAgentCore().addHardwareComponent(new Engine());
			agent.getAgentCore().addHardwareComponent(new Wiper());
			
			return agent;
		} catch (PlaceNotFoundException e) {
			throw new RuntimeException(
					"You didn't define the right type of places", e);
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
	public ISimulatorAgent createHooveAgent() {
		try {
			counter++;
			SiafuAgent agent = new SiafuAgent("Robbi_" + counter, world
					.getRandomPlaceOfType("Center").getPos(), "HumanGreen",
					world, configuration);

			//add hardware components
			agent.getAgentCore().addHardwareComponent(new Computer());
			agent.getAgentCore().addHardwareComponent(new Wlan());
			agent.getAgentCore().addHardwareComponent(new Engine());
			agent.getAgentCore().addHardwareComponent(new Hoover());
			
			return agent;
		} catch (PlaceNotFoundException e) {
			throw new RuntimeException(
					"You didn't define the right type of places", e);
		}
	}

}
