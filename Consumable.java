public abstract class Consumable extends Item
{
	private boolean consumed;
	private boolean spoiled;

	public Consumable(String name, int value, double weight, boolean spoiled)
	{
		super(name,value,weight);
		this.spoiled = spoiled;
		consumed = false;
	}

	public boolean isConsumed(){return this.consumed;}
	public boolean isSpoiled(){return this.spoiled;}
	public void setConsumed(boolean consumed){this.consumed = consumed;}

}