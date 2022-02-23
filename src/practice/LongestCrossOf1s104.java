package practice;

import apple.applescript.AppleScriptEngine;

public class LongestCrossOf1s104 {
}

class LongestCrossOf1s104A {
    public int largest(int[][] matrix) {
        // Write your solution here
        // 0 1 1 1 0 1 1 0
        // 0 1 2 3 0 1 2 0
        // linear scan from left - right, right - left, up - down, down - up
        int n = matrix.length;
        if(n == 0){
            return 0;
        }
        int m = matrix[0].length;
        if(m == 0){
            return 0;
        }
        //leftUp record the longest length from left and up
        int[][] leftUp = leftUp(matrix, n, m);
        //rightDown record the longest length from right and down
        int[][] rightDown = rightDown(matrix, n, m);

        return merge(leftUp, rightDown, n, m);
    }
    //j
    //        i xxx
    //          xxx
    //

    private int[][] leftUp(int[][] matrix, int n, int m){
        int[][] left = new int[n][m];
        int[][] up = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 && j == 0){
                        up[i][j] = 1;
                        left[i][j] = 1;
                    } else if(i == 0){
                        up[i][j] = 1;
                        left[i][j] = left[i][j - 1] + 1;
                    } else if(j == 0){
                        left[i][j] = 1;
                        up[i][j] = up[i - 1][j] + 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = up[i - 1][j] + 1;
                    }
                }
            }
        }
        merge(left, up, n, m);
        return left;
    }

    private int[][] rightDown(int[][] matrix, int n, int m){
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(matrix[i][j] == 1){
                    if(i == n - 1 && j == m - 1){
                        right[i][j] = 1;
                        down[i][j] = 1;
                    } else if(i == n - 1){
                        down[i][j] = 1;
                        right[i][j] = right[i][j + 1] + 1;
                    } else if(j == m - 1){
                        right[i][j] = 1;
                        down[i][j] = down[i + 1][j] + 1;
                    } else {
                        right[i][j] = right[i][j + 1] + 1;
                        down[i][j] = down[i + 1][j] + 1;
                    }
                }
            }
        }
        merge(right, down, n ,m);
        return right;
    }

    private int merge(int[][] leftUp, int[][] rightDown, int n, int m){
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
                result = Math.max(result, leftUp[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCrossOf1s104A test = new LongestCrossOf1s104A();
        int[][] matrix = {{1,1,1,1,1},{1,0,0,1,1},{1,1,1,1,1},{1,1,1,1,0},{0,0,0,1,1}};
        int result = test.largest(matrix);
        System.out.println(result);
    }
}


//TC O(MN)
//SC O(MN)


//class LongestCrossOf1s104B {
//    public int largest(int[][] matrix) {
//        if (matrix == null) {
//            return -1;
//        }
//        int[][] M1 = new int[matrix.length][matrix[0].length]; //left -> right
//        int[][] M2 = new int[matrix.length][matrix[0].length]; //right -> left
//        int[][] M3 = new int[matrix.length][matrix[0].length]; //up -> down
//        int[][] M4 = new int[matrix.length][matrix[0].length]; //down -> up
//        int cur1 = 0;
//        int cur2 = 0;
//        int cur3 = 0;
//        int cur4 = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0) {
//                    cur1 = 0;
//                    M1[i][j] = 0;
//                }else {
//                    cur1++;
//                    M1[i][j] = cur1;
//                }
//            }
//            for (int j = matrix[0].length - 1; j >= 0; j--) {
//                if (matrix[i][j] == 0) {
//                    cur2 = 0;
//                    M2[i][j] = 0;
//                }else {
//                    cur2++;
//                    M2[i][j] = cur2;
//                }
//            }
//        }
//        for (int j = 0; j < matrix[0].length; j++) {
//            for (int i = 0; i < matrix.length; i++) {
//                if (matrix[i][j] == 0) {
//                    cur3 = 0;
//                    M3[i][j] = 0;
//                }else {
//                    cur3++;
//                    M3[i][j] = cur3;
//                }
//            }
//            for (int i = matrix.length - 1; i >= 0; i--) {
//                if (matrix[i][j] == 0) {
//                    cur4 = 0;
//                    M4[i][j] = 0;
//                }else {
//                    cur4++;
//                    M4[i][j] = cur4;
//                }
//            }
//        }
//        int largest = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                largest = Math.max(largest, Math.min(Math.min(M1[i][j], M2[i][j]), Math.min(M3[i][j], M4[i][j])));
//            }
//        }
//        return largest;
//    }
//
//    public static void main(String[] args) {
//        LongestCrossOf1s104B test = new LongestCrossOf1s104B();
//        int[][] matrix = {{1,1,1,1,1},{1,0,0,1,1},{1,1,1,1,1},{1,1,1,1,0},{0,0,0,1,1}};
//        int result = test.largest(matrix);
//        System.out.println(result);
//    }
//}
//matrix         m1 left         m1 up      m1 right       m1 down
// 1 1 1 1 1    1 2 3 4 5     1 1 1 1 1     5 4 3 2 1     4 1 1 5 3
// 1 0 0 1 1    1 0 0 1 2     2 0 0 2 2     1 0 0 2 1     3 0 0 4 2
// 1 1 1 1 1    1 2 3 4 5     3 1 1 3 3     5 4 3 2 1     2 2 2 3 1
// 1 1 1 1 0    1 2 3 4 0     4 2 2 4 0     4 3 2 1 0     1 1 1 2 0
// 0 0 0 1 1    0 0 0 1 2     0 0 0 5 1     0 0 0 2 1     0 0 0 1 1




class LongestCrossOf1s104C {
    public int largest(int[][] matrix) {
        if (matrix == null) {
            return -1;
        }
        int[][] M1 = new int[matrix.length][matrix[0].length]; //left -> right
        int[][] M2 = new int[matrix.length][matrix[0].length]; //right -> left
        int[][] M3 = new int[matrix.length][matrix[0].length]; //up -> down
        int[][] M4 = new int[matrix.length][matrix[0].length]; //down -> up
        int cur1 = 0;
        int cur2 = 0;
        int cur3 = 0;
        int cur4 = 0;
        //left
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    cur1 = 0;
                    M1[i][j] = 0;
                }else if(j == 0){
                    cur1 = 1;
                    M1[i][j] = cur1;
                }else{
                    cur1++;
                    M1[i][j] = cur1;
                }
            }
            //right
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    cur2 = 0;
                    M2[i][j] = 0;
                }else if(j == matrix[0].length - 1){
                    cur2 = 1;
                    M2[i][j] = cur2;
                }else {
                    cur2++;
                    M2[i][j] = cur2;
                }
            }
        }
        //up
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == 0) {
                    cur3 = 0;
                    M3[i][j] = 0;
                }else if(i == 0){
                    cur3 = 1;
                    M3[i][j] = cur3;
                }else{
                    cur3++;
                    M3[i][j] = cur3;
                }
            }
            //down
            for (int i = matrix.length - 1; i >= 0; i--) {
                if (matrix[i][j] == 0) {
                    cur4 = 0;
                    M4[i][j] = 0;
                }else if(i == matrix.length - 1){
                    cur4 = 1;
                    M4[i][j] = cur4;
                } else {
                    cur4++;
                    M4[i][j] = cur4;
                }
            }
        }
        int largest = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                largest = Math.max(largest, Math.min(Math.min(M1[i][j], M2[i][j]), Math.min(M3[i][j], M4[i][j])));
            }
        }
        return largest;
    }
}