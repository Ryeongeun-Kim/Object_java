package rpg.battle;

import rpg.character.Character;

public class MagicAttack implements AttackStrategy {
    @Override
    public int calculateDamage(Character a, Character d) {
        // 방어 일부 무시: 공격력의 1.5배 - 방어의 절반
        int dmg = (int)Math.round(a.getAtk() * 1.5 - d.getDef() * 0.5);
        return Math.max(2, dmg);
    }

    @Override
    public String name() {
        return "마법공격";
    }
}
