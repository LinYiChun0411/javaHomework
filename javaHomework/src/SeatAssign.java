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
		System.out.println("排序前:");
		while (br.ready()) {

			line = br.readLine();//讀取一行
			Passenger passenger = new Passenger();
			terms = line.split("\\s");

			String name = terms[0];
			int mileage = Integer.parseInt(terms[1]);
			int years = Integer.parseInt(terms[2]);
			int counterpriority = Integer.parseInt(terms[3]);
			int priority = (mileage / 1000) + years - counterpriority;//公式

			// 每筆計算後印出
			System.out.println("姓名:" + name + " 累積里程數:" + mileage + " 年資:"
					+ years + " 親臨櫃台報到的順序:" + counterpriority + " 計算後的順序:"
					+ priority);

			// 寫入物件
			passenger.setName(name);
			passenger.setMileage(mileage);
			passenger.setYears(years);
			passenger.setCounterpriority(counterpriority);
			passenger.setPriority(priority);

			priorityQueue.add(passenger);//將物件放入容器
		}
		
		fr.close();
		System.out.println("排序後:");
		while (!priorityQueue.isEmpty()) {
			Passenger passenger = priorityQueue.poll();
			System.out.println(passenger.getName() + " "
					+ passenger.getPriority());
		}

	}

}
