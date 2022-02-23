package practice;
//same as 1139. Largest 1-Bordered Square
/**
 * @ClassName LargestSquareSurroundedByOne637
 * @Description TODO
 * @Author Yi Lin
 * @Date 2/22/22 00:47
 * @Version 1.0
 **/
public class LargestSquareSurroundedByOne637 {

}


class LargestSquareSurroundedByOne637A {
    public int largestSquareSurroundedByOne(int[][] matrix) {
        // Write your solution here
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    left[i + 1][j + 1] = left[i + 1][j] + 1;
                    up[i + 1][j + 1] = up[i][j + 1] + 1;
                    for(int maxLength = Math.min(left[i + 1][j + 1], up[i + 1][j + 1]); maxLength >= 1; maxLength--){
                        if(left[i + 2 - maxLength][j + 1] >= maxLength && up[i + 1][j + 2 - maxLength] >= maxLength){
                            result = Math.max(result, maxLength);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestSquareSurroundedByOne637A test = new LargestSquareSurroundedByOne637A();
        int[][] matrix = {{1, 0, 1, 1, 1},

                {1, 1, 1, 1, 1},

                {1, 1, 0, 1, 0},

                {1, 1, 1, 1, 1},

                {1, 1, 1, 0, 0}};
        int result = test.largestSquareSurroundedByOne(matrix);
        System.out.print(result);
    }
}

//TC O(MN * MIN(N, M))
//SC O(MN)


class LargestSquareSurroundedByOne637B {
    public int largestSquareSurroundedByOne(int[][] matrix) {
        // Write your solution here
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][][] dp = new int[m + 1][n + 1][2];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i - 1][j - 1] == 0){
                    continue;
                }
                dp[i][j][0] = dp[i][j - 1][0] + 1; // horizon
                dp[i][j][1] = dp[i - 1][j][1] + 1; // veritcal

            }
        }
        int maxSide = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int curSide = Math.min(dp[i][j][0], dp[i][j][1]);
                if(curSide <= maxSide) {
                    continue;
                }
                for(; curSide > maxSide; curSide--) {
                    if(dp[i][j - curSide + 1][1] >= curSide && dp[i - curSide + 1][j][0] >= curSide) {
                        maxSide = curSide;
                        break;
                    }
                }
            }
        }
        return maxSide;
    }
}

//TC O(MN * MIN(N, M))
//SC O(MN)