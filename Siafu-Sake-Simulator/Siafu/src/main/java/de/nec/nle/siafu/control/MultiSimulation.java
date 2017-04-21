package de.nec.nle.siafu.control;

import de.nec.nle.siafu.behaviormodels.BaseAgentModel;
import de.nec.nle.siafu.model.World;
import de.nec.nle.siafu.model.SimulationData;
import de.tud.swt.evaluation.WorkingConfiguration;

/**
 * The multi simulation class implements the <code>Runnable</code> that performs
 * the simulation itself.
 * <p>
 * In detail, the simulation thread handles the evolution of agent, context
 * and world according to their respective models and do the iteration until finish.
 * 
 * @author Christopher Werner
 *
 */
public class MultiSimulation implements Runnable {

	/**
	 * Whether the simulation is already running.
	 */
	private boolean simulationRunning;
	
	private boolean endSimulation;
	
	/**
	 * Kill the actual Simulation.
	 */
	public void endSimulation () {
		this.endSimulation = true;
	}

	/**
	 * Find out if the simulation is already running.
	 * 
	 * @return true if the simulation is running
	 */
	public boolean isSimulationRunning() {
		return simulationRunning;
	}
		
	private World world;

	/**
	 * Build a <code>Simulation</code> object and start a thread that
	 * governs it.
	 * 
	 * @param simulationPath the path to the simulation data, which includes
	 *            maps, sprites, behavior models, etc...
	 * @param control the simulation <code>Controller</code>
	 */
	public MultiSimulation(WorkingConfiguration configuration, SimulationData simData) {
		this.simulationRunning = true;
		this.endSimulation = false;
		
		this.world = new World(simData, configuration);
		System.out.println("World created: " + configuration.toString());
						
		new Thread(this, "Simulation thread").start();
	}
	
	/**
	 * Starts the Evaluation phase. With Console.
	 */
	public void run() {
		BaseAgentModel agentModel = world.getAgentModel();
		
		//first one initialization run
		agentModel.initializeAgents(world.getAgents());//.getPeople());
		
		while (!agentModel.isRunFinish() && !this.endSimulation) {
			agentModel.doIteration(world.getAgents());//.getPeople());
		}
		simulationRunning = false;
	}
	
	
}
