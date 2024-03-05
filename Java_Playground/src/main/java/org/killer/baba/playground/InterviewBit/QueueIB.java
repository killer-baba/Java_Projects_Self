package org.killer.baba.playground.InterviewBit;


import java.util.*;

public class QueueIB {

    public String solve(String A) {
        StringBuilder B = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            LinkedList<Character> queue = new LinkedList<>();
            int j = 0;
            while (j <= i) {
                hashMap.put(A.charAt(j), hashMap.getOrDefault(A.charAt(j), 0) + 1);
                if (hashMap.containsKey(A.charAt(j)) && hashMap.get(A.charAt(j)) == 1) {
                    queue.add(A.charAt(j));
                }
                j+=1;
            }
            System.out.println("Queue in each iteration ==> ");
            for (Character ch : queue){
                System.out.print(ch + " | " );
            }
            System.out.println();
            for (Character ch : queue) {
                if (hashMap.get(ch) > 1) {
                    queue.remove();
                }
            }
            if(queue.isEmpty()){
                B.append("#");
            }else {
                B.append(queue.remove());
            }
        }
        return B.toString();
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> answer = new ArrayList<>();
        if(B>A.size()){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < A.size(); i++) {
                if(A.get(i)>max){
                    max = A.get(i);
                }
            }
            answer.add(max);
            return answer;
        }
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < B; i++) {
            queue.add(A.get(i));
        }
        answer.add(getMax(queue));
        int window = A.size()-B;
        for (int i = 0; i < window ; i++) {
            queue.remove();
            queue.add(A.get(i+B));
            answer.add(getMax(queue));
        }
        return answer;
    }
    public static int getMax(LinkedList<Integer> A){
        int max = Integer.MIN_VALUE;
        for (Integer i : A){
            if(i>max){
                max = i;
            }
        }
        return max;
    }

        public ArrayList<Integer> slidingMaximumOptimized(final List<Integer> A, int B) {
            ArrayList<Integer> answer = new ArrayList<>();
            Deque<Integer> deque = new LinkedList<>();

            // Iterate through the array
            for (int i = 0; i < A.size(); i++) {
                // Remove indices from the deque that are outside the current window
                while (!deque.isEmpty() && deque.peekFirst() < i - B + 1) {
                    deque.pollFirst();
                }

                // Remove elements from the end of the deque that are smaller than the current element
                while (!deque.isEmpty() && A.get(deque.peekLast()) < A.get(i)) {
                    deque.pollLast();
                }

                // Add the current index to the end of the deque
                deque.offerLast(i);

                // Add the maximum element of the current window to the answer
                if (i >= B - 1) {
                    answer.add(A.get(deque.peekFirst()));
                }
            }
            return answer;
        }

    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for (String s : A) {
            if (!stack.isEmpty() && s.equals("+")) {
                int int1 = stack.pop();
                int int2 = stack.pop();
                stack.push(int1 + int2);
            } else if (!stack.isEmpty() && s.equals("-")) {
                int int1 = stack.pop();
                int int2 = stack.pop();
                stack.push(int2 - int1);
            } else if (!stack.isEmpty() && s.equals("*")) {
                int int1 = stack.pop();
                int int2 = stack.pop();
                stack.push(int1 * int2);
            } else if (!stack.isEmpty() && s.equals("/")) {
                int int1 = stack.pop();
                int int2 = stack.pop();
                stack.push(int2 / int1);
            } else {
                stack.push(Integer.parseInt(s));
            }
            for (Integer it : stack){
                System.out.print(it + " " );
                System.out.println();
            }
        }
        return stack.peek();
    }

}
