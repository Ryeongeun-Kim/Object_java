package rpg;

import rpg.story.StoryText;
import rpg.util.Input;
import rpg.character.Player;
import rpg.character.Monster;
import rpg.character.factory.MonsterFactory;
import rpg.battle.BattleSystem;
import rpg.util.EventLogger;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Dungeon Text RPG (Lite) ===");
        System.out.println("1. 새 게임 시작");
        System.out.println("0. 종료");
        int choice = Input.getInt(">> ");

        if (choice != 1) {
            System.out.println("게임을 종료합니다.");
            return;
        }

        String name = Input.getString("플레이어 이름: ");
        Player player = new Player(name);

        StoryText.intro(name);

        int stage = 1;
        while (player.isAlive()) {
            System.out.println("\n--- 스테이지 " + stage + " ---");
            Monster monster = MonsterFactory.create(stage);
            System.out.println("야생의 " + monster.getName() + "(이/가) 나타났다!");

            BattleSystem battle = new BattleSystem(player, monster);
            // 간단 Observer: 전투 로그를 콘솔로 받아보기
            battle.addObserver(new EventLogger());

            boolean win = battle.start();
            if (!win) {
                System.out.println("\n당신은 쓰러졌습니다...");
                break;
            }

            // 클리어 보상 (간단)
            int heal = Math.min(10 + stage * 2, player.getMaxHp() - player.getHp());
            player.heal(heal);
            System.out.println("[회복] 전투 후 휴식으로 HP +" + heal + " 회복 (현재 HP " + player.getHp() + "/" + player.getMaxHp() + ")");

            // 다음 행동
            System.out.println("\n1. 다음 스테이지");
            System.out.println("2. 마을로 귀환(게임 종료)");
            int next = Input.getInt(">> ");
            if (next == 2) {
                System.out.println("\n" + name + "는 안전하게 마을로 귀환했습니다. 수고했어요!");
                break;
            }
            stage++;
        }

        StoryText.outro(player.isAlive());
        System.out.println("=== 게임 종료 ===");
    }
}
