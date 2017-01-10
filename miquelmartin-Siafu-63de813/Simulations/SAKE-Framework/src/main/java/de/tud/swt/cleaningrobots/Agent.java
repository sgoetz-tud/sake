/**
 * Structure classes from SAKE.
 */
package de.tud.swt.cleaningrobots;

/**
 * Abstract agent class with the information of new knowledge.
 * 
 * @author Christopher Werner
 *
 */
public abstract class Agent {
	
	private boolean newInformation;	

	/**
	 * Get new information info.
	 * @return <b>true</b> if agent has new information else <b>false</b>
	 */
	public boolean hasNewInformation () {
		return newInformation;
	}
	
	/**
	 * Set new information value.
	 * @param newInformation
	 */
	public void setNewInformation (boolean newInformation) {
		this.newInformation = newInformation;
	}
	
	/**
	 * Add a role to the agent core.
	 * @param role new role for the agent
	 * @return
	 */
	public abstract boolean addRole (AgentRole role);	
	
	/**
	 * Return the information if the agent play this role.
	 * @param role
	 * @return
	 */
	public abstract boolean hasRole(AgentRole role);
	
	/**
	 * Remove this role from the agent that he does not play it anymore.
	 * @param role
	 * @return
	 */
	public abstract boolean removeRole (AgentRole role);
	
	@Override
	public String toString() {
		return " NewInfo: " + newInformation;
	}	
}
