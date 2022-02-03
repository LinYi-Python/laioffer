package practice;
import java.util.*;

public class AllPermutations64 {
}


class AAllPermutations64 {
    public List<String> permutations(String input) {
        // Write your solution here
        List<String> result = new ArrayList<String>();
        if(input == null){
            return result;
        }
        char[] inputChar = input.toCharArray();
        dfs(inputChar, 0, result);
        return result;
    }

    private void dfs(char[] array, int index, List<String> result){
        if(index == array.length){
            result.add(new String(array));
            return;
        }
        for(int i = index; i < array.length; i++){
            swap(array, index, i);
            dfs(array, index + 1, result);
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int index1, int index2){
        char temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
