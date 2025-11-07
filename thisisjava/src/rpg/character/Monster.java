package rpg.character;

public class Monster extends Character {
    public Monster(String name, int maxHp, int atk, int def, rpg.battle.AttackStrategy strategy) {
        super(name, maxHp, atk, def);
        this.attackStrategy = strategy;
    }
}
