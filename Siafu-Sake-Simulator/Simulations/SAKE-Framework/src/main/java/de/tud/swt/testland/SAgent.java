package de.tud.swt.testland;

import java.util.LinkedList;
import java.util.List;

import de.nec.nle.siafu.exceptions.PlaceNotFoundException;
import de.nec.nle.siafu.model.Agent;
import de.nec.nle.siafu.model.SiafuWorld;
import de.nec.nle.siafu.model.World;
import de.nec.nle.siafu.model.SiafuAgent;
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
public class SAgent extends SiafuAgent implements ISimulatorAdapter, ICoreAdapter {

	private boolean finish;	
	private AgentCore cleaningRobot;
	private World siafuWorld;
	
	public SAgent(String name, String image, World world, Configuration configuration) throws PlaceNotFoundException {
		super(name, ((SiafuWorld)world).getRandomPlaceOfType("Center").getPos(), image,(SiafuWorld)world);
		this.siafuWorld = world;
		this.cleaningRobot = new AgentCore(name, this, new Accu(48.0), configuration);
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

	@Override
	public List<AgentCore> getNearRobots(int visionRadius) {
		List <AgentCore> result = new LinkedList<AgentCore>(); 
		
		for (Agent nearAgent : this.siafuWorld.getAgents())
		{
			if (Math.abs(this.getCol() - nearAgent.getCol()) <= visionRadius 
					&& Math.abs(this.getRow() - nearAgent.getRow()) <= visionRadius){
				result.add(((SAgent)nearAgent).getAgentCore());
			}
		}
		return result;
	}
	
	@Override
	public List<AgentCore> getAllRobots() {
		List <AgentCore> result = new LinkedList<AgentCore>(); 
				
		for (Agent nearAgent : this.siafuWorld.getAgents())
		{
			result.add(((SAgent)nearAgent).getAgentCore());
		}
		return result;
	}
	
	@Override
	public Position getPosition() {
		Position result = new Position(this.getCol(), this.getRow());
		return result;
	}
	
	@Override
	public void setPosition(Position position) {
		this.setPosition(position.getY(), position.getX());
	}

	@Override
	public boolean isWall(int row, int col) {
		return siafuWorld.isAWall(row, col);
	}
}
