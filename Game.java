public class Game {
    public static void main(String[] args) {
        Player player = new Player(20, 13, 40, 6);
        Monster monster = new Monster(10, 6, 40, 4);

        while (player.health > 0 && monster.health > 0) {
            player.attack(monster);
            if (monster.health <= 0) {
                break;
            }
            System.out.println("Player attacks monster. Monster's health: " + monster.health);
            monster.attack(player);
            if (player.health <= 0) {
                break;
            }
            System.out.println("Monster attacks player. Player's health: " + player.health);
            player.heal();
            System.out.println("Player uses healing. Player's health: " + player.health);
        }
    }
}
