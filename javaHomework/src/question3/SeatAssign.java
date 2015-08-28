package question3;

import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class PassengerComp implements Comparator<Passenger> {
	@Override
	public int compare(Passenger passenger1, Passenger passenger2) {
		if (passenger1.getPriority() < passenger2.getPriority()) {
			return -1;
		} else if (passenger1.getPriority() == passenger2.getPriority()) {
			return 0;
		} else {
			return 1;
		}
	}
}

public class SeatAssign {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/question3/passengers.txt");//�۹���|

		Comparator<Passenger> comparator = new PassengerComp();
		PriorityQueue<Passenger> priorityQueue = new PriorityQueue<Passenger>(
				comparator);
	
		Scanner input = new Scanner(fr);
		System.out.println("�Ƨǫe:");
		while (input.hasNext()) {
			Passenger passenger = new Passenger();	
			String name=input.next();//Ū���m�W(�r��)		
			int mileage = input.nextInt();//Ū���ֿn���{��(���)
			int years = input.nextInt();//Ū���~��(���)
			int counterpriority = input.nextInt();//Ū�����{�d�x���쪺����(���)
			int priority = (mileage / 1000) + years - counterpriority;//�p��P������

			// �C���p���L�X
			System.out.println("�m�W:" + name + " �ֿn���{��:" + mileage + " �~��:"
					+ years + " ���{�d�x���쪺����:" + counterpriority + " �p��᪺����:"
					+ priority);

			// �g�J����
			passenger.setName(name);
			passenger.setMileage(mileage);
			passenger.setYears(years);
			passenger.setCounterpriority(counterpriority);
			passenger.setPriority(priority);

			priorityQueue.add(passenger);//�N�����J�e�� �̭��OminHeap�����c 
		}
		
		fr.close();
		System.out.println("�Ƨǫ�:");
		while (!priorityQueue.isEmpty()) {
			Passenger passenger = priorityQueue.poll();//�C���qroot���X���O�̤p���A�]��minHeap�����c
			System.out.println(passenger.getName() + " "
					+ passenger.getPriority());
		}

	}

}
