public class Bow extends Weapon implements Chargeable
{
	public Bow(double baseDamage, double baseDurability, int value)
	{
		super("Bow", baseDamage, baseDurability, value, 90);
		setDamageModifier(3);
		setDurabilityModifier(3.6);
	}
	public void enhance()
	{
		this.setBaseDamage(getBaseDamage() + getDurabilityModifier());
	}
	@Override
	public void charge()
	{
		this.setBaseDamage(getBaseDamage() * getDamageModifier());
	}
	public void use()
	{
		if(this.getBaseDurability() == 0)
		{
			System.out.println("You cannot used your bow. It is destroyed.");
			this.setBaseDamage(getBaseDamage() / getDamageModifier());
		}
		else if(getBaseDamage() % 3 == 0)
		{
			System.out.println("You have used your charged-bow to attack");
			this.setBaseDamage(getBaseDamage() / getDamageModifier());
		}
		else
		{
			System.out.println("You have used your bow to attack");
			this.setBaseDamage(getBaseDamage() / getDamageModifier());
		}
	}
	public Weapon merge(Weapon weapon)
	{
			if(weapon.getBaseDamage() > this.getBaseDamage() && weapon.getBaseDurability() > this.getBaseDurability())
			{
				super.destroy();
				if(weapon instanceof Sword)
				{
					Sword s = new Sword(weapon.getBaseDamage(), weapon.getBaseDurability(), weapon.getValue());
					weapon.destroy();
					return s;
				}
				if(weapon instanceof Dagger)
				{
					Dagger d = new Dagger(weapon.getBaseDamage(), weapon.getBaseDurability(), weapon.getValue());
					weapon.destroy();
					return d;
				}
				if(weapon instanceof Staff)
				{
					Staff s = new Staff(weapon.getBaseDamage(), weapon.getBaseDurability(), weapon.getValue());
					weapon.destroy();
					return s;
				}
			}
				weapon.destroy();
				Bow b = new Bow(this.getBaseDamage(), this.getBaseDurability(), this.getValue());
				super.destroy();
				return b;
	}
}