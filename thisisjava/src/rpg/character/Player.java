package rpg.character;

import rpg.battle.PhysicalAttack;

public class Player extends Character {
    private int potions = 2; // 간단 회복 아이템

    public Player(String name) {
        super(name, 100, 12, 5);
        this.attackStrategy = new PhysicalAttack(); // 기본은 물리공격
    }

    public int usePotion() {
        if (potions <= 0) return 0;
        potions--;
        int heal = 25;
        heal(heal);
        return heal;
    }

    public int getPotions() { return potions; }
}
