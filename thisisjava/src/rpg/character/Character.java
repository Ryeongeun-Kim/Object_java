package rpg.character;

import rpg.battle.AttackStrategy;

public abstract class Character {
    protected String name;
    protected int maxHp;
    protected int hp;
    protected int atk;
    protected int def;
    protected AttackStrategy attackStrategy;

    public Character(String name, int maxHp, int atk, int def) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.atk = atk;
        this.def = def;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int dmg) {
        hp = Math.max(0, hp - dmg);
    }

    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
    }

    // getters
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAtk() { return atk; }
    public int getDef() { return def; }

    public AttackStrategy getAttackStrategy() { return attackStrategy; }
    public void setAttackStrategy(AttackStrategy attackStrategy) { this.attackStrategy = attackStrategy; }
}
