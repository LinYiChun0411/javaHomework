package question1;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		
		MyStack stack=new MyStack(100);
		MyQueue queue=new MyQueue(100);
		
		System.out.println("LinYiChun");
		System.out.println("A:開始 B:結束");
		
		Scanner inputChar=new Scanner(System.in);	
		char ch = inputChar.next().charAt(0); //字元輸入
		while (ch != 'B') {
			switch (ch) {
			case 'A':
				Scanner scanner = new Scanner(System.in);
				System.out.println("請輸入回文上半部:");
				String inputString = scanner.next();// 字串輸入
				// System.out.println("請輸入1(奇數) or 2(偶數):");
				int num = scanner.nextInt();// 整數輸入

				if (inputString.length() <= 10) {
					int Length = inputString.length();
					// 將元素放入Queue
					for (int index = 0; index < Length; index++) {
						char element = inputString.charAt(index);
						if (!queue.isQueueFull()) {
							queue.enqueue(element);
						}
					}
					
					// 判斷回文奇偶
					if (num == 1) {
						Length--;
					}
					// 將元素放入Stack
					for (int index = 0; index < Length; index++) {
						char element = inputString.charAt(index);
						if (stack.isStackFull()) {// 如果stack未滿則放入
							System.out.println("堆疊已滿");
						} else {
							stack.push(element);
						}
					}
				} else {
					System.out.println("字數限自10個以內請重新輸入");
					continue;
				}
				break;
			}
			
			System.out.println("A:重新開始 B:結束");
			ch = inputChar.next().charAt(0); //字元輸入
		}
		
		
		//output
		//取出queue
		while(!queue.isQueueEmpty()){
			char element=queue.dequeue();			
			System.out.print(element);
		}
		//取出stack
		while(!stack.isStackEmpty()){
			char element=stack.pop();			
			System.out.print(element);
		}
		
		inputChar.close();
		

	}

}
