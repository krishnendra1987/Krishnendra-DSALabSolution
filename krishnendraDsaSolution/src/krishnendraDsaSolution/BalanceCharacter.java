package krishnendraDsaSolution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalanceCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:- ");
		while(sc.hasNextLine())  {
		String strExp = sc.nextLine();
	
		// Function call
		if (isBalance(strExp))
			System.out.println("The entered String has Balanced Brackets ");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
		
		sc.close();
	}

	// function to check if brackets are balanced
	private static boolean isBalance(String strExp) {

		Deque<Character> listData = new ArrayDeque<Character>();

		// Traversing the Expression
		for (int i = 0; i < strExp.length(); i++) {
			char x = strExp.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				listData.push(x);
				continue;
			}

			if (listData.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = listData.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = listData.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = listData.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}
		return (listData.isEmpty());
	}

}
