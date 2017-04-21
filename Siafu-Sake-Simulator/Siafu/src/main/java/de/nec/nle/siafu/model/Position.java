package de.nec.nle.siafu.model;

public class Position {

	/** The row for this position, starting at the top of the map. */
	protected int i;

	/** The column for this position, starting at the left side of the map. */
	protected int j;
	
	protected Position () {
		
	}
	
	public Position (int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	/**
	 * Print the position in the form "row.col".
	 * 
	 * @return the String representing the position
	 */
	public String toString() {
		return i + "." + j;
	}

	/**
	 * Calculate the position's hashcode, which is the toString() output's hash
	 * code.
	 * 
	 * @return the hashcode of the toString() output
	 */
	public int hashCode() {
		return toString().hashCode();
	}
	
	/**
	 * Get the row for this position. The first row, 0, is on top of the map.
	 * 
	 * @return the row number
	 */
	public int getRow() {
		return i;
	}

	/**
	 * Set the row for this position. The first row, 0, is on top of the map.
	 * 
	 * @param newI
	 *            the row number
	 */
	public void setRow(int newI) {
		this.i = newI;
	}

	/**
	 * Get the column for this position. The first column, 0, is on the left
	 * side of the map.
	 * 
	 * @return the row number
	 */
	public int getCol() {
		return j;
	}

	/**
	 * set the column for this position. The first column, 0, is on the left
	 * side of the map.
	 * 
	 * @param newJ
	 *            the row number
	 */
	public void setCol(int newJ) {
		this.j = newJ;
	}
}
