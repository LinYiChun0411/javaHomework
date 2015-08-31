package question1;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		
		MyStack stack=new MyStack(100);
		MyQueue queue=new MyQueue(100);
		
		System.out.println("LinYiChun");
		System.out.println("A:�}�l B:����");
		
		Scanner inputChar=new Scanner(System.in);	
		char ch = inputChar.next().charAt(0); //�r����J
		while (ch != 'B') {
			switch (ch) {
			case 'A':
				Scanner scanner = new Scanner(System.in);
				System.out.println("�п�J�^��W�b��:");
				String inputString = scanner.next();// �r���J
				// System.out.println("�п�J1(�_��) or 2(����):");
				int num = scanner.nextInt();// ��ƿ�J

				if (inputString.length() <= 10) {
					int Length = inputString.length();
					// �N������JQueue
					for (int index = 0; index < Length; index++) {
						char element = inputString.charAt(index);
						if (!queue.isQueueFull()) {
							queue.enqueue(element);
						}
					}
					
					// �P�_�^��_��
					if (num == 1) {
						Length--;
					}
					// �N������JStack
					for (int index = 0; index < Length; index++) {
						char element = inputString.charAt(index);
						if (stack.isStackFull()) {// �p�Gstack�����h��J
							System.out.println("���|�w��");
						} else {
							stack.push(element);
						}
					}
				} else {
					System.out.println("�r�ƭ���10�ӥH���Э��s��J");
					continue;
				}
				break;
			}
			
			System.out.println("A:���s�}�l B:����");
			ch = inputChar.next().charAt(0); //�r����J
		}
		
		
		//output
		//���Xqueue
		while(!queue.isQueueEmpty()){
			char element=queue.dequeue();			
			System.out.print(element);
		}
		//���Xstack
		while(!stack.isStackEmpty()){
			char element=stack.pop();			
			System.out.print(element);
		}
		
		inputChar.close();
		

	}

}
