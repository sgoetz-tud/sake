package de.tud.swt.cleaningrobots;

import java.util.List;

import de.tud.swt.cleaningrobots.model.Position;

/**
 * Creates the interface between the simulator and the agent core.
 * 
 * @author Christopher Werner
 *
 */
public interface ISimulatorAdapter {

	/**
	 * Set the position of the robot in the simulation.
	 * @param position
	 */
	public void setPosition(Position position);
	
	/**
	 * Proof if the position is arrival or not.
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isWall(int row, int col);
	
	/**
	 * Get the position of the agent from the simulation.
	 * @return
	 */
	public Position getPosition();
	
	/**
	 * Get all agent cores, which are in a specific area.
	 * @param visionRadius
	 * @return
	 */
	public List<AgentCore> getNearRobots(int visionRadius);
	
	/**
	 * Get all agent cores from the test case.
	 * @return
	 */
	public List<AgentCore> getAllRobots();
}
