public class Staff extends Weapon implements Chargeable
{
	public Staff(double baseDamage, double baseDurability, int value)
	{
		super("Staff", baseDamage, baseDurability, value, 90);
		setDamageModifier(3);
		setDurabilityModifier(3.6);
	}
	public void enhance()
	{
		this.setBaseDamage(getBaseDamage() + getDurabilityModifier());
	}
	public void charge()
	{
		this.setBaseDamage(getBaseDamage() * getDamageModifier());
	}
	public void use()
	{
		if(this.getBaseDurability() == 0)
		{
			System.out.println("You cannot used your staff. It is destroyed.");
			this.setBaseDamage(getBaseDamage() / getDamageModifier());
		}
		else if(getBaseDamage() % 3 == 0)
		{
			System.out.println("You have used your charged-staff to attack");
			this.setBaseDamage(getBaseDamage() / getDamageModifier());
		}
		else
		{
			System.out.println("You have used your staff to attack");
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
				if(weapon instanceof Bow)
				{
					Bow b = new Bow(weapon.getBaseDamage(), weapon.getBaseDurability(), weapon.getValue());
					weapon.destroy();
					return b;
				}
			}
				weapon.destroy();
				Staff s = new Staff(this.getBaseDamage(), this.getBaseDurability(), this.getValue());
				super.destroy();
				return s;
			
	}
}