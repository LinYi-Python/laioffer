package practice;

/**
 * @ClassName LargestSquareOfMatches638
 * @Description TODO
 * @Author LinPython
 * @Date 2/22/22 21:35
 * @Version 1.0
 **/
public class LargestSquareOfMatches638 {

}

class LargestSquareOfMatches638A {
    public int largestSquareOfMatches(int[][] matrix) {
        // Write your solution here
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int result = 0;
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(hashRight(matrix[i][j])){
                    right[i][j] = right[i][j + 1] + 1;
                }
                if(hashDown(matrix[i][j])){
                    down[i][j] = down[i + 1][j] + 1;
                }
                if(hashBoth(matrix[i][j])){
                    for(int maxLength = Math.min(right[i][j], down[i][j]); maxLength >= 1; maxLength--){
                        if(right[i + maxLength][j] >= maxLength && down[i][j + maxLength] >= maxLength) {
                            result = Math.max(result, maxLength);
                            break;
                        }
                    }
                }

            }
        }
        return result;
    }

    private boolean hashRight(int value){
//        return value == 1? true: false;

         return (value &0b1) != 0;
    }
    // 1  1
    // 2  10
    // 3  11
    // for & 0b1
    // 1 & 0b1 = 1
    // 3 & 0b1 = 1

    //for & 0b10
    // 2 & 0b10 = 1
    // 3 & 0b10 = 1



    private boolean hashDown(int value){
//        return value == 2? true: false;

         return (value &0b10) != 0;
    }

    private boolean hashBoth(int value){
//        return value == 3? true: false;

         return value == 0b11;
    }


    public static void main(String[] args) {
        LargestSquareOfMatches638A test = new LargestSquareOfMatches638A();
        int[][] matrix = {{3, 1, 1, 3, 0, 1, 1, 0},

                {2, 0, 0, 2, 0, 0, 0, 0},

                {3, 1, 3, 0, 0, 0, 0, 0},

                {2, 0, 2, 0, 0, 0, 0, 0},

                {1, 1, 0, 0, 0, 0, 0, 0}};
        int result = test.largestSquareOfMatches(matrix);
        System.out.println(result);
    }
}

//TC O(M * N * min(N, M))
//SC O(N * M)


//java 进制符号
//
//Decimal number format 十
//Octal number format 八
//Hexadecimal number format 十六
//Binary number format 二


//// 021  is in octal number format, not  in  decimal
//int num1 = 021;

//The following are the examples of using int literals in hexadecimal format:
//
//int num1 = 0x123;
//int num2 = 0xdecafe;
//int num3 = 0x1A2B;
//int num4 = 0X0123;

//The following are examples of using int literals in the binary number format:
//
//int num1 = 0b10101;
//int num2 = 0b00011;
//int num3 = 0b10;
//int num4 = 0b00000010;

//System.out.println(0b101);//二进制:5  （0b开头的）
//System.out.println(0e1011);//0.0
//System.out.println(011);//八进制:9   (0开头的)
//System.out.println(11);//十进制:11
//System.out.println(0x11C);//十六进制:284   （0x开头的）
//
//System.out.printf("%010x\n",7);//0000000007   按10位十六进制输出，向右靠齐，左边用0补齐
//System.out.printf("%010o\n",13);//0000000015    按10位八进制输出，向右靠齐，左边用0补齐
//
//System.out.printf("%x\n",7);//7   按16进制输出
//System.out.printf("%o\n",13);//15   按8进制输出
//
//System.out.println(Integer.toBinaryString(11));//1011 二进制


class LargestSquareOfMatches638B  {
    public int largestSquareOfMatches(int[][] matrix) {
        // Write your solution here
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int result = 0;
        int[][] right = new int[n][m];
        int[][] down = new int[n][m];
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(hashRight(matrix[i][j])){
                    right[i][j] = right[i][j + 1] + 1;
                }
                if(hashDown(matrix[i][j])){
                    down[i][j] = down[i + 1][j] + 1;
                }
                if(hashBoth(matrix[i][j])){
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;
                    for(int maxLength = Math.min(right[i][j], down[i][j]); maxLength >= 1; maxLength--){
                        if(right[i + maxLength][j] >= maxLength && down[i][j + maxLength] >= maxLength) {
                            result = Math.max(result, maxLength);
                            break;
                        }
                    }
                }

            }
        }
        return result;
    }

    private boolean hashRight(int value){
        return value == 1? true: false;
        // return (value &0b1) != 0;
    }

    private boolean hashDown(int value){
        return value == 2? true: false;
        // return (value &0b10) != 0;
    }

    private boolean hashBoth(int value){
        return value == 3? true: false;
        // return value == 0b11;
    }
}

//TC O(M * N * min(N, M))
//SC O(N * M)