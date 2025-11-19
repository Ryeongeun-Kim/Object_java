package ch06.team;

import java.util.Scanner;

public class BankAccount {
	private static Account[] accounts = new Account[100];
	private static int index = 0; //저장 계좌 수
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		while (true) {
			System.out.println("---------------------------------------------------");
			System.out.println("1.계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("---------------------------------------------------");
			System.out.println("선택 > ");
			
			String select = scanner.nextLine();
			
			if(select.equals("1")) {
				createAccount();
			} 
			else if(select.equals("2")) {
				accountList();
			}
			else if(select.equals("3")) {
				deposit();
			}
			else if(select.equals("4")) {
				withdraw();
			}
			else if(select.equals("5")) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력 해주세요.");
			}
		}
	}
	
	private static void createAccount() {
		System.out.println("-----------");
		System.out.println("계좌생성");
		System.out.println("-----------");
		System.out.print("계좌번호: ");
		String ano = scanner.nextLine();
		System.out.print("계좌주: ");
		String owner = scanner.nextLine();
		System.out.print("초기입금액: ");
		int balance = Integer.parseInt(scanner.nextLine());
		
		accounts[index] = new Account(ano, owner, balance);
		index++;
		
		System.out.println("결과: 계좌가 생성되었습니다.");
	}
	
	private static void accountList() {
		System.out.println("-----------");
		System.out.println("계좌목록");
		System.out.println("-----------");
		
		for(int i = 0; i < index; i++) {
			Account acc = accounts[i];
//			System.out.println(acc.getAno() + "\t" + acc.getOwner() + "\t" + acc.getBalance());
			System.out.printf("%-12s %-8s %d\n",
					acc.getAno(),
					acc.getOwner(),
					acc.getBalance());
		}
	}
	
	private static void deposit() {
		System.out.println("-----------");
		System.out.println("예금");
		System.out.println("-----------");
		
		System.out.println("계좌번호: ");
		String ano = scanner.nextLine();
		
		Account acc = findAccount(ano);
		if(acc == null) {
			System.out.println("계좌 미존재");
			return;
		}
		System.out.print("예금액: ");
		int money = Integer.parseInt(scanner.nextLine());
		acc.setBalance(acc.getBalance() + money);
	}
	
	private static Account findAccount(String ano) {
		for(int i = 0; i<index; i++) {
			if (accounts[i].getAno().equals(ano)) {
				return accounts[i];
			}
		}
		return null;
	}
	
	private static void withdraw() {
		System.out.println("-----------");
		System.out.println("출금");
		System.out.println("-----------");
		System.out.print("계좌번호: ");
		String ano = scanner.nextLine();
		
		Account acc = findAccount(ano);
		if(acc == null) {
			System.out.println("계좌 미존재");
			return;
		}
		System.out.print("출금액: ");
		int money = Integer.parseInt(scanner.nextLine());
		if(acc.getBalance() < money) {
			System.out.println("잔액 부족 -> 출금 실패");
			return;
		}
		acc.setBalance(acc.getBalance() - money);
		System.out.println("결과: 출금이 성공되었습니다.");
	}
}
