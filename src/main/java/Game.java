public class Game {
    public static void main(String[] args) {
        Entity monster1 = new Monster("�������_1");
        Entity monster2 = new Monster("�������_2");
        Entity player = new Player("������");
        double a = player.getHealth();
        int g = 1;
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
        System.out.println(player.toString());

        do {
            if (monster1.getHealth() > 0) {
                player.hit(monster1);
                if (monster1.getHealth() <= 0) {
                    System.out.println("������_1 �����!");
                }
            } else {
                player.hit(monster2);
                if (monster1.getHealth() <= 0) {
                    System.out.println("������_2 �����!");
                }
            }

            if (monster1.getHealth() > 0 && player.getHealth() > 0) {
                monster1.hit(player);

                if (g <= 4 && player.getHealth() <= 0) {
                    player.healing(a);
                    g++;
                } else if (player.getHealth() > 0) {
                    System.out.println("������ ������!");
                } else {
                    System.out.println("���� ���������, ����� �����!");
                }
            }


            if (monster2.getHealth() > 0 && player.getHealth() > 0) {
                monster2.hit(player);
                if (g <= 4 && player.getHealth() <= 0) {
                    player.healing(a);
                    g++;
                } else if (player.getHealth() > 0) {
                    System.out.println("������ ������!");
                } else {
                    System.out.println("���� ���������, ����� �����!");
                }
            }

        }
        while (player.getHealth() > 0 && monster1.getHealth() > 0 && monster2.getHealth() > 0);
        System.out.println("Game over!");
    }
}

