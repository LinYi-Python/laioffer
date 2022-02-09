package practice;
import java.util.*;
public class SpiralOrderTraverse122 {
}

// also in https://leetcode.com/problems/spiral-matrix/solution/ leetcode 54

//Approach 1: Set Up Boundaries
class SpiralOrderTraverse122A {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        if(m == 0){
            return list;
        }
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = m - 1;


        while(left < right && up < down){
            for(int i = left; i <= right; i++){
                list.add(matrix[up][i]);
            }

            for(int i = up + 1; i <= down - 1; i++){
                list.add(matrix[i][right]);
            }

            for(int i = right; i >= left; i--){
                list.add(matrix[down][i]);
            }

            for(int i = down - 1; i >= up + 1; i--){
                list.add(matrix[i][left]);
            }

            left++;
            right--;
            up++;
            down--;
        }

        if(left > right || up > down){
            return list;
        }
        //still have one column
        if(left == right){
            for(int i = up; i <= down; i++){
                list.add(matrix[i][left]);
            }
        } else { // still have one row
            for(int i = left; i <= right; i++){
                list.add(matrix[up][i]);
            }
        }
        return list;

    }
}

//TC O(MN)
//SC O(1)

//Approach 2: Mark Visited Elements
class SpiralOrderTraverse122B {
    public List<Integer> spiralOrder(int[][] matrix) {
        int VISITED = 101;
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Four directions that we will move: right, down, left, up.
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Initial direction: moving right.
        int currentDirection = 0;
        // The number of times we change the direction.
        int changeDirection = 0;
        // Current place that we are at is (row, col).
        // row is the row index; col is the column index.
        int row = 0;
        int col = 0;
        // Store the first element and mark it as visited.
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        matrix[0][0] = VISITED;
        while (changeDirection < 2) {
            while (row + directions[currentDirection][0] >= 0 &&
                    row + directions[currentDirection][0] < rows &&
                    col + directions[currentDirection][1] >= 0 &&
                    col + directions[currentDirection][1] < columns &&
                    matrix[row + directions[currentDirection][0]]
                            [col + directions[currentDirection][1]] != VISITED) {
                // Reset this to 0 since we did not break and change the direction.
                changeDirection = 0;
                // Calculate the next place that we will move to.
                row = row + directions[currentDirection][0];
                col = col + directions[currentDirection][1];
                result.add(matrix[row][col]);
                matrix[row][col] = VISITED;
            }
            // Change our direction.
            currentDirection = (currentDirection + 1) % 4;
            // Increment change_direction because we changed our direction.
            changeDirection++;
        }
        return result;
    }
}