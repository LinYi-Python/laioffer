package practice;
import java.util.*;
public class CombinationsOfCoins73 {
}


class CombinationsOfCoins73A {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(target, coins, 0, curr, result);
        return result;
    }

    private void dfs(int target, int[] coins, int index, List<Integer> curr, List<List<Integer>> result){
        if(index == coins.length - 1){
            if(target % coins[coins.length - 1] == 0){
                curr.add(target / coins[coins.length - 1]);
                result.add(new ArrayList<Integer>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }

        int max = target / coins[index];
        for(int i = 0; i <= max; i++){
            curr.add(i);
            dfs(target - i * coins[index], coins, index + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
