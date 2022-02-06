package practice;

public class LongestSubarrayContainsOnly1s625 {
    public int longestConsecutiveOnes(int[] nums, int k) {
        // Write your solution here
        int slow = 0;
        int fast = 0;
        int count = 0;
        int longest = 0;
        while (fast < nums.length){
            if(nums[fast] == 1){
                longest = Math.max(longest, ++fast - slow);
            } else if(count < k){
                count++;
                longest = Math.max(longest, ++fast - slow);
            } else if(nums[slow++] == 0){
                count--;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubarrayContainsOnly1s625 test = new LongestSubarrayContainsOnly1s625();
        int[] nums = {1,1,0,0,1,1,1,0,0,0};
        int k = 2;
        int result = test.longestConsecutiveOnes(nums, k);
        System.out.println(result);
    }
}
