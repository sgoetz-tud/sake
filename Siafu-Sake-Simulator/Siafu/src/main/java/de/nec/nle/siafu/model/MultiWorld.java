package de.nec.nle.siafu.model;

import de.nec.nle.siafu.behaviormodels.BaseAgentModel;
import de.tud.swt.evaluation.WorkingConfiguration;

/**
 * World without GUI contract for fast Simulation run.
 * 
 * @author Christopher Werner
 *
 */
public class MultiWorld extends AWorld {
	
	private SimulationData simData;
	
	private boolean[][] walls;
		
	private WorkingConfiguration configuration;
	
	private BaseAgentModel model;
	
	/**
	 * Instantiate the world in which the simulation will run.
	 * 
	 * @param simulation
	 *            the simulation object which is running this world.
	 * @param simData
	 *            the simulation data (maps, sprites, classes) for this
	 *            simulation.
	 */
	public MultiWorld(SimulationData simData, WorkingConfiguration configuration) {
		this.configuration = configuration;
		this.simData = simData;
		
		//simData.getConfigFile();
		
		buildWalls();
		createPeople();
	}
	
	/**
	 * Create the people to simulate by asking the AgentModel to do so.
	 * 
	 */
	private void createPeople() {
		try {
			model = (BaseAgentModel) simData.getAgentModelClass()
					.getConstructor(new Class[] { AWorld.class, configuration.getClass() })
					.newInstance(new Object[] { (AWorld)this , configuration }); //this.getClass()
		} catch (Exception e) {
			throw new RuntimeException("Can't instantiate the agent model", e);
		}
		agents = model.createAgents();
	}
	
	public BaseAgentModel getAgentModel() {
		return model;
	}
	
	/**
	 * Generate a matrix with the world's walls, out of the image file provided
	 * in the simulation data.
	 * 
	 */
	private void buildWalls() {
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

	public AAgent createPeople(String name, String image, AWorld world, IExternalConnection extern) {
		switch (configuration.map) {
			case 0:  return new MultiAgent(name, 139, 133, extern);
	        case 1:  return new MultiAgent(name, 139, 133, extern);	            
	        case 2:  return new MultiAgent(name, 199, 206, extern);
	        case 3:  return new MultiAgent(name, 199, 206, extern);
	        default: return null;
		}
	}

}
