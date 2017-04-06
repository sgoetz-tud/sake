package de.tud.swt.testland;

import java.util.LinkedList;
import java.util.List;

import de.nec.nle.siafu.model.AAgent;
import de.nec.nle.siafu.model.IExternalConnection;
import de.nec.nle.siafu.model.AWorld;
import de.tud.swt.cleaningrobots.Configuration;
import de.tud.swt.cleaningrobots.ISimulatorAdapter;
import de.tud.swt.cleaningrobots.AgentCore;
import de.tud.swt.cleaningrobots.hardware.Accu;
import de.tud.swt.cleaningrobots.model.Position;

/**
 * With user interface report in Siafu.
 * The SiafuAgent can work with the objects in Siafu and represents the Position in the map for the GUI
 * and knows about walls and near agents.
 * 
 * @author Christopher Werner
 *
 */
public class SiafuAgent implements ISimulatorAdapter, IExternalConnection {

	private boolean finish;	
	private AgentCore cleaningRobot;
	private AWorld siafuWorld;
	private AAgent siafuAgent;
	
	public SiafuAgent(String name, String image, AWorld world, Configuration configuration) {
		this.siafuWorld = world;
		this.siafuAgent = world.createPeople(name, image, world, this);
		this.cleaningRobot = new AgentCore(name, this, new Accu(48.0), configuration);
	}	
	
	public AAgent getRelatedAgent () {
		return siafuAgent;
	}
		
	public void wander() {
		this.finish = this.cleaningRobot.action();
	}
	
	/**
	 * Return if the agent is finished.
	 * 
	 * @return finish state
	 */
	public boolean isFinish () {
		return this.finish;
	}

	/**
	 * Return the underlying AgentCore of this SiafuAgent.
	 * 
	 * @return underlying agent core
	 */
	public AgentCore getAgentCore() {
		return this.cleaningRobot;
	}

	public void setName(String name) {
		this.siafuAgent.setName(name);
		this.cleaningRobot.setName(name);
	}
	
	public void setSpeed(int speed) {
		//ignore..
	}

	@Override
	public List<AgentCore> getNearRobots(int visionRadius) {
		List <AgentCore> result = new LinkedList<AgentCore>(); 
		
		for (AAgent nearAgent : this.siafuWorld.getAgents())
		{
			if (Math.abs(this.siafuAgent.getCol() - nearAgent.getCol()) <= visionRadius 
					&& Math.abs(this.siafuAgent.getRow() - nearAgent.getRow()) <= visionRadius){
				result.add(((SiafuAgent) nearAgent.getExternal()).getAgentCore());
			}
		}
		return result;
	}
	
	@Override
	public List<AgentCore> getAllRobots() {
		List <AgentCore> result = new LinkedList<AgentCore>(); 
				
		for (AAgent nearAgent : this.siafuWorld.getAgents())
		{
			result.add(((SiafuAgent) nearAgent.getExternal()).getAgentCore());
		}
		return result;
	}
	
	@Override
	public Position getPosition() {
		Position result = new Position(this.siafuAgent.getCol(), this.siafuAgent.getRow());
		return result;
	}
	
	@Override
	public void setPosition(Position position) {
		this.siafuAgent.setPosition(position.getY(), position.getX());
	}

	@Override
	public boolean isWall(int row, int col) {
		return siafuWorld.isAWall(row, col);
	}
}
