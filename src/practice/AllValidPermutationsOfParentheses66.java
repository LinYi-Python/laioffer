package practice;

import java.util.ArrayList;
import java.util.List;

public class AllValidPermutationsOfParentheses66 {
}

class AAllValidPermutationsOfParentheses66 {
    public List<String> validParentheses(int n) {
        // Write your solution here
        //there are 2 * N level
        //in each level, the level will add one of its parenthess.
        //there are two branch. add whether or not.
        //vail : number of left parenthese >= number of right one
        // if false, just return using recrusion here.
        List<String> result = new ArrayList<String>();
        char[] input = new char[n * 2];
        dfs(input, n, n, 0, result);
        return result;
    }

    private void dfs(char[] curr, int l, int r, int index, List<String> result){
        if(l == 0 && r == 0){
            result.add(new String(curr));
            return;
        }
        if(l > 0){
            curr[index] = '(';
            dfs(curr, l - 1, r, index + 1, result);
        }

        if(r > l){
            curr[index] = ')';
            dfs(curr, l, r - 1, index + 1, result);
        }
    }
}
