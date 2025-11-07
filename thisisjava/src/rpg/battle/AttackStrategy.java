package rpg.battle;

import rpg.character.Character;

public interface AttackStrategy {
    int calculateDamage(Character attacker, Character defender);
    String name(); // 로그 예쁘게 출력용
}
