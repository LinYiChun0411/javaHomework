package question1;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		
		MyStack stack=new MyStack(10);
		
		System.out.println("�L�y�@");
		System.out.println("A:�}�l B:����");
		
		Scanner inputChar=new Scanner(System.in);	
		char ch = inputChar.next().charAt(0); //�r����J
		inputChar.close();
		switch (ch) {
		case 'A':
			Scanner scanner = new Scanner(System.in);
			System.out.println("�п�J�^��W�b��:");
			String inputString = scanner.next();// �r���J
			//System.out.println("�п�J1(�_��) or 2(����):");
			int num = scanner.nextInt();// ��ƿ�J

			if (inputString.length() <= 10) {
				int Length=inputString.length();
				//�N������JQueue
//				for (int index=0; index < Length; index++) {
//					char element = inputString.charAt(index);
//					
//				}
				//�P�_�^��_��
				if (num == 1)
				{	
					Length--;
				}
				//�N������JStack
				for (int index=0; index < Length; index++) {
					char element = inputString.charAt(index);
					if (stack.isStackFull()) {// �p�Gstack�����h��J
						System.out.println("���|�w��");
					} else {				
						  stack.push(element);						
					}
				}
			} else {
				System.out.println("�r�ƭ���10�ӥH��");
			}

			break;

		}
		
		
		//output		
		while(!stack.isStackEmpty()){
			char element=stack.pop();			
			System.out.print(element);
		}
		
		
		

	}

}
