package de.nec.nle.siafu.model;

public class Place {

	/** The name of the place. */
	protected String name;

	/**
	 * The type of place. If the place was created using an image, this is the
	 * image name.
	 */
	protected String type;

	/** The position of the place. */
	protected Position pos;
	
	protected Place () {
		
	}
	
	public Place (String type, String name, Position pos) {
		this.type = type;
		this.name = name;
		this.pos = pos;
	}
	
	/**
	 * Turn the place to a String by returning it's name.
	 * 
	 * @return the place's name
	 */
	public String toString() {
		return getName();
	}

	/**
	 * Get the place's name.
	 * 
	 * @return the place's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the place.
	 * 
	 * @param name the place name
	 */
	/*public void setName(final String name) {
		this.name = name;
	}*/

	/**
	 * Get the place's type.
	 * 
	 * @return the place's type
	 */
	public String getType() {
		return type;
	}
	
	public int getCol() {
		return pos.getCol();
	}

	public int getRow() {
		return pos.getRow();
	}

	/**
	 * Get the position of the place.
	 * 
	 * @return the place's position
	 */
	/*public Position getPosition() {
		return pos;
	}*/
}
