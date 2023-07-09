public class Main
{
	public static void main(String[] args) {
	  Item i = new Potion("small HP", 100, 50);
        System.out.println(i.getID()); // 0

        i = new Potion("small HP", 100, 50);
        System.out.println(i.getValue()); // 50

        i = new Potion("small HP", 100, 50);
        System.out.println(i.getName()); // "small HP"

        i = new Potion("small HP", 100, 50);
        System.out.println(i.getWeight()); // 1.0

        i = new Potion("small HP", 100, 50);
        i.setValue(200);
        System.out.println(i.getValue()); // 200

        i = new Potion("small HP", 100, 50);
        i.setName("small MP");
        System.out.println(i.getName()); // "small MP"

        i = new Potion("small HP", 100, 50);
        i.setWeight(5);
        System.out.println(i.getWeight()); // 5.0

        i = new Potion("small HP", 100, 50);
        Item j = new EnergyBall(50);
        System.out.println(i.compareByValue(j)); // 50

        i = new Potion("small HP", 100, 50);
        j = new EnergyBall(50);
        System.out.println(i.compareByWeight(j)); // -1

        Weapon w = new Dagger(20, 5, 200);
        System.out.println(w.getBaseDamage()); // 20.0

        w.enhance();
        System.out.println(w.getBaseDamage()); // 23.6

        w = new Dagger(20, 5, 200);
        System.out.println(w.getDamageModifier()); // 3.6

        w = new Dagger(20, 5, 200);
        System.out.println(w.getBaseDurability()); // 5.0

        w = new Dagger(20, 5, 200);
        System.out.println(w.getDurabilityModifier()); // 1.4

        w = new Dagger(20, 5, 200);
        w.setBaseDamage(17);
        System.out.println(w.getBaseDamage()); // 17.0

        w = new Dagger(20, 5, 200);
        w.setDamageModifier(1.1);
        System.out.println(w.getDamageModifier()); // 1.1

        w = new Dagger(20, 5, 200);
        w.setBaseDurability(500);
        System.out.println(w.getBaseDurability()); // 500.0

        w = new Dagger(20, 5, 200);
        w.setDurabilityModifier(99);
        System.out.println(w.getDurabilityModifier()); // 99.0

        w = new Dagger(20, 5, 200);
        w.destroy();
        w.use(); // "You can't use your dagger. It is destroyed"

        Consumable c = new Potion("small HP", 100, 50);
        System.out.println(c.isConsumed()); // false

        c.use();
        System.out.println(c.isConsumed()); // true

        c = new Potion("small HP", 100, 50);
        System.out.println(c.isSpoiled()); // false

        c = new Potion("small HP", 100, 50);
        System.out.println(c.isConsumed()); // false

        c.setConsumed(true);
        System.out.println(c.isConsumed()); // true

        EnergyBall e = new EnergyBall(2);
        System.out.println(e.getName()); // "energy ball"
        System.out.println(e.getValue()); // 0
        System.out.println(e.getWeight()); // 10.0
        System.out.println(e.isSpoiled()); // false

        e = new EnergyBall(2);
        e.charge();
        System.out.println(e.releaseEnergy()); // 1
        System.out.println(e.releaseEnergy()); // 0

        e = new EnergyBall(2);
        e.use(); // "This energy ball can't be used in this situation"

        e = new EnergyBall(2);
        Sword s = new Sword(30, 10, 100);
        System.out.println(e.compareByValue(s)); // -100

        e = new EnergyBall(2);
        s = new Sword(30, 10, 100);
        System.out.println(s.compareByWeight(e)); // -1

        Weapon a = new Staff(8, 10, 300);
        Weapon b = new Bow(13, 24, 170);
        Weapon x = a.merge(b);
        a.use(); // "You can't use your staff. It is destroyed."
        b.use(); // "You can't use your bow. It is destroyed."
        x.use(); // "You have used your bow to attack."

        Weapon d = new Dagger(10, 100, 300);
        d.use(); // "You have used your dagger to attack."
        d.destroy();
        d.use(); // "You can't use your dagger. It is destroyed."

        e = new EnergyBall(2);
        System.out.println(e.releaseEnergy()); // 0
        e.charge();
        e.charge();
        e.charge();
        System.out.println(e.releaseEnergy()); // 2
        System.out.println(e.releaseEnergy()); // 0
        System.out.println(e.releaseEnergy()); // "This energy ball is fully charged."

        Staff f = new Staff(8, 10, 300);
        System.out.println(f.getBaseDamage()); // 8.0
        f.charge();
        System.out.println(f.getBaseDamage()); // 24.0
        f.use();
        System.out.println(f.getBaseDamage()); // 8.0
        }
}