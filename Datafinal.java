import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Datafinal {

    private Precedence[] stack;
    private int top;

    private enum Precedence {
        lparen(0), rparen(1), plus(2), minus(3), divide(4), times(5), mod(6), eos(7), operand(8);

        private int index;

        Precedence(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    private Precedence pop()
    {
        return stack[top--];
    }
    private void push(Precedence ele)
    {
        stack[++top] = ele;
    }
    private static final int[] isp = {0, 19, 12, 12, 13, 13, 13, 0};
    private static final int[] icp = {20, 19, 12, 12, 13, 13, 13, 0};

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

    private static final char[] operators = { '{', '}', '+', '-', '/', '*', '%', ' ' };

    public Precedence getToken(char symbol)
    {
        switch (symbol)
        {
        case '('  : return Precedence.lparen;
        case ')'  : return Precedence.rparen;
        case '+'  : return Precedence.plus;
        case '-'  : return Precedence.minus;
        case '/'  : return Precedence.divide;
        case '*'  : return Precedence.times;
        case '%'  : return Precedence.mod;
        case ' '  : return Precedence.eos;
        default   : return Precedence.operand;
        }
    }

    public String postfix(String tokens) {
        String postfix = "";
        top = 0;
        stack = new Precedence[tokens.length()];
        stack[0] = Precedence.eos;
        Precedence token;
        for (int i = 0; i < tokens.length(); i++) {
            token = getToken(tokens.charAt(i));
            /** if token is operand append to postfix **/
            if (token == Precedence.operand)
                postfix = postfix + tokens.charAt(i);
            /** if token is right parenthesis pop till matching left parenthesis **/
            else if (token == Precedence.rparen) {
                while (stack[top] != Precedence.lparen)
                    postfix = postfix + operators[pop().getIndex()];
                /** discard left parenthesis **/
                pop();
            }
            /** else pop stack elements whose precedence is greater than that of token **/
            else {
                while (isp[stack[top].getIndex()] >= icp[token.getIndex()])
                    postfix = postfix + operators[pop().getIndex()];
                push(token);
            }
        }
        /** pop any remaining elements in stack **/
        while ((token = pop()) != Precedence.eos)
            postfix = postfix + operators[token.getIndex()];

        return postfix;
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
            String postfix = result.postfix(tokens);
            System.out.print("Postfix :" + postfix);
            System.out.println();
            System.out.print("Stack Data : ");
            System.out.println();
            System.out.print("Queue Data : ");
            System.out.println();
            System.out.print("Result : " + result.evaluate(tokens));
        } finally {
            input.close();
        }

    }

}