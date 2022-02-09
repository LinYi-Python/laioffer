package practice;
import java.util.*;
public class SpiralOrderTraverse121 {
}

class SpiralOrderTraverse121A {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        helper(matrix, 0, matrix.length, result);
        return result;
    }

    private void helper(int[][] matrix, int offset, int size, List<Integer> result){
        if(size == 0){
            return;
        }
        if(size == 1){
            result.add(matrix[offset][offset]);
            return;
        }
        for(int i = 0;  i < size - 1; i++){
            result.add(matrix[offset][offset + i]);
        }

        for(int i = 0; i < size - 1; i++){
            result.add(matrix[offset + i][offset + size - 1]);
        }

        for(int i = size - 1; i >= 1; i--){
            result.add(matrix[offset + size - 1][offset + i]);
        }

        for(int i = size - 1; i >= 1; i--){
            result.add(matrix[offset + i][offset]);
        }
        helper(matrix, offset + 1, size - 2, result);
    }
}
