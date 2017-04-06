package de.nec.nle.siafu.model;

public abstract class AAgent {
	
	protected String name;
	private IExternalConnection extern;
	
	public AAgent (String name, IExternalConnection extern)
	{
		this.name = name;
		this.extern = extern;
	}
	
	public IExternalConnection getExternal ()
	{
		return this.extern;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName (String name)
	{
		this.name = name;
	}
	
	public abstract int getCol ();
	
	public abstract int getRow ();
	
	public abstract void setPosition (int col, int row);

}
