public class Game {
    public static void main(String[] args) {
        Entity monster1 = new Monster("МонстРР_1");
        Entity monster2 = new Monster("МонстРР_2");
        Entity player = new Player("ИгроКК");
        double a = player.getHealth();
        int g = 1;
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
        System.out.println(player.toString());

        do {
            if (monster1.getHealth() > 0) {
                player.hit(monster1);
                if (monster1.getHealth() <= 0) {
                    System.out.println("Монстр_1 мертв!");
                }
            } else {
                player.hit(monster2);
                if (monster1.getHealth() <= 0) {
                    System.out.println("Монстр_2 мертв!");
                }
            }

            if (monster1.getHealth() > 0 && player.getHealth() > 0) {
                monster1.hit(player);

                if (g <= 4 && player.getHealth() <= 0) {
                    player.healing(a);
                    g++;
                } else if (player.getHealth() > 0) {
                    System.out.println("Играем дальше!");
                } else {
                    System.out.println("Игра закончена, герой мертв!");
                }
            }


            if (monster2.getHealth() > 0 && player.getHealth() > 0) {
                monster2.hit(player);
                if (g <= 4 && player.getHealth() <= 0) {
                    player.healing(a);
                    g++;
                } else if (player.getHealth() > 0) {
                    System.out.println("Играем дальше!");
                } else {
                    System.out.println("Игра закончена, герой мертв!");
                }
            }

        }
        while (player.getHealth() > 0 && monster1.getHealth() > 0 && monster2.getHealth() > 0);
        System.out.println("Game over!");
    }
}

