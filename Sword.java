public class Sword extends Weapon
{  
	public Sword(double baseDamage, double baseDurability, int value)
	{
		super("Sword", baseDamage, baseDurability, value, 1);
		setDurabilityModifier(3);
	}
	public void enhance()
	{
		this.setBaseDamage(getBaseDamage() + getDurabilityModifier());
	}
	public void use()
	{
		if(this.getBaseDurability() == 0)
		{
			System.out.println("You cannot used your sword. It is destroyed.");
		}
		else
			System.out.println("You have used your sword to attack");
	}
	public Weapon merge(Weapon weapon)
	{
			if(weapon.getBaseDamage() > this.getBaseDamage() && weapon.getBaseDurability() > this.getBaseDurability())
			{
				super.destroy();
				if(weapon instanceof Staff)
				{
					Staff s = new Staff(weapon.getBaseDamage(), weapon.getBaseDurability(), weapon.getValue());
					weapon.destroy();
					return s;
				}
				if(weapon instanceof Dagger)
				{
					Dagger d = new Dagger(weapon.getBaseDamage(), weapon.getBaseDurability(), weapon.getValue());
					weapon.destroy();
					return d;
				}
				if(weapon instanceof Bow)
				{
					Bow b = new Bow(weapon.getBaseDamage(), weapon.getBaseDurability(), weapon.getValue());
					weapon.destroy();
					return b;
				}
			}
				weapon.destroy();
				Sword s = new Sword(this.getBaseDamage(), this.getBaseDurability(), this.getValue());
				super.destroy();
				return s;
	}
}