package infixpostfixcalculator;

import infixpostfixcalculator.LinkedStack;

public class Converter {



    public static String toPostFix(String infixString){

        char[] charString = infixString.toCharArray();
        String[] parsedInfix = parse(charString);

        String postfixString ="";

        LinkedStack<String> operatorStack = new LinkedStack<String>();

        for(int i = 0; i < parsedInfix.length; i++){

            if(parsedInfix[i] != null){
                if(isNumeric(parsedInfix[i])){
                    postfixString = postfixString + parsedInfix[i] + " ";
                } else if(parsedInfix[i].equals("(")){ //check if (
                    operatorStack.push(parsedInfix[i]);
                } else if(parsedInfix[i].equals(")")){
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")){
                        postfixString = postfixString + operatorStack.pop() + " ";
                    }
                    operatorStack.pop();
                } else {
                    while(!operatorStack.isEmpty() && weight(operatorStack.peek()) >= weight(parsedInfix[i])){
                        postfixString = postfixString + operatorStack.pop() + " ";
                    }
                    operatorStack.push(parsedInfix[i]);
                }
            }
        }
        while (!operatorStack.isEmpty()){
            postfixString += operatorStack.pop() + " ";
        }


        return postfixString;
    }


    private static int weight(String operator){

        int result = 0;

        switch(operator){
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
            case "^":
                result = 3;
                break;
        }

        return result;

    }
    private static String[] parse(char[] input) {
        int inputLength = input.length;

        LinkedStack<String> expStack = new LinkedStack<String>();

        for (int i = 0; i < inputLength; ++i) {
            char c = input[i];
            if (Character.isDigit(c)) {
                String number = input[i] + "";
                for (int j = i + 1; j < inputLength; ++j) {
                    if (Character.isDigit(input[j])) {
                        number += input[j];
                        i = j;
                    } else {
                        break;
                    }
                }
                expStack.push(number+"");
            } else if (c == '*' || c == '/' ||
                    c == '+' || c == '^' ||
                    c == '-' || c == '(' || c == ')') {
                expStack.push(c+"");
            }
        }


        String[] parsed = new String[expStack.size()];
        for(int i = expStack.size()-1; i > -1; i--){
            parsed[i] = expStack.pop();
        }


        return parsed;
    }

    //check to see if string is a number
    private static boolean isNumeric(String s){
        try{
            double d = Double.parseDouble(s);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

}