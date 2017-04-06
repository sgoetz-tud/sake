package de.nec.nle.siafu.model;

import java.util.Collection;
import java.util.LinkedList;

public abstract class AWorld {
	
	protected Collection<AAgent> agents;
	
	public AWorld ()
	{
		agents = new LinkedList<AAgent>();
	}
	
	/*protected abstract createPeopleFinish();
	
	protected void createPeople() {
		try {
			model = (BaseAgentModel) simData.getAgentModelClass()
					.getConstructor(new Class[] { this.getClass() , configuration.getClass() })
					.newInstance(new Object[] { this , configuration });
		} catch (Exception e) {
			throw new RuntimeException("Can't instantiate the agent model", e);
		}
	}*/
		
	public abstract boolean isAWall(int row, int col);
	
	public Collection<AAgent> getAgents()
	{
		return agents;
	}
	
	public abstract AAgent createPeople(String name, String image, AWorld world, IExternalConnection extern);
}
