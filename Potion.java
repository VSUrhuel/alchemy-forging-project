public class Potion extends Consumable
{
	private int points;

	public Potion(String name, int points, int value)
	{
		super(name, value, 1.0, false);
		this.points = points;
	}
	@Override
	public void use()
	{
		System.out.println("The " + super.getName() + " potion was consumed.");
		super.setConsumed(true);
	}
}