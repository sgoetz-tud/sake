package de.tud.swt.cleaningrobots.model;

/**
 * FollowerRole Model only for the robot knowledge class.
 * 
 * @author Christopher Werner
 *
 */
public class FollowerRoleModel extends RoleModel{
	
	private String master;
	
	public FollowerRoleModel(String roleName) {
		super(roleName);
	}
	
	/**
	 * Get the name of the Master.
	 * @return
	 */
	public String getMaster () {
		return master;
	}

	/**
	 * Set the name of the Master.
	 * @param master
	 */
	public void setMaster (String master) {
		this.master = master;
	}
}
