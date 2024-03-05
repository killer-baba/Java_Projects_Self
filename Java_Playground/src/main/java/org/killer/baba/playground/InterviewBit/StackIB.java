package org.killer.baba.playground.InterviewBit;
import java.util.Arrays;
import java.util.Stack;

public class StackIB {

    public String reverseString(String A) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        int length = A.length();
        for (int i = 0; i < length; i++) {
            stack.push(A.charAt(i));
        }
        A ="";
        for (int i = 0; i < length; i++) {
            A = A + stack.pop();
        }
        return A;
    }

    public int isValid(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            //System.out.println(A.charAt(i));
            if(A.charAt(i) == '{' || A.charAt(i) == '[' || A.charAt(i) == '('){
                stack.push(A.charAt(i));
            }
            else if(!stack.isEmpty() && A.charAt(i) == '}' && stack.peek() == '{'){
                stack.pop();
            }else if(!stack.isEmpty() && A.charAt(i) == ']' && stack.peek() == '['){
                stack.pop();
            }else if(!stack.isEmpty() && A.charAt(i) == ')' && stack.peek() == '('){
                stack.pop();
            }else {
                return 0;
            }
        }
        if(stack.isEmpty()){
            return 1;
        }
        return 0;
    }

    public String simplifyPath(String A) {
        Stack<String> stack = new Stack<>();
        if(A.charAt(0) == '/'){
        A = A.substring(1);}
        if(A.charAt(A.length()-1)=='/'){
            A = A.substring(0,A.length()-1);
        }
        String[] strArray = A.split("/");
        for (String str : strArray){
            System.out.println("Str Array => " + str);
            if(str.isEmpty()){
                continue;
            }
            if(!stack.isEmpty() && str.equals("..")){
                stack.pop();
                continue;
            }else if(!stack.isEmpty() && str.equals(".")){
                continue;
            }
            if(!str.equals("..") && !str.equals(".")){
            stack.push(str);}
        }

        A = "";
        while (!stack.isEmpty()){
            //System.out.println("value  ==> " + stack.peek());
            String temp = A;
            A = "/" + stack.pop() + temp;

        }
        if(A.isEmpty()){
            A = "/";
        }
        return A;
    }

    public int braces(String A) {
        if(A.isEmpty()){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            int count = 0;
            if(A.charAt(i) == '+' || A.charAt(i) == '/' || A.charAt(i) == '*' || A.charAt(i) == '-' || A.charAt(i) == '('){
                stack.push(A.charAt(i));
            }
            if(A.charAt(i) == ')'){
                while (!stack.isEmpty() && stack.pop() != '('){
                    count++;
                }
                if(count==0){
                    return 1;
                }
            }

        }
        return 0;
    }

}
