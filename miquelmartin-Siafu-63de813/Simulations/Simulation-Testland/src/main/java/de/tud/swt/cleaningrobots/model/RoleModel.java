package de.tud.swt.cleaningrobots.model;

/**
 * Role Model only for the robot knowledge class.
 * 
 * @author Christopher Werner
 *
 */
public class RoleModel {

	private String roleName;
	
	public RoleModel (String roleName) {
		this.roleName = roleName;
	}
	
	/**
	 * Get the name of the role.
	 * @return
	 */
	public String getRoleName () {
		return roleName;
	}
}
