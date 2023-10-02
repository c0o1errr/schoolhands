import java.util.Random;

public abstract class Creature {
    private static final int MAX_USE_HEAL = 4;
    private int healCount = 0;
    protected int attack, defense;    // целые числа от 1-30
    protected int health;   // натуральное число от 0 до N
    protected int damage;

    public Creature(int attack, int defense, int health, int damage) {
        if (attack < 1 || attack > 30 || defense < 1 || defense > 30 || health < 0) {
            throw new IllegalArgumentException("attack, defense or health outside range. ");
        }
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.damage = damage;
    }

    public void attack(Creature target) {
        int attackModifier = attack - target.defense + 1;
        int diceRolls = Math.max(attackModifier, 1);
        int successfullHits = 0;

        for (int i = 0; i < diceRolls; i++) {
            int diceRoll = rollDice(1, 6);
            if (diceRoll >= 5) {
                successfullHits++;
            }
        }

        if (successfullHits > 0) {
            int damage = getDamageRange();
            target.takeDamage(damage);
        }
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative.");
        }
        health -= damage;
        if (health <= 0) {
            die();
        }
    }

    public void heal() {
        if (healCount < MAX_USE_HEAL) {
            int maxHealth = getMaxHealth();
            int healAmount = (int) (maxHealth * 0.3);
            if (health + healAmount > maxHealth) {
                health = maxHealth;
            } else {
                health += healAmount;
            }
            healCount++;
        }
    }

    protected int rollDice(int minRnd, int maxRnd) {
        Random random = new Random();
        return random.nextInt(maxRnd - minRnd + 1) + minRnd;
    }

    protected abstract int getMaxHealth();

    protected abstract int getDamageRange();

    protected abstract void die();
}