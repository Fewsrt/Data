import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Infix {

    Stack<Double> ToEvaluate = new Stack<Double>();
    Stack<String> ToPostFix = new Stack<String>();
    Queue<String> Numbers = new LinkedList<>();

    public String infix(String[] infix) {
        String output = "";
        for (int i = 0; i < infix.length; i++) {
            if (precedence(infix[i]) > 0) {
                while (ToPostFix.isEmpty() == false && precedence(ToPostFix.peek()) >= precedence(infix[i])) {
                    while (Numbers.isEmpty() == false) {
                        output += Numbers.remove() + " ";
                    }
                    output += ToPostFix.pop() + " ";
                }
                ToPostFix.push(infix[i]);
            } else if (infix[i].equals(")")) {
                String x = ToPostFix.pop();
                while (!x.equals("(")) {
                    while (Numbers.isEmpty() == false) {
                        output += Numbers.remove() + " ";
                    }
                    output += x + " ";
                    x = ToPostFix.pop();
                }
            } else if (infix[i].equals("(")) {
                ToPostFix.push(infix[i]);
            } else {
                Numbers.add(infix[i]);
            }
        }
        for (int i = 0; i <= ToPostFix.size(); i++) {
            while (Numbers.isEmpty() == false) {
                output += Numbers.remove() + " ";
            }
            output += ToPostFix.pop() + " ";
        }
        return output;
    }

    static int precedence(String c) {
        switch (c) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1;
    }

    public Double postfixEval(String result) {
        String[] Evaluate = result.split(" ");

        for (int i = 0; i < Evaluate.length; i++) {

            double x = 0;

            if (Evaluate[i].equals("+")) {
                x = ToEvaluate.pop();
                x = ToEvaluate.pop() + x;
                ToEvaluate.push(x);
            } else if (Evaluate[i].equals("-")) {
                x = ToEvaluate.pop();
                x = ToEvaluate.pop() - x;
                ToEvaluate.push(x);
            } else if (Evaluate[i].equals("*")) {
                x = ToEvaluate.pop();
                x = ToEvaluate.pop() * x;
                ToEvaluate.push(x);
            } else if (Evaluate[i].equals("/")) {
                x = ToEvaluate.pop();
                x = ToEvaluate.pop() / x;
                ToEvaluate.push(x);
            } else {
                double a = Double.parseDouble(Evaluate[i]);
                ToEvaluate.push(a);

            }
        }
        return ToEvaluate.pop();
    }
    public static void main(String[] args) {
        Infix in = new Infix();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println();
            System.out.println("Shunting Yard Algorithm 62050140 Chonnaphat Visetchock\n Ex. : ( ( 5 + 5 ) * 3 ) / 6\n");
            System.out.print(" - Enter infix : ");
            String input = sc.nextLine();
            System.out.println();
            System.out.print(" - Infix   : " + input);
            String[] infix = input.split(" ");
            System.out.println();
            System.out.print(" - Postfix : " + in.infix(infix));
            System.out.println();
            String result = in.infix(infix);
            System.out.print(" - Result  : " + in.postfixEval(result));
            System.out.println();
        } finally {
            sc.close();
        }
    }
}
