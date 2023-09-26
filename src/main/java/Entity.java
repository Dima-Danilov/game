import java.util.Random;


abstract class Entity {

    Random rnd = new Random();
    private String name;
    int n = 30;
    private int attack; // от 1 до 30
    private int protection; // от 1 до 30
    private double health; // от 1 до N
    private int damage; // от M до N

    private int attackModifier; // attack - protection + 1
    boolean success = false;
    int udachnoeChislo;

    public Entity() {
    }

    public void hit(Entity entity) {
        calculationOfAttack(entity);
        if (attackModifier <= 0) {
            System.out.println("Кидает кубик один раз!");
            cubeThrow();
            if (success == true) {
                enemyStrike(entity);
            }
        } else {
            success = false;
            System.out.println("Кидает кубик много раз!");
            for (int i = 1; i <= (attackModifier) & success != true; i++) {
                System.out.println("Попытка №" + i);
                cubeThrow();
                if (success == true) {
                    enemyStrike(entity);
                }
            }
            success = false;
        }
    }


    public int calculationOfAttack(Entity entity) {
        attackModifier = (attack - entity.protection) + 1;
        System.out.println("Бросает " + name + ". Количество бросков: " + attack + " - " + entity.protection + " + 1 = " + attackModifier);
        System.out.println("Здоровье противника: " + entity.getName() + " " + entity.health);
        return attackModifier;
    }

    public void enemyStrike(Entity entity) {
        entity.setHealth(entity.getHealth() - damage);
        System.out.println("Здоровье противника: " + entity.getHealth() + " (уменьшено на урон - " + damage + ")");
    }

    public boolean cubeThrow() {
        udachnoeChislo = rnd.nextInt(1, 6);
        System.out.println("На кубике выпало: " + udachnoeChislo);
        if (udachnoeChislo >= 5) {
            System.out.println("Успех!");
            success = true;
        } else {
            System.out.println("Не успех(");
            success = false;
        }
        return success;
    }

    public void healing(double a) {
        setHealth(0.3 * a);
        System.out.println("Игрок реанимирован! Здоровье игрока: " + getHealth() + ". Играем дальше!");
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public double getHealth() {
        return health;
    }

    public double setHealth(double health) {
        this.health = health;
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAttackModifier() {
        return attackModifier;
    }

    public void setAttackModifier(int attackModifier) {
        this.attackModifier = attackModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Персонаж: {" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", protection=" + protection +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }
}



