package de.nec.nle.siafu.model;

/**
 * Instance of this class represents the agent which has the world and working on there.
 * 
 * Is need for simulations without GUI showing element.
 * 
 * @author Christopher Werner
 *
 */
public class MultiAgent extends AAgent {

	private int col;
	private int row;
	
	public MultiAgent(int col, int row, IExternalConnection extern) {
		this("", col ,row , extern);
	}
	
	public MultiAgent(String name, int col, int row, IExternalConnection extern) {
		super(name, extern);
		this.col = col;
		this.row = row;
	}	
	
	@Override
	public int getCol() {
		return this.col;
	}
	
	@Override
	public int getRow() {
		return this.row;
	}

	@Override
	public void setPosition(int col, int row) {
		this.col = col;
		this.row = row;	
	}
}
