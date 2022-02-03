package practice;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII65 {
    public List<String> permutations(String input) {
        // Write your solution here
        List<String> result = new ArrayList<>();
        if (input == null){
            return result;
        }
        char[] array = input.toCharArray();
        dfs(array, 0, result);
        return result;
    }
    //                   abca
    //   1       abca    baca   cbaa.  abcaX
    //         /  / \
    //   2  abca  acba aacb
    //       /\    /\    /\
    //. 3 abca abac acba acab  aacb aabc

    private void dfs(char[] array, int index, List<String> result){
        //base case
        if(index == array.length){
            result.add(new String(array));
            return;
        }
        Set<Character> used = new HashSet<>();
        for(int i = index; i < array.length; i++){
            if(used.add(array[i])){
                swap(array, index, i);
                dfs(array, index + 1, result);
                swap(array, index, i);
            }
        }
    }

    private void swap(char[] array, int index1, int index2){
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        AllPermutationsII65 test = new AllPermutationsII65();
        String input = "aba";
        List<String> result = test.permutations(input);
        System.out.println(result.toString());
    }
}
