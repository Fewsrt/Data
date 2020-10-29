public class Stack { // Create Class

    private String stack[];
    private int top;
    private static final int SIZE = 5;
    String name;

    public Stack(int SIZE) {
        stack = new String[SIZE];
        top = 0;
    }

    public void push(String s) { // Method to Insert

        if (isStackFull())
            System.out.println("Stack is Full "); // If Stack full Print Full
        else {
        }
        stack[top] = s;
        top++;
    }

    public String pop() { // Method to Delete

        if (isStackEmpty())
            System.out.println("Stack is Empty "); // If Stack empty print Empty
        else {
            String value = stack[top];
            top--;
            return value;
        }
        return stack[top];
    }

    public String toString() { // Method print Logical Stack
        if (isStackEmpty())
            System.out.println("Stack is Empty "); // If Stack empty print Empty
        else
            System.out.println("\nThe Stack");
        String result = "";

        for (int j = 0; j < top; j++)

            result = result + stack[j].toString() + "\n";

        return result;
    }

    public boolean isStackEmpty() { // Method boolean type to check empty Stack
        return (top == 0);
    }

    public boolean isStackFull() { // Method boolean type to check full Stack
        return (top == (SIZE - 1));
    }
}
