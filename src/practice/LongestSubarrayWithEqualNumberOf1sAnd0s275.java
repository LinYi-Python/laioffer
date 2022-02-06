package practice;
import java.util.*;
public class LongestSubarrayWithEqualNumberOf1sAnd0s275 {
}

//https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
//Brute Force
class LongestSubarrayWithEqualNumberOf1sAnd0s275A {
    public int longest(int[] array) {
        // Write your solution here
        if(array == null || array.length <= 1){
            return 0;
        }
        int sum = 0;
        int maxSize = -1;
        int startIndex = 0;
        int endIndex = 0;
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            sum = (array[i] == 0? -1 : 1);

            for(int j = i + 1; j < n; j++){
                if (array[j] == 0) {
                    sum += -1;
                } else {
                    sum += 1;
                }

                if (sum == 0 && maxSize < j - i + 1){
                    maxSize = j - i + 1;
                    startIndex = i;
                }
            }
        }

        endIndex = startIndex + maxSize - 1;
        if(maxSize == -1){
            return 0;
        } else {
            return maxSize;
        }
    }
}

//TC O(N ^ 2)
//SC O(1)


//HashMap
class LongestSubarrayWithEqualNumberOf1sAnd0s275B {
    public int longest(int[] array) {
        // Write your solution here
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;
        int startIndex = 0;
        int endIndex = 0;

        for(int i = 0; i < n; i++){
            array[i] = (array[i] == 0? -1 : 1);
        }

        for(int i = 0; i < n; i++){
            sum += array[i];

            //to handle sum = 0 at last index
            if(sum == 0){
                maxLen = i + 1;
                endIndex = i;
            }

            // If this sum is seen before,
            // then update max_len if required
            if(map.containsKey(sum)){
                if(maxLen < i - map.get(sum)){
                    maxLen = i - map.get(sum);
                    endIndex = i;
                }
            } else {
                map.put(sum, i);
            }
        }

        for(int i = 0; i < n; i++){
            array[i] = (array[i] == -1? 0: 1);
        }

        startIndex = endIndex - maxLen + 1;
        return maxLen;

    }
}
//TC:O(N)
//SC:O(N)


