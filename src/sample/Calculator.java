package sample;

import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(count("2+3*4"));
    }


    public static Double count(String sentence) {

        StringTokenizer tokenizer = new StringTokenizer(sentence, "+-*/", true);
        String[] tokens = new String[tokenizer.countTokens()];
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokenizer.nextToken();

        }


        Stack<String> operators = new Stack<String>();
        Stack<Double> numbers = new Stack<Double>();

        for (int i = 0; i < tokens.length; i++) {
            Double numberOne;
            Double numberTwo;
            Double result = 0d;
            String operator;

            if (!tokens[i].equals("-") && !tokens[i].equals("+") &&
                    !tokens[i].equals("/") && !tokens[i].equals("*")) {
                numbers.push(Double.valueOf(tokens[i]));
            } else {
                if (operators.empty()) {
                    operators.push(tokens[i]);
                } else if (hasHigherOrEqualPriority(operators.peek(), tokens[i])) {
                    operators.push(tokens[i]);
                } else {
                    numberOne = numbers.pop();
                    numberTwo = numbers.pop();
                    operator = operators.pop();
                    if (operator.equals("*")) {
                        result = numberOne * numberTwo;
                    } else if (operator.equals("/")) {
                        result = numberTwo / numberOne;
                    }
                    numbers.push(result);
                    operators.push(tokens[i]);
                }
            }
        }

        Double result = 0d;

        while (!operators.empty()) {
            Double numberOne = numbers.pop();
            Double numberTwo = numbers.pop();
            String operator = operators.pop();

            if (operator.equals("*")) {
                result = numberTwo * numberOne;
            } else if (operator.equals("/")) {
                result = numberTwo / numberOne;
            } else if (operator.equals("+")) {
                result = numberTwo + numberOne;
            } else if (operator.equals("-")) {
                result = numberTwo - numberOne;
            }
            numbers.push(result);
        }

        return result;
    }

    public static boolean hasHigherOrEqualPriority(String stackTop, String nextOperator) {
        if (nextOperator.equals("*") || nextOperator.equals("/")) {
            return true;
        } else {
            if (stackTop.equals("+") || stackTop.equals("-")) {
                return true;
            } else {
                return false;
            }
        }
    }
}

