package rpg.character.factory;

import java.util.Random;
import rpg.character.Monster;
import rpg.battle.PhysicalAttack;
import rpg.battle.MagicAttack;

public class MonsterFactory {
    private static final Random R = new Random();

    public static Monster create(int stage) {
        // 스테이지가 높아질수록 체력/공격이 조금씩 증가
        int tier = Math.min(3, (stage + 1) / 2); // 대략 1~3 티어
        switch (tier) {
            case 1:
                if (R.nextBoolean()) {
                    return new Monster("슬라임", 35 + stage * 2, 8 + stage, 2 + stage / 2, new PhysicalAttack());
                } else {
                    return new Monster("고블린", 30 + stage * 3, 10 + stage, 1 + stage / 2, new PhysicalAttack());
                }
            case 2:
                if (R.nextBoolean()) {
                    return new Monster("스켈레톤", 55 + stage * 3, 14 + stage, 3 + stage / 2, new PhysicalAttack());
                } else {
                    return new Monster("임프(마법)", 45 + stage * 3, 12 + stage, 2 + stage / 2, new MagicAttack());
                }
            default:
                if (R.nextBoolean()) {
                    return new Monster("미니 드레이크", 80 + stage * 4, 18 + stage, 5 + stage / 2, new PhysicalAttack());
                } else {
                    return new Monster("어둠의 수습생", 70 + stage * 4, 16 + stage, 4 + stage / 2, new MagicAttack());
                }
        }
    }
}
