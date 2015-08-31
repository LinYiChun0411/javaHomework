package question1;

public class MyQueue {
	int MAX_QUEUE_SIZE;
	char queue[];
	int rear = -1;
	int front = -1;
	public MyQueue(int MAX_QUEUE_SIZE) {
		this.MAX_QUEUE_SIZE=MAX_QUEUE_SIZE;
		queue=new char[MAX_QUEUE_SIZE];
	}
	
	public void enqueue(char element){
		queue[++rear]=element;
	}
	
	public char dequeue(){
		char c = queue[++front];
		return c;
	}
	public boolean isQueueFull(){
		if(rear >= MAX_QUEUE_SIZE - 1 )
			return true;
		else
			return false;
	}
	public boolean isQueueEmpty(){
		if(front == rear)
			return true;
		else
			return false;
	}
}
