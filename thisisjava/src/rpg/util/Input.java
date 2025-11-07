package rpg.util;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();
        while (s.trim().isEmpty()) {
            System.out.print(prompt);
            s = sc.nextLine();
        }
        return s.trim();
    }

    public static int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력하세요.");
            }
        }
    }
}
