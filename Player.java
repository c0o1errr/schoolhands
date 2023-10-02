public class Player extends Creature {
    private int maxHP;
    public Player(int attack, int defense, int health, int damage) {
        super(attack, defense, health, damage);
        this.maxHP = health;
    }

    @Override
    protected int getMaxHealth() {
        return this.maxHP;
    }

    @Override
    protected int getDamageRange() {
        return damage;
    }

    @Override
    protected void die() {
        System.out.println("The player died");
    }
}