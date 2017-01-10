package de.tud.swt.cleaningrobots.util;

import java.util.List;

import de.tud.swt.cleaningrobots.model.Field;

/**
 * Saves new information about a bundle of fields.
 * 
 * @author Christopher Werner
 *
 */
public class FieldMergeInformation {
	
	/**
	 * List of new Field from Follower;
	 */
	private List<Field> fields;
	
	public FieldMergeInformation (List<Field> fields) {
		this.fields = fields;
	}
	
	/**
	 * Get List of fields from follower.
	 * @return list of new fields
	 */
	public List<Field> getFields () {
		return this.fields;
	}
}
