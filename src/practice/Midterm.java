package practice;
import java.util.*;

public class Midterm{

}


//problem1
//Find all valid ways of putting N Queens on an N * N chessboard
// so that no two Queens can attack each other (two queens can
// attack each other if they are on the same row/column or same diagonal line).
//
//You can define your own way of how to print the solution, e.g.
// using a size N array/List to record which column the queen occupies on each row.


class Test1{
    public List<List<Integer>> nQueens(int n){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(n, curr, result);
        return result;
    }

    private void helper(int n, List<Integer> curr, List<List<Integer>> result){
        //base case
        if(curr.size() == n){
            result.add(new ArrayList<Integer>(curr));
            return;
        }

        for(int i = 0; i < n; i++){
            if(isValid(curr, i)){
                curr.add(i);
                helper(n, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> curr, int col){
        int row = curr.size();
        for(int i = 0; i < row; i++){
            if(curr.get(i) == col || Math.abs(curr.get(i) - col) == row - i){
                return false;
            }
        }
        return true;
    }
}


//TC O(N!)
//SC O(N)


//Given a binary tree in which each node contains an int number.
//
//Find the maximum possible sum from any leaf node to another leaf node.
//
//The maximum sum path may or may not go through root.
//
//Expected time complexity is O(n).

class TreeNode{
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}


class Test2{
    public int maxPathSum(TreeNode root){
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        dfs(root, maxSum);
        return maxSum[0];
    }

    private int dfs(TreeNode root, int[] maxSum){
        //base case
        if(root == null){
            return 0;
        }
        int leftSum = dfs(root.left, maxSum);
        int rightSum = dfs(root.right, maxSum);
        int currSum = leftSum + rightSum + root.key;
        if(root.left != null && root.right != null && currSum > maxSum[0]){
            maxSum[0] = currSum;
        }

        if(root.left == null){
            return rightSum + root.key;
        } else if(root.right == null){
            return leftSum + root.key;
        } else {
            return Math.max(leftSum, rightSum) + root.key;
        }
    }

}


//TC O(N)
//SC O(Height)

//Given a string, a partitioning of the string is a palindrome partitioning if every partition is a palindrome.
//
//For example, “aba |b | bbabb |a| b| aba” is a palindrome partitioning of “ababbbabbababa”.
//
//Determine the fewest cuts needed for palindrome partitioning of a given string.
//
//For example,
//
//minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a | babbbab | b | ababa”.
//
//If a string is palindrome, then minimum 0 cuts are needed.
//
//Return the minimum cuts.

class Test3A {
    public int minCuts(String input) {
        if (input == null || input.length() < 2) {
            return 0;
        }

        int len = input.length();
        int[] cutCnt = new int[input.length() + 1];

        cutCnt[0] = 0;
        cutCnt[1] = 0;

        for (int i = 2; i <= len; ++i) {
            int minCut = Integer.MAX_VALUE;

            for (int j = 0; j < i; ++j) {
                if (isPalindrome(input, j, i - 1)) {
                    minCut = j == 0 ? 0 : Math.min(minCut, cutCnt[j] + 1);
                }
            }

            cutCnt[i] = minCut;
        }

        return cutCnt[len];
    }

    private boolean isPalindrome(String input, int i, int j) {
        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }

            ++i;
            --j;
        }

        return true;
    }
}

// TC: O(n^3); SC: O(n)

class Test3B{
    public int minCut(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[] minCut = new int[len];
        boolean[][] isPa = new boolean[len][len];
        // whether string.substring(i, j + 1) is palindrome;

        for(int i = 0; i < len; i++){
            minCut[i] = i; // i is max value for mincut in s.subString(0, i + 1)

            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j < 3 || isPa[i - 1][j + 1] == true)){
                    isPa[i][j] = true;
                }

                if(j == 0){
                    minCut[i] = 0;
                } else {
                    minCut[i] = Math.min(minCut[i], minCut[j - 1] + 1);
                }
            }
        }
        return minCut[len - 1];
    }
}

// TC: O(n^2); SC: O(n^2)


class Test3C {
    public int minCuts(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        int len = input.length();
        int[] cutCnt = new int[len + 1];

        for (int i = 0; i <= len; ++i) {
            cutCnt[i] = i - 1;
        }

        for (int i = 0; i < len; ++i) {
            for (int j = 0; i - j >= 0 && i + j < len && input.charAt(i - j) == input.charAt(i + j); ++j) {
                cutCnt[i + j + 1] = Math.min(cutCnt[i + j + 1], cutCnt[i - j] + 1);
            }

            for (int j = 0; i - j - 1 >= 0 && i + j < len && input.charAt(i - j - 1) == input.charAt(i + j); ++j) {
                cutCnt[i + j + 1] = Math.min(cutCnt[i + j + 1], cutCnt[i - j - 1] + 1);
            }
        }

        return cutCnt[len];
    }
}
// TC: O(n^2); SC: O(n)
//Given an integer n, print/output all possible ways of writing n
// pairs of if blocks with correct indentation.
//
//Say n=2 output should be
//
//
//
//if {
//
//}
//
//if {
//
//}
//
//<newline>
//
//if {
//
//  if {// here should exist two spaces before each inner block
//
//  }
//
//}

class Test4{
    public void correctPairs(int n ){
        List<String> result = new ArrayList<>();
        char[] input = new char[n * 2];
        dfs(input, n, n, result, 0);
        printer(result);
    }

    private void dfs(char[] input, int l, int r, List<String> result, int index){
        //base case
        if(l == 0 && r == 0){
            result.add(new String(input));
            return;
        }
        //add {
        if(l > 0){
            input[index] = '{';
            dfs(input, l - 1, r, result, index + 1);
        }

        // add }
        if(r > l){
            input[index] = '}';
            dfs(input, l, r - 1, result, index + 1);
        }
    }

    private void printer(List<String> result){
        for(int i = 0; i < result.size(); i++){
            int space = 0;
            char[] curr = result.get(i).toCharArray();
            for(int j = 0; j < curr.length; j++){
                if(curr[j] == '{'){
                    printSpace(space);
                    System.out.println("if {");
                    space += 2;
                } else {
                    space -= 2;
                    printSpace(space);
                    System.out.println("}");
                }
            }
            System.out.println(""); // new line
        }
    }

    private void printSpace(int n){
        while(n > 0){
            System.out.print(" ");
            n--;
        }
    }


    public static void main(String[] args) {
        Test4 test = new Test4();
        test.correctPairs(3);

    }
}
//Time: O(2^n) Space: O(N)



class PrintAllBlock {
    /**
     * dfs method that keep generate the valid string of { and }
     * @param leftRemain
     * @param rightRemain
     * @param index
     * @param curr
     */
    private void helper(int leftRemain, int rightRemain, int index, char[] curr) {
        // base case
        if (leftRemain == 0 && rightRemain == 0) {
            printBlock(curr);
            return;
        }
        if (leftRemain > 0) {
            curr[index] = '{';
            helper(leftRemain - 1, rightRemain, index + 1, curr);
        }
        if (rightRemain > leftRemain) {
            curr[index] = '}';
            helper(leftRemain, rightRemain - 1, index + 1, curr);
        }
    }
    /**
     * print the space for indentation
     * @param n
     */
    private void printSpace(int n) {
        while (n > 0) {
            System.out.print(" ");
            n--;
        }
    }
    /**
     * print the corrected format from valid { and } string
     * @param curr
     */
    private void printBlock(char[] curr) {
        int space = 0;
        for (int i = 0; i < curr.length; ++i) {
            if (curr[i] == '{') {
                printSpace(space);
                System.out.println("if {");
                space += 2;
            } else {
                space -= 2;
                printSpace(space);
                System.out.println("}");
            }
        }
        System.out.println();
    }
    /**
     * driver method: takes in a number represents the number of if { and } that it will have
     * @param n
     */
    public void printBlocks(int n) {
        if (n <= 0) return;
        char[] curr = new char[2 * n];
        helper(n, n, 0, curr);
    }


    public static void main(String[] argc) {
        PrintAllBlock s = new PrintAllBlock();
        s.printBlocks(3);
    }
}