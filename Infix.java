import java.util.Stack;
import java.util.Scanner;
public class Infix
{
   public static void main(String[] args)
   {
      Stack<String> ops  = new Stack<String>(); //Operator stack
      Stack<Double> vals = new Stack<Double>(); // Values stack
      Scanner input = new Scanner(System.in);  
      String[] tokens = input.nextLine().split(" ");  // read input and store it as array of strings delimited by spaces
      for (int i=0;i<tokens.length;i++) // take one token at a time
      {  
        if (tokens[i].equals("("))               ; // just ignore left paranthesis
         else if (tokens[i].equals("+"))    ops.push(tokens[i]); // if the token is an operator, push into Operator stack
         else if (tokens[i].equals("-"))    ops.push(tokens[i]);
         else if (tokens[i].equals("*"))    ops.push(tokens[i]);
         else if (tokens[i].equals("/"))    ops.push(tokens[i]);
         else if (tokens[i].equals("sqrt")) ops.push(tokens[i]);
         else if (tokens[i].equals("^"))     ops.push(tokens[i]);
         else if (tokens[i].equals(")"))    // if token is ")", Pop, evaluate, and push result 
         {  
            String op = ops.pop(); // pop the recent operator from Operator stack
            double v = vals.pop(); // pop one value from Values stack
        if (op.equals("+"))    v = vals.pop() + v; // perform  corresponding operation by poping another value and store it in v itself
            else if (op.equals("-"))    v = vals.pop() - v;
            else if (op.equals("*"))    v = vals.pop() * v;
            else if (op.equals("/"))    v = vals.pop() / v;
            else if (op.equals("sqrt")) v = Math.sqrt(v); // for squrare root, only one value is needed. It is already popped out in v.
            else if(op.equals("^")) v=Math.pow(vals.pop(),v); // to calculate exponent(^)
            vals.push(v); // push the result into Values stack
         } 
         else vals.push(Double.parseDouble(tokens[i]));   // if none of above if applies, the token should be a number. Push it into Values stack
      }
      System.out.println(vals.pop());
   }
}