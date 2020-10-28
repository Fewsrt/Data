import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Datafinal {

    public Double evaluate(String expression) {
        Stack<Character> ops = new Stack<>();
        Queue<Double> numbers = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < expression.length())
                        c = expression.charAt(i);
                    else
                        break;
                }
                i--;
                numbers.add((double) num);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    double output = performOperation(numbers, ops);
                    numbers.add((double) output);
                }
                ops.pop();
            } else if (isOperator(c)) {
                while (!ops.isEmpty() && precedence(c) <= precedence(ops.peek())) {
                    double output = performOperation(numbers, ops);
                    numbers.add((double) output);
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            double output = performOperation(numbers, ops);
            numbers.add((double) output);
        }
        return numbers.poll();
    }

    public Character postfix(Character tokens){
        return tokens;
    }

    public double performOperation(Queue<Double> numbers, Stack<Character> ops) {
        Double a = numbers.poll();
        Double b = numbers.poll();
        char checkops = ops.pop();
        switch (checkops) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return b / a;
        }
        return 0;
    }

    public boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void PrintStack(Stack<Character> ops) {
        if (ops.isEmpty())
            return;
        Character x = ops.peek();
        ops.pop();
        PrintStack(ops);
        System.out.print(x + " ");
        ops.push(x);
    }

    public static void main(String[] args) {
        Datafinal result = new Datafinal();
        Scanner input = new Scanner(System.in);
        try {
            System.out.println();
            System.out.println("Shunting Yard Algorithm 62050140 Chonnaphat Visetchock\n");
            System.out.print("Enter infix : ");
            String tokens = input.nextLine();
            System.out.print("Infix : " + tokens);
            System.out.println();
            System.out.print("Postfix :");
            System.out.println();
            System.out.print("Stack Data : ");
            System.out.println();
            System.out.print("Queue Data : ");
            System.out.println();
            System.out.print("Result : " + result.evaluate(tokens));
        } finally{
            input.close();
        }

    }

}
