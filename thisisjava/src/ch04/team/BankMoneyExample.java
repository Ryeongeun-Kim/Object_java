package ch04.team;

import java.util.Scanner;

public class BankMoneyExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 0; // 초기 잔고 0

        while (true) {
            System.out.println("-------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("-------------------------------");
            System.out.print("선택> ");

            String input = sc.nextLine(); // 메뉴 입력받기-

            switch (input) {
                case "1":
                    System.out.print("예금액> ");
                    int deposit = Integer.parseInt(sc.nextLine());
                    balance += deposit;
                    break;
                case "2":
                    System.out.print("출금액> ");
                    int withdraw = Integer.parseInt(sc.nextLine());
                    if (withdraw > balance) {
                        System.out.println("잔고가 부족합니다!");
                    } else {
                        balance -= withdraw;
                    }
                    break;
                case "3":
                    System.out.println("잔고> " + balance);
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return; // while문 빠져나와 종료
                default:
                    System.out.println("잘못된 입력입니다. 1~4 중 선택하세요.");
            }
        }
    }
}
