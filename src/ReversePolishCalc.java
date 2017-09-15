import java.util.Arrays;

public class ReversePolishCalc {

    int topStack = -1;

    // The array of the input string split up
    private String[] tokens;

    // The stack
    private String[] stack;

    public double calculate(String input) {

        // 1. Use the String split method to split the string into tokens at the commas
        tokens = input.split(",");

        // 2. Allocate a stack as big as the number of tokens
        stack = new String[tokens.length];

        double operand1;
        double operand2;
        double result;

        // 3. write the algorithm
        for(int i = 0; i < tokens.length; ++i) {
            // calls to push() and pop() and do the math here
            if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
                push(tokens[i]);
            } else if (tokens[i].equals("+")) {
                operand1 = pop();
                operand2 = pop();
                result = operand1 + operand2;
                push(result);
            } else if(tokens[i].equals("-")) {
                operand1 = pop();
                operand2 = pop();
                result = operand2 - operand1;
                push(result);
            } else if(tokens[i].equals("*")) {
                operand1 = pop();
                operand2 = pop();
                result = operand1 * operand2;
                push(result);
            } else if(tokens[i].equals("/")) {
                operand1 = pop();
                operand2 = pop();
                result = operand2 / operand1;
                push(result);
            }
        }

        // 4. return the result
        return pop();
    }

    private void push(String number) {
        // push on the stack
        stack[++topStack] = number;
    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
        stack[++topStack] = String.valueOf(d);
    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        return Double.valueOf(stack[topStack--]);


    }


}

