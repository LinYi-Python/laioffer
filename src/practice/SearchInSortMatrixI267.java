package practice;

public class SearchInSortMatrixI267 {
    public int[] search(int[][] matrix, int target) {
        // Write your solution here
        // 2d matrix
        // from 1 - rows; Binary search
        // from 1 - cols; Binanry search

        int[] res = {-1, -1};
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        // int m = matrix.length; // rows
        // int n = matrix[0].length; //cols
        int row = findRows(matrix, target);
        if(row == -1){
            return res;
        }
        int col = findCols(matrix[row], target);
        if(col == -1){
            return res;
        }else{
            res[0] = row;
            res[1] = col;
            return res;
        }
    }

    private int findRows(int[][] matrix, int target){
        int up = 0;
        int down = matrix.length - 1;
        while(up <= down){
            int mid = (down - up) / 2 + up;
            if(matrix[mid][0] > target){
                down = mid - 1;
            }else{
                up = mid + 1; // why, i use up = mid;
            }
        }
        return down;

    }

    private int findCols(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInSortMatrixI267 test = new SearchInSortMatrixI267();
        int[][] matrix = {{1, 2, 3, 4}};
        int target = 4;
        int[] result = test.search(matrix, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}

