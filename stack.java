import java.util.*; 

class stack
{ 
	// Pushing element on the top of the stack 
	static void stack_push(Stack<Integer> stack) 
	{ 
		for(int i = 0; i < 5; i++) 
		{ 
			stack.push(i); 
		} 
	} 
	
	// Popping element from the top of the stack 
	static void stack_pop(Stack<Integer> stack) 
	{ 
		System.out.println("Pop Operation:"); 

		for(int i = 0; i < 5; i++) 
		{ 
			Integer y = (Integer) stack.pop(); 
			System.out.println(y); 
		} 
	} 
	public static void main (String[] args) 
	{ 
		Stack<Integer> stack = new Stack<Integer>(); 

		stack_push(stack); 
		stack_pop(stack); 
		stack_push(stack); 
	} 
} 
