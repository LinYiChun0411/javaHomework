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
		FileReader fr = new FileReader("src/question3/passengers.txt");//相對路徑

		Comparator<Passenger> comparator = new PassengerComp();
		PriorityQueue<Passenger> priorityQueue = new PriorityQueue<Passenger>(
				comparator);
	
		Scanner input = new Scanner(fr);
		System.out.println("排序前:");
		while (input.hasNext()) {
			Passenger passenger = new Passenger();	
			String name=input.next();//讀取姓名(字串)		
			int mileage = input.nextInt();//讀取累積里程數(整數)
			int years = input.nextInt();//讀取年資(整數)
			int counterpriority = input.nextInt();//讀取親臨櫃台報到的順序(整數)
			int priority = (mileage / 1000) + years - counterpriority;//計算P的公式

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

			priorityQueue.add(passenger);//將物件放入容器 裡面是minHeap的結構 
		}
		
		fr.close();
		System.out.println("排序後:");
		while (!priorityQueue.isEmpty()) {
			Passenger passenger = priorityQueue.poll();//每次從root取出都是最小的，因為minHeap的結構
			System.out.println(passenger.getName() + " "
					+ passenger.getPriority());
		}

	}

}
