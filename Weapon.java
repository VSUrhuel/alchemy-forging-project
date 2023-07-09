public abstract class Weapon extends Item implements Mergeable
{
	private double baseDamage;
	private double damageModifier;
	private double baseDurability;
	private double durabilityModifier;

	public Weapon(String name, double baseDamage, double baseDurability, int value, double weight)
	{
		super(name, value, weight);
		this.baseDamage = baseDamage;
		this.baseDurability = baseDurability;
		this.damageModifier = 1;
		this.durabilityModifier = 1;
	}
	public abstract void enhance();
	public int getValue()
	{
		return super.getValue();
	}
	public double getBaseDamage(){return this.baseDamage;}
	public double getDamageModifier(){return this.damageModifier;}
	public double getDurabilityModifier(){return this.durabilityModifier;}
	public double getBaseDurability(){return this.baseDurability;}
	public void setBaseDamage(double baseDamage){this.baseDamage = baseDamage;}
	public void setDamageModifier(double damageModifier){this.damageModifier = damageModifier;}
	public void setBaseDurability(double baseDurability){this.baseDurability = baseDurability;}
	public void setDurabilityModifier(double durabilityModifier){this.durabilityModifier = durabilityModifier;}

	@Override
	public void destroy()
	{
		this.baseDurability = 0;
	}
}