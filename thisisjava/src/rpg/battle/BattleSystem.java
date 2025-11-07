package rpg.battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rpg.character.Player;
import rpg.character.Monster;
import rpg.util.Input;

public class BattleSystem {

    public interface BattleObserver {
        void onEvent(String message);
    }

    private final List<BattleObserver> observers = new ArrayList<>();
    private final Random R = new Random();

    private final Player player;
    private final Monster monster;

    public BattleSystem(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
    }

    public void addObserver(BattleObserver o) { observers.add(o); }
    private void emit(String msg) { for (var o : observers) o.onEvent(msg); }

    public boolean start() {
        emit("\n[전투 시작] " + player.getName() + "  VS  " + monster.getName());
        emit(statusLine());

        // 턴 루프
        while (player.isAlive() && monster.isAlive()) {
            // 플레이어 턴
            if (!playerTurn()) return false;
            if (!monster.isAlive()) break;

            // 몬스터 턴
            monsterTurn();
            if (!player.isAlive()) break;

            emit(statusLine());
        }

        if (player.isAlive()) {
            emit("[승리] " + monster.getName() + "를 처치했습니다!");
            return true;
        } else {
            emit("[패배] " + player.getName() + "가 쓰러졌습니다...");
            return false;
        }
    }

    private String statusLine() {
        return String.format("[상태] %s HP %d/%d  |  %s HP %d/%d",
                player.getName(), player.getHp(), player.getMaxHp(),
                monster.getName(), monster.getHp(), monster.getMaxHp());
    }

    private boolean playerTurn() {
        emit("\n[플레이어 턴]");
        emit("1. 공격  2. 물약사용  3. 도망");

        int sel = Input.getInt(">> ");
        switch (sel) {
            case 1 -> {
                int dmg = player.getAttackStrategy().calculateDamage(player, monster);
                // 15% 확률 치명타
                if (R.nextInt(100) < 15) {
                    dmg = (int)Math.round(dmg * 1.7);
                    emit("(치명타!)");
                }
                monster.takeDamage(dmg);
                emit(player.getName() + "의 " + player.getAttackStrategy().name() + "! " +
                        monster.getName() + "에게 " + dmg + " 피해!");
            }
            case 2 -> {
                int healed = player.usePotion();
                if (healed > 0) {
                    emit("회복 물약 사용! HP +" + healed);
                } else {
                    emit("물약이 없습니다!");
                }
            }
            case 3 -> {
                // 50% 확률로 도주 성공
                if (R.nextBoolean()) {
                    emit("성공적으로 도망쳤다!");
                    return false; // 전투 중단(패배 처리 아님)
                } else {
                    emit("도망 실패!");
                }
            }
            default -> emit("잘못된 선택입니다. 턴을 넘깁니다.");
        }
        return true; // 전투 계속
    }

    private void monsterTurn() {
        emit("\n[몬스터 턴]");
        int dmg = monster.getAttackStrategy().calculateDamage(monster, player);
        // 10% 확률 스킬 강화
        if (R.nextInt(100) < 10) {
            dmg = (int)Math.round(dmg * 1.4);
            emit(monster.getName() + "가 힘을 모은다!");
        }
        player.takeDamage(dmg);
        emit(monster.getName() + "의 " + monster.getAttackStrategy().name() + "! " +
                player.getName() + "에게 " + dmg + " 피해!");
    }
}
