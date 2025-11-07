package rpg.battle;

import rpg.character.Character;

public class PhysicalAttack implements AttackStrategy {
    @Override
    public int calculateDamage(Character a, Character d) {
        // 아주 간단한 공식: 공격 - 방어, 최소 1
        return Math.max(1, a.getAtk() - d.getDef());
    }

    @Override
    public String name() {
        return "물리공격";
    }
}
