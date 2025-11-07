package rpg.story;

public class StoryText {
    public static void intro(String name) {
        System.out.println("\n[프롤로그]");
        System.out.println("어느 날, " + name + "는 오래된 던전에 대한 소문을 들었다.");
        System.out.println("“보물을 지키는 괴물들이 출몰한다더라…”");
        System.out.println("가벼운 마음으로 들어갔다가, 생각보다 진지해진 모험이 시작되었다.\n");
    }

    public static void outro(boolean alive) {
        System.out.println("\n[에필로그]");
        if (alive) {
            System.out.println("당신은 던전에서 살아 돌아왔다. 아직 더 깊은 곳이 남아있지만… 오늘은 여기까지!");
        } else {
            System.out.println("모험은 여기서 끝났다. 하지만 소문은 계속된다. 언젠가 또 다른 누군가가 이 길을 걷겠지.");
        }
    }
}
