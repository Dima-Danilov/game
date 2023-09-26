public class Player extends Entity {

    public Player(String name) {
        super.setName(name);
        super.setAttack(rnd.nextInt(1, 30));
        super.setProtection(rnd.nextInt(1, 30));
        super.setHealth(rnd.nextInt(1, 30));
        super.setDamage(rnd.nextInt(1, 15));
    }
}
