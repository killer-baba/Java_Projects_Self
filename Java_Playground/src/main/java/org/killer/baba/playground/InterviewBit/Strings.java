package org.killer.baba.playground.InterviewBit;

import java.util.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {


    public int isPalindrome(String A) {
        A = A.replaceAll("[^\\w\\d]","");
        int i = 0,j = A.length()-1;
        A = A.toLowerCase();
        System.out.println(A);
        while (i<j){
            if(A.charAt(i)!=A.charAt(j)){
                return 0;
            }
            i++;j--;
        }
        return 1;
    }

    public int lengthOfLastWord(final String A) {
        int ans = 0;
        if(A.isEmpty()){
            return ans;
        }
        String str = A.trim();
        int length = str.length();
        for (int i = length-1; i >= 0; i--) {
            if(str.charAt(i)==' '){
                return ans;
            }
            ans++;
        }
        return ans;
    }

    public String countAndSay(int A) {
        String result = "1";
        if(A==1){
            return result;
        }

        for (int i = 1; i < A; i++) {
            int count = 1;
            String tempString = "";
            for (int j = 0; j < result.length(); j++) {
                if(j < result.length()-1 && result.charAt(j) == result.charAt(j+1)){
                    count++;
                }else {
                    tempString += count+""+result.charAt(j);
                    count=1;
                }
            }
            System.out.println(result);
            result = tempString;
        }
        return result;
    }

    public String solve(String A) {
        String[] strArray = A.trim().split("\\s+");
        StringBuilder ABuilder = new StringBuilder();
        for (int i = strArray.length-1; i >= 0 ; i--) {
            ABuilder.append(strArray[i]).append(" ");

        }
        A = ABuilder.toString().trim();

        return A;
    }

    public String longestCommonPrefix(ArrayList<String> A) {
        if (A == null){
            return null;
        }
        String result = A.getFirst();
        for (int i = 0; i < A.size(); i++) {
            StringBuilder temp = new StringBuilder();
            int size = A.get(i).length();
            System.out.println("size " + size);
            for (int j = 0; j < size; j++) {
                if(j < result.length() && result.charAt(j) == A.get(i).charAt(j)){
                    System.out.println("hello");
                    temp.append(result.charAt(j));
                }else {
                    break;
                }
            }
            System.out.println("temp " + temp);
            result = temp.toString();
        }
        return result;

    }

    public int solveB(String A) {
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o' || A.charAt(i) == 'u' || A.charAt(i) == 'A' || A.charAt(i) == 'E' ||
                    A.charAt(i) == 'I' || A.charAt(i) == 'O' || A.charAt(i) == 'U' ){
                count += (A.length()-i);
            }
        }
        return count%10003;
    }

    public int solveC(String A) {
        String[] strArray = A.trim().split("\\s+");
        int answer=0;
         for (String str : strArray){
             boolean checker = true;
             int i=0,j=str.length()-1;
             while (i<j){
                 if(str.charAt(i) != str.charAt(j)){
                     checker = false;
                     break;
                 }
                 i++;j--;
             }
             if(checker){
                 answer++;
             }
         }
         return answer;
    }

    public int strStr(final String A, final String B) {
        if(A == null || A.isEmpty() || B== null || B.isEmpty()){
            return -1;
        }
        int number = 0;
        for (int i = 0; i < A.length(); i++) {
            int temp = i;
            boolean found = false;
            for (int j = 0; j < B.length(); j++) {
                System.out.println("Number = " + number +" and Value of i :: " +i+" i = " + A.charAt(i) + " and j = " + B.charAt(j));
                if(temp<A.length() && B.charAt(j)==A.charAt(temp)){
                    found=true;
                    temp+=1;
                }else {
                    found = false;
                    break;
                }
            }
            if(found){
                return temp-B.length();
            }
        }
        return -1;
    }

    public int solveD(String A) {
        int longestPalindrome = 0;
        for (int i = 0; i < A.length(); i++) {
            System.out.println("i " + i);
            System.out.println(isItPalindrome(A.substring(0,i)));
            if(isItPalindrome(A.substring(0,i+1))){
                longestPalindrome = A.substring(0,i+1).length();
                System.out.println(longestPalindrome);
            }
        }
        return A.length()-longestPalindrome;
    }

    public boolean isItPalindrome(String A){
        int i = 0,j=A.length()-1;
        while (i<j){
            if(A.charAt(i) != A.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    //Not Verified
    public int isIsomorphic(String str1, String str2){
        int count1=0,count2=0;
        int temp = 0;
        int length = Math.min(str1.length(),str2.length());
        for (int i = 0; i < length-1; i++) {
            if(str1.charAt(i) == str1.charAt(i+1)){
                count1++;
            }else {
                count1 = 0;
            }
            if(str2.charAt(i) == str2.charAt(i+1)){
                count2++;
            }else {
                count2 = 0;
            }
            if(count1!=count2){
                return 0;
            }
        }
        return 1;
    }

    public Long countSalutes(String A) {
        Long count = 0L;
        Long rightCounts = 0L;
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '>'){
                rightCounts++;
            }
            if(A.charAt(i) == '<'){
                count = count + rightCounts;
            }
        }
        return count;
    }

    public ArrayList<Integer> solveE(String A) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            answer.add(0);
        }
        for (char c : A.toCharArray()){
            int temp = c;
            temp -= 97;
            answer.add(temp,answer.get(temp)+1);
        }
        return answer;
    }

    public int solveF(String A) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#%&!$*])[A-Za-z0-9@#%&!$*]{8,15}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher for the password
        Matcher matcher = pattern.matcher(A);

        // Check if the password matches the pattern
        if (matcher.matches()) {
            System.out.println("Password is valid.");
            return 1;
        }
        return 0;
    }

    public String solveG(String A) {
        StringBuilder answer = new StringBuilder();
        for (char c : A.toCharArray()){
            int temp = c;
            if(c<97){
                temp += 32;
            }else {
                temp -= 32;
            }
            c = (char) temp;
            answer.append(c);
        }
        return answer.toString();
    }

    public String addBinary(String A, String B) {
        long num1 = Long.parseLong(A);
        long num2 = Long.parseLong(B);
        long sum, carry;
        do {
            // Calculate the sum without considering the carry
            sum = num1 ^ num2;

            // Calculate the carry
            carry = (num1 & num2) << 1;

            // Update num1 with the sum and num2 with the carry
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return String.valueOf(sum);
    }

    public int solveH(String A) {
        Stack<Character> check = new Stack<>();
        int count = 0;
        for (char c : A.toCharArray()){
            if(c == '('){
                check.push(c);
                count++;
            } else if (c == ')' && check.isEmpty() && check.peek() == '(') {
                check.pop();
                count--;
            } else {
                count++;
            }
        }
        return count;
    }

    public int permuteStrings(String A, String B) {
        Map<Character,Integer> frequency1 = countFrequency(A);
        Map<Character, Integer> frequency2 = countFrequency(B);

        return frequency2.equals(frequency1)?1:0;
    }

    public Map<Character,Integer> countFrequency(String str){
        Map<Character,Integer> counter = new HashMap<>();
        for (Character c : str.toCharArray()){
            counter.put(c,counter.getOrDefault(c,0)+1);
        }
        return counter;
    }

    public String serialize(ArrayList<String> A) {
        if(A==null || A.isEmpty()){
            return "";
        }
        String answer = "";
        for (String str : A){
            int tempLength = str.length();
            answer = answer + str + tempLength + "~";
        }
        return answer;
    }

    public ArrayList<String> deserialize(String A) {
        String[] deserializeArray = A.trim().split("\\d+~");
        return new ArrayList<>(Arrays.asList(deserializeArray));
    }

    public String solveI(String A) {
        StringBuilder answer = new StringBuilder();
        Map<Character,Integer> freqCounter = countFrequencyWithOrder(A);
        for (Character ch : freqCounter.keySet()){
            answer.append(ch).append(freqCounter.get(ch));
        }
        return answer.toString();
    }

    public Map<Character,Integer> countFrequencyWithOrder(String str){
        Map<Character,Integer> counter = new LinkedHashMap<>();
        for (Character c : str.toCharArray()){
            counter.put(c,counter.getOrDefault(c,0)+1);
        }
        return counter;
    }

    public String solveJ(String A, String B) {
        if(A == null || B == null || A.isEmpty() || B.isEmpty()){
            return null;
        }

        int bulls = 0,cows = 0;
        Map<Character,Integer> freqCounter = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == B.charAt(i)){
                bulls++;
            }else{
            freqCounter.put(A.charAt(i),freqCounter.getOrDefault(A.charAt(i),0)+1);}

        }

        for (Character ch : freqCounter.keySet()){
            System.out.println( ch + " : " + freqCounter.get(ch));
        }
        for (int i = 0; i < A.length(); i++) {
            System.out.println(A.charAt(i) + "  " + B.charAt(i));
            if(A.charAt(i) != B.charAt(i) && freqCounter.containsKey(B.charAt(i)) && freqCounter.get(B.charAt(i)) > 0){

                freqCounter.put(B.charAt(i), freqCounter.get(B.charAt(i))-1);
                System.out.println("Match : " + B.charAt(i) + " Map After Updating : " + freqCounter.get(B.charAt(i)));
                cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

}
