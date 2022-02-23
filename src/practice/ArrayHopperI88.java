package practice;

public class ArrayHopperI88 {
}

//dp 1
//TC O(N^2)
//SC O(N)
class ArrayHopperI88bA {
    public boolean canJump(int[] array) {
        boolean[] canJump = new boolean[array.length];
        canJump[0] = true;
        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++){
                if(canJump[j] && array[j] + j >= i){
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[array.length - 1];
    }
}

//dp 2
//TC O(N^2)
//SC O(N)
class ArrayHopperI88bB {
    public boolean canJump(int[] array) {
        // Write your solution here
        if(array.length == 1){
            return true;
        }

        boolean[] canJump = new boolean[array.length];
        for(int i = array.length - 2; i >= 0; i--){
            //two case
            //case 1 array[i] can jump to last index
            // i + array[i] == array.length - 1;

            //case 2 array[i] can back to index which canJump[index] = true;

            if( i + array[i] >= array.length - 1){
                canJump[i] = true;
            } else {
                for(int j = array[i]; j >= 1; j--){
                    if(canJump[i + j] == true){
                        canJump[i] = true;
                        break;
                    }
                }
            }

        }
        return canJump[0];
    }
}


//greedy solution
//TC O(N)
//SC O(1)
class ArrayHopperI88bC {
    public boolean canJump(int[] array) {
        // Write your solution here
        if(array.length == 1){
            return true;
        }
        //max index jumping current steps can reach
        int cur = 0;

        //max index jumping current + 1 steps can reach
        int next = 0;
        for(int i = 0; i < array.length; i++){
            if(i > cur){
                if(cur == next){
                    return false;
                }
                cur = next;
            }
            next = Math.max(next, i + array[i]);
        }
        return true;

    }

    public static void main(String[] args) {
        ArrayHopperI88bC test = new ArrayHopperI88bC();
        int[] array = {2, 1, 1, 0, 2};
        boolean result = test.canJump(array);
        System.out.print(result);
    }
}

// simple greedy solution
//https://leetcode.com/problems/jump-game/solution/
class ArrayHopperI88bD {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}