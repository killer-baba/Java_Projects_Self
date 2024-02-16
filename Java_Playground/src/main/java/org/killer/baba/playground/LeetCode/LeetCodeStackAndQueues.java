package org.killer.baba.playground.LeetCode;


import java.util.Stack;

public class LeetCodeStackAndQueues {


    //Valid Parentheses
    public boolean isValid(String s) {
        if(s==null || s.isEmpty() || s.charAt(0) == ']' || s.charAt(0) == '}' || s.charAt(0) == ')'){
            return false;
        }
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            char temp = s.charAt(i);
            if(temp == '{' || temp == '(' || temp == '[' ){
                flag=true;
                charStack.push(temp);
            }else if (!charStack.isEmpty() && temp == '}' && charStack.peek() == '{'){
                charStack.pop();
                flag=true;
            }else if (!charStack.isEmpty() && temp == ')' && charStack.peek() == '('){
                charStack.pop();
                flag=true;
            }else if (!charStack.isEmpty() && temp == ']' && charStack.peek() == '['){
                charStack.pop();
                flag=true;
            }
            if(!flag){
                return false;
            }
        }
        return charStack.isEmpty();

    }

    //Daily Temperatures
    public int[] dailyTemperatures(int[] temperatures) {
        int [] answer = new int[temperatures.length];
        Stack<Integer> minVal = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while(!minVal.isEmpty() && temperatures[i] > temperatures[minVal.peek()]){
                int index = minVal.pop();
                answer[index] = i-index;
            }
            minVal.push(i);
        }
        return answer;
    }

    //Evaluate Reverse Polish Notation
    public int evalRPN(String[] tokens) {
        Stack<Integer> evaluator = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int temp1=0,temp2=0;
            if(!evaluator.isEmpty() && tokens[i].equals("+")){
                temp1 = evaluator.pop();
                temp2 = evaluator.pop();
                evaluator.push(temp1+temp2);
            }else if (!evaluator.isEmpty() && tokens[i].equals("-")){
                temp1 = evaluator.pop();
                temp2 = evaluator.pop();
                evaluator.push(temp1+temp2);
            }else if (!evaluator.isEmpty() && tokens[i].equals("*")){
                temp1 = evaluator.pop();
                temp2 = evaluator.pop();
                evaluator.push(temp1+temp2);
            }else if (!evaluator.isEmpty() && tokens[i].equals("/")){
                temp1 = evaluator.pop();
                temp2 = evaluator.pop();
                evaluator.push(temp1+temp2);
            }else {
                evaluator.push(Integer.parseInt(tokens[i]));
            }
        }
        return evaluator.pop();
    }
    public static void main(String[] args) {

        MinStack ms = new MinStack();
        ms.push(0);
        ms.push(1);
        ms.push(0);
    }
}

//Min Stack
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek()>=val){
            minStack.push(val);
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int value = stack.pop();
        if(minStack.peek()==value){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}