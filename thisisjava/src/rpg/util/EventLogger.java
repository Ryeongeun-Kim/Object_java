package rpg.util;

import rpg.battle.BattleSystem.BattleObserver;

public class EventLogger implements BattleObserver {
    @Override
    public void onEvent(String message) {
        // 전투 이벤트를 콘솔에 그대로 출력
        System.out.println(message);
    }
}
