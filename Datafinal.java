import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Datafinal {

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

    static String infixToPostFix(String[] numOP) {

        String result = "";
        Stack<String> ops = new Stack<>();
        Queue<String> Num = new LinkedList<>();

        for (int i = 0; i < numOP.length; i++) {
            if (precedence(numOP[i]) > 0) {
                while (ops.isEmpty() == false && precedence(ops.peek()) >= precedence(numOP[i])) {
                    while (ops.isEmpty() == false) {
                        result += Num.remove();
                    }
                    result += ops.pop();
                }
                ops.push(numOP[i]);
            } else if (numOP[i].equals(")")) {
                String x = ops.pop();
                while (!x.equals("(")){
                    while (ops.isEmpty() == false) {
                        result += Num.remove();
                    }
                    result += x;
                    x = ops.pop();
                }
            } else if (numOP[i].equals("(")) {
                ops.push(numOP[i]);
            } else {
                Num.add(numOP[i]);
            }
        }
        for (int i = 0; i <= ops.size(); i++) {
            while (Num.isEmpty() == false) {
                result += Num.remove();
            }
            result += ops.pop();
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        try {
            System.out.println();
            System.out.println("Shunting Yard Algorithm 62050140 Chonnaphat Visetchock\n");
            String tokens = "5+5*10-2";
            String[] NumOP = tokens.split(" ");
            System.out.print("Enter infix : " + tokens);
            System.out.println();
            // String tokens = input.nextLine();
            System.out.print("Infix : " + tokens);
            System.out.println();
            System.out.print("Postfix :" + infixToPostFix(NumOP));
            System.out.println();
            System.out.print("Result : ");
        } finally {
            input.close();
        }

    }

}