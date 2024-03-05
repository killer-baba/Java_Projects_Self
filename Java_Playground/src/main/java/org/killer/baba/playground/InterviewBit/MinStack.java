package org.killer.baba.playground.InterviewBit;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() > x){
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int temp = stack.pop();
        if(!minStack.isEmpty() && minStack.peek() == temp){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.peek();
    }
}
