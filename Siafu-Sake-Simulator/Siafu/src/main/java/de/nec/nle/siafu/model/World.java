package de.nec.nle.siafu.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import de.nec.nle.siafu.behaviormodels.BaseAgentModel;
import de.nec.nle.siafu.behaviormodels.BaseContextModel;
import de.nec.nle.siafu.behaviormodels.BaseWorldModel;
import de.tud.swt.evaluation.WorkingConfiguration;

public class World {
	
	protected Collection<Agent> mAgents;
	
	protected ArrayList<Place> mPlaces;

	protected WorkingConfiguration configuration;
	
	/**
	 * The world's height.
	 */
	protected int height;

	/**
	 * The worlds width.
	 */
	protected int width;
	
	/**
	 * The name of the world being simulated.
	 */
	protected String worldName;
	
	/**
	 * The behavior model for the agents.
	 */
	protected BaseAgentModel agentModel;

	/**
	 * The behavior model for the places in the world.
	 */
	protected BaseWorldModel worldModel;

	/**
	 * The behavior model for the simulated context.
	 */
	protected BaseContextModel contextModel;
	
	/**
	 * The matrix of points that defines where an agent can walk or not.
	 */
	protected boolean[][] walls;
	
	/**
	 * The data that defines this simulation, including maps, sprites and
	 * behavioral classes.
	 */
	protected SimulationData simData;
	
	public World (SimulationData simData, WorkingConfiguration configuration) {
		this.mAgents = new LinkedList<Agent>();
		this.mPlaces = new ArrayList<Place>();
		this.worldName = simData.getWorldName();
		this.configuration = configuration;
		this.simData = simData;
		
		buildWalls();
		createPeople();
	}
	
	/*public AWorld ()
	{
	}*/
	
	/**
	 * Get the name of the world.
	 * 
	 * @return the world's name
	 */
	public String getWorldName() {
		return worldName;
	}

	/**
	 * Get the height of the world map in pixels.
	 * 
	 * @return the height of the world in pixels
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Get the width of the world map in pixels.
	 * 
	 * @return the width of the world map in pixels
	 */
	public int getWidth() {
		return width;
	}
	
	protected void buildWalls() {
		switch (configuration.map) {
			case 0:  walls = simData.getWallsR();
					 break;
	        case 1:  walls = simData.getWallsLab();
	                 break;	            
	        case 2:  walls = simData.getWallsFakK();
	                 break;
	        case 3:  walls = simData.getWallsFak();
	                 break;
	        default: walls = simData.getWallsR();
	                 break;
		}
	}
	
	/**
	 * Find out if the given position corresponds to a wall, or is actually
	 * walkable by agents.
	 * 
	 * @param pos
	 *            the position to check
	 * @return true if the position is on a wall, false otherwise
	 */
	public boolean isAWall(int row, int col) {
		return walls[row][col];
	}
	
	protected void createPeople() {
		try {
			agentModel = (BaseAgentModel) simData.getAgentModelClass()
					.getConstructor(new Class[] { World.class, configuration.getClass() })
					.newInstance(new Object[] { (World)this , configuration }); //this.getClass()
		} catch (Exception e) {
			throw new RuntimeException("Can't instantiate the agent model", e);
		}
		mAgents = agentModel.createAgents();
	}
	
	public int getColFromStart()
	{
		switch (configuration.map) {
			case 0:  return 139;
			case 1:  return 139;	            
			case 2:  return 199;
			case 3:  return 199;
			default: return 0;
		}
	}
	
	public int getRowFromStart()
	{
		switch (configuration.map) {
			case 0:  return 133;
	        case 1:  return 133;	            
	        case 2:  return 206;
	        case 3:  return 206;
	        default: return 0;
		}
	}
	
	/*public Agent createPeople(String name, String image, World world, IExternalConnection extern) {
		switch (configuration.map) {
			case 0:  return new Agent(name, 139, 133, extern);
	        case 1:  return new Agent(name, 139, 133, extern);	            
	        case 2:  return new Agent(name, 199, 206, extern);
	        case 3:  return new Agent(name, 199, 206, extern);
	        default: return null;
		}
	}*/
	
	public Collection<Agent> getAgents()
	{
		return mAgents;
	}
	
	public Collection<Place> getPlaces()
	{
		return mPlaces;
	}
	
	/**
	 * Get the Agent Model being used in the simulation.
	 * 
	 * @return the AgentModel
	 */
	public BaseAgentModel getAgentModel() {
		return agentModel;
	}

	/**
	 * Get the CotnextModel being used in the simulation.
	 * 
	 * @return the ContextModel
	 */
	public BaseContextModel getContextModel() {
		return contextModel;
	}

	/**
	 * Get the World Model being used in the simulation.
	 * 
	 * @return the WorldModel
	 */
	public BaseWorldModel getWorldModel() {
		return worldModel;
	}
}
