import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Datafinal {
    static void PrintStack(Stack<String> ops) {
        if (ops.isEmpty())
            return;
        String x = ops.peek();
        ops.pop();
        PrintStack(ops);
        System.out.print(x + " ");
        ops.push(x);
    }

    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Queue<Double> qvals = new LinkedList<>();
        System.out.println("Shunting Yard Algorithm 62050140 Chonnaphat Visetchock\n");
        System.out.print("Enter infix : ");
        Scanner input = new Scanner(System.in);
        String[] tokens = input.nextLine().split(" ");
        System.out.print("Infix : ");
        for (int i = 0; i < tokens.length; i++)
            System.out.print(tokens[i]);
        System.out.println();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("("))
                ;
            else if (tokens[i].equals("+"))
                ops.push(tokens[i]);
            else if (tokens[i].equals("-"))
                ops.push(tokens[i]);
            else if (tokens[i].equals("*"))
                ops.push(tokens[i]);
            else if (tokens[i].equals("/"))
                ops.push(tokens[i]);
            else if (tokens[i].equals(")")) {
            } else
                qvals.add(Double.parseDouble(tokens[i]));
        }
        System.out.print("Postfix :");
        System.out.println();
        System.out.print("Stack Data : ");
        PrintStack(ops);
        System.out.println();
        System.out.print("Queue Data : " + qvals);
        System.out.println();
        System.out.print("Result : ");
    }

}
