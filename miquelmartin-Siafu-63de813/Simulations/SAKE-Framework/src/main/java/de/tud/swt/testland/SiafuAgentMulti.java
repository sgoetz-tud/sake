package de.tud.swt.testland;

import java.util.LinkedList;
import java.util.List;

import de.nec.nle.siafu.model.MultiAgent;
import de.nec.nle.siafu.model.MultiWorld;
import de.tud.swt.cleaningrobots.Configuration;
import de.tud.swt.cleaningrobots.ISimulatorAdapter;
import de.tud.swt.cleaningrobots.AgentCore;
import de.tud.swt.cleaningrobots.hardware.Accu;
import de.tud.swt.cleaningrobots.model.Position;

/**
 * Without user interface report in Siafu.
 * The SiafuAgentMulti can work with the objects in Siafu knows about walls and near agents.
 * 
 * @author Christopher Werner
 *
 */
public class SiafuAgentMulti extends MultiAgent implements ISimulatorAdapter, ISimulatorAgent {

	private boolean finish;
	
	protected AgentCore cleaningRobot;	
	
	public SiafuAgentMulti (String name, Position start, MultiWorld world, Configuration configuration) {
		super(name, start.getX(), start.getY(), world);
		
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
	public void setName(String name) {
		super.setName(name);
		this.cleaningRobot.setName(name);
	}
	
	@Override
	public void setPosition(Position position) {
		setCol(position.getX());
		setRow(position.getY());		
	}

	@Override
	public boolean isWall(int row, int col) {
		return siafuWorld.isAWall(row, col);
	}
	
	@Override
	public Position getPosition() {
		return new Position(getCol(), getRow());
	}

	@Override
	public List<AgentCore> getNearRobots(int visionRadius) {
		List <AgentCore> result = new LinkedList<AgentCore>(); 
		
		for (MultiAgent nearAgent : this.siafuWorld.getPeople())
		{
			//If there are near Robots
			if (Math.abs(this.getCol() - nearAgent.getCol()) <= visionRadius 
					&& Math.abs(this.getRow() - nearAgent.getRow()) <= visionRadius){
				result.add(((SiafuAgentMulti)nearAgent).getAgentCore());
			}
		}
		return result;
	}
	
	@Override
	public List<AgentCore> getAllRobots() {
		List <AgentCore> result = new LinkedList<AgentCore>(); 
				
		for (MultiAgent nearAgent : this.siafuWorld.getPeople())
		{
			result.add(((SiafuAgentMulti)nearAgent).getAgentCore());
		}
		return result;
	}

	@Override
	public void setSpeed(int speed) {
		// do nothing		
	}
}
