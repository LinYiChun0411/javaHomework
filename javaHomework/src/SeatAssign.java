import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

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
		FileReader fr = new FileReader("passengers.txt");
		String line;
		String[] terms = new String[4];

		Comparator<Passenger> comparator = new PassengerComp();
		PriorityQueue<Passenger> priorityQueue = new PriorityQueue<Passenger>(
				comparator);

		BufferedReader br = new BufferedReader(fr);
		System.out.println("�Ƨǫe:");
		while (br.ready()) {

			line = br.readLine();//Ū���@��
			Passenger passenger = new Passenger();
			terms = line.split("\\s");

			String name = terms[0];
			int mileage = Integer.parseInt(terms[1]);
			int years = Integer.parseInt(terms[2]);
			int counterpriority = Integer.parseInt(terms[3]);
			int priority = (mileage / 1000) + years - counterpriority;//����

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

			priorityQueue.add(passenger);//�N�����J�e��
		}
		
		fr.close();
		System.out.println("�Ƨǫ�:");
		while (!priorityQueue.isEmpty()) {
			Passenger passenger = priorityQueue.poll();
			System.out.println(passenger.getName() + " "
					+ passenger.getPriority());
		}

	}

}
