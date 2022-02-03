package practice;

import java.util.ArrayList;
import java.util.List;

public class StringReplace172 {
    public String replace(String input, String s, String t) {
        // Write your solution here
        char[] array = input.toCharArray();
        if(s.length() >= t.length()){
            return replaceShorter(array, s, t);
        }
        return replaceLonger(array, s, t);
    }


    private String replaceShorter(char[] input, String s, String t){
        int slow = 0;
        int fast = 0;
        while(fast < input.length){
            if(fast <= input.length - s.length() && equalSubString(input, fast, s)){
                copySubString(input, slow, t);
                slow += t.length();
                fast += s.length();
            } else {
                input[slow++] = input[fast++];
            }
        }
        return new String(input, 0, slow);
    }

    private String replaceLonger(char[] input, String s, String t){
        List<Integer> matches = getAllMatches(input, s);
        char[] result = new char[input.length + matches.size() * (t.length() - s.length())];

        int lastIndex = matches.size() - 1;
        int fast = input.length - 1;
        int slow = result.length - 1;
        while(fast >= 0){
            if(lastIndex >= 0 && fast == matches.get(lastIndex)){
                copySubString(result, slow - t.length() + 1, t);
                slow -= t.length();
                fast -= s.length();
                lastIndex--;
            } else {
                result[slow--] = input[fast--];
            }
        }
        return new String(result);
    }

    private boolean equalSubString(char[] input, int fromIndex, String s){
        for(int i = 0; i < s.length(); i++){
            if(input[fromIndex + i] != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    private void copySubString(char[] result, int fromIndex, String t){
        for(int i = 0; i < t.length(); i++){
            result[fromIndex + i] = t.charAt(i);
        }
    }

    private List<Integer> getAllMatches(char[] input, String s){
        List<Integer> matches = new ArrayList<Integer>();
        int i = 0;
        while(i <= input.length - s.length()){
            if (equalSubString(input, i, s)) {
                matches.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        return matches;
    }
}
