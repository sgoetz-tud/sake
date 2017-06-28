package de.nec.nle.siafu.model;

public class Agent {
	
	protected Position pos;
	protected String name;
	//private IExternalConnection extern;
	
	public Agent (String name, int col, int row)
	{
		this.name = name;
		this.setPosition(col, row);
	}
	
	public Agent (String name)
	{
		this.name = name;
	}
	
	/*public Agent (String name, int col, int row, IExternalConnection extern)
	{
		this.name = name;
		this.extern = extern;
		this.setPosition(col, row);
	}*/
	
	/*public Agent (String name, IExternalConnection extern)
	{
		this.name = name;
		this.extern = extern;
	}
	
	public IExternalConnection getExternal ()
	{
		return this.extern;
	}*/
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName (String name)
	{
		this.name = name;
	}
	
	public int getCol() {
		return pos.getCol();
	}

	public int getRow() {
		return pos.getRow();
	}
	
	public void setPosition(int col, int row) {
		this.pos = new Position(col, row);
	}

}
