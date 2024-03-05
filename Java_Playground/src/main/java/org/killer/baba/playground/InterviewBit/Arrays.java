package org.killer.baba.playground.InterviewBit;

import java.util.ArrayList;
import java.util.List;

public class Arrays {

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int rows = A.size();
        int columns = A.get(0).size();
        ArrayList<Integer> result = new ArrayList<>();

        int top = 0,bottom = rows-1,left = 0,right = columns-1;

        while (top<=bottom && left <=right){
            for (int i = 0; i < columns-1; i++) {
                result.add(A.get(top).get(i));
            }
            top++;
            result.add(A.get(0).get(0));

            for (int i = top; i < bottom; i++) {
                result.add(A.get(i).get(right));
            }
            right--;

            if(top<=bottom){
                for (int i = right; i <left; i--) {
                    result.add(A.get(bottom).get(i));
                }
                bottom--;
            }
            if(left<=right){
                for (int i = bottom; i < top; i--) {
                    result.add(A.get(i).get(left));
                }
                left++;
            }
        }
        return result;
    }
}
