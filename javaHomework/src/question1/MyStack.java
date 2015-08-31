package question1;
public class MyStack {
	
	int top=-1;;//位置
	int MAX_STACK_SIZE;
	char[] stack;
	
	public MyStack(int MAX_STACK_SIZE) {
		this.MAX_STACK_SIZE=MAX_STACK_SIZE;
		stack = new char[MAX_STACK_SIZE];
	}
	public void push(char element){//入栈
		top++;//加入元素
		stack[top]=element;
	}

	public char pop() {
		
		char element;
		element = stack[top];
		top--;// 刪除元素
		return element;
		

	}
	public boolean isStackEmpty(){
		if(top < 0){			
			return true;					
		}
		else
			return false;
	}
	public boolean isStackFull(){
		if(top >= MAX_STACK_SIZE - 1){			
			return true;					
		}else
		{
			return false;
		}
	}
	public int size(){
		return top+1;
	}

}
