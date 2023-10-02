public class Monster extends Creature {
    public Monster(int attack, int defense, int health, int damage) {
        super(attack, defense, health, damage);
    }

    @Override
    protected int getMaxHealth() {
        return health;
    }

    @Override
    protected int getDamageRange() {
        return damage;
    }

    @Override
    protected void die() {
        System.out.println("The monster died");
    }
}