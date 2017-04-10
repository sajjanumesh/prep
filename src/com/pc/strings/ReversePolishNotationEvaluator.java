package com.pc.strings;

import java.util.Stack;

/**
 * Created by zambro on 3/7/17.
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are +, -, *, /. Each operand may be an integer or another expression. For example:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

 */
public class ReversePolishNotationEvaluator {

/* *
*
* push each element to stack
* when an operator is encountered, pop two elements from stack
* and perform operation. Push the result to stack and continue
*
* */

    public static int evaluate(String str) {
        String operators ="+-*/";
        char[] charArray = str.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        for(char c: charArray) {
            if(operators.indexOf(c) != -1) {
                //Found an operator
                if(!stack.isEmpty()) {
                    int number1 = stack.pop();
                    int number2 = stack.pop();
                    switch(operators.indexOf(c)) {
                        case 0:
                            stack.push(number1 + number2);
                            break;
                        case 1:
                            stack.push(number2 - number1);
                            break;
                        case 2:
                            stack.push(number1 * number2);
                            break;
                        case 3:
                            stack.push(number2 / number2);
                            break;
                    }
                }
            } else {
                //Found an integer
                stack.push(c - '0');
            }
        }

        return stack.isEmpty() ? 0 : stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("21+4*"));
        System.out.println(evaluate("438++"));
    }
}
