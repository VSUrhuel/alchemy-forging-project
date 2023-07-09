public class Dagger extends Weapon
{
	public Dagger(double baseDamage, double baseDurability, int value)
	{
		super("Dagger", baseDamage, baseDurability, value, 90);
		setDamageModifier(3.6);
		setDurabilityModifier(1.4);
	}
	public void enhance()
	{
		this.setBaseDamage(getBaseDamage() + getDamageModifier());
	}
	public void use()
	{
		if(this.getBaseDurability() == 0)
		{
			System.out.println("You cannot used your dagger. It is destroyed.");
		}
		else
			System.out.println("You have used your dagger to attack");
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
				if(weapon instanceof Staff)
				{
					Staff s = new Staff(weapon.getBaseDamage(), weapon.getBaseDurability(), weapon.getValue());
					weapon.destroy();
					return s;
				}
				if(weapon instanceof Bow)
				{
					Bow b = new Bow(weapon.getBaseDamage(), weapon.getBaseDurability(), weapon.getValue());
					weapon.destroy();
					return b;
				}
			}
				weapon.destroy();
				Dagger d = new Dagger(this.getBaseDamage(), this.getBaseDurability(), this.getValue());
				super.destroy();
				return d;
	}
}