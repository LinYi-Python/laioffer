package practice;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI62 {
}


class Solution {
    public List<String> subSets(String set) {
        // Write your solution here.
        //there are three levels of recursion tree.
        //in each level, store whether to put their elemet into subset or not
        //there are two branches
        List<String> result = new ArrayList<String>();
        if(set == null){
            return result;
        }
        char[] input = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        findSubSet(input, 0, sb, result);
        return result;

    }

    private void findSubSet(char[] input, int index, StringBuilder sb, List<String> result){
        if(input.length == index){
            result.add(sb.toString());
            return;
        }
        // pick the element;
        sb.append(input[index]);
        findSubSet(input, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        //not pick this element
        findSubSet(input, index + 1, sb, result);
    }
}