package practice;


import java.sql.PreparedStatement;

public class KclosestInSortedArray19 {
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        //first find the closed one using binary search//
        //expand from center with comparing left and right value

        //step1
        if(array == null || array.length == 0 ){
            return array;
        }
        if(k == 0){
            return new int[0];
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){// stop when left neighbor right
            int mid = (right - left) / 2 + left;
            if(array[mid] <= target){
                left = mid;
            }else{
                right = mid;
            }
        }
//        int center = left;
//        if(array[right] <= target){
//            center = right;
//        }else if(array[left] <= target){
//            center = left;
//        }


        int center = Math.abs(array[left] - target) <= Math.abs(array[right] - target)? left:right;

        //step2
        int[] result = new int[k];
        result[0] = array[center];
        int leftIndex = center - 1;
        int rightIndex = center + 1;
        for(int i = 1; i < k; i++){

            if(leftIndex < 0 && rightIndex <= array.length - 1){
                result[i] = array[rightIndex];
                rightIndex++;
            }else if(rightIndex > array.length - 1 && leftIndex >= 0){
                result[i] = array[leftIndex];
                leftIndex--;
            }else if(leftIndex >= 0 && rightIndex <= array.length - 1){
                if(Math.abs(array[leftIndex] - target) <= Math.abs(array[rightIndex] - target)){
                    result[i] = array[leftIndex];
                    leftIndex--;
                }else{
                    result[i] = array[rightIndex];
                    rightIndex++;
                }
            }
        }

//        int[] result = new int[k];
//        left = center;
//        right = left + 1;
//        for(int i = 0; i < k; i++){
//            if(right >= array.length || (left >= 0 && target - array[left] <= array[right] - target)){
//                result[i] = array[left--];
//            }else{
//                result[i] = array[right++];
//            }
//        }

        return result;
    }


    public static void main(String[] args) {
        KclosestInSortedArray19 test = new KclosestInSortedArray19();
        int[] array = {1,3,3,6,9,9,12,15};
        int target = 10;
        int k = 5;
        int[] result = test.kClosest(array, target, k);
        System.out.println(result.toString());
    }
}

