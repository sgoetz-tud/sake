package de.tud.swt.cleaningrobots.model;

import java.util.ArrayList;
import java.util.List;

/**
 * MasterRole Model only for the robot knowledge class.
 * 
 * @author Christopher Werner
 *
 */
public class MasterRoleModel extends RoleModel{

	private List<String> followers;
	
	public MasterRoleModel (String roleName) {
		super(roleName);
		followers = new ArrayList<String>();
	}
	
	/**
	 * Get the names of the Followers.
	 * @return
	 */
	public List<String> getFollowers () {
		return followers;
	}
}
