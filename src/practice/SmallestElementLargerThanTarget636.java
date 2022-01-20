package practice;




public class SmallestElementLargerThanTarget636 {
    public int smallestElementLargerThanTarget(int[] array, int target) {
        // Write your solution here
        if(array == null || array.length == 0){
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int mid = (right - left) / 2 + left;
            if(array[mid] <= target){
                // left = mid;
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        // int close = Math.abs(array[left] - target) <= Math.abs(array[right] - target)? left:right;
        // while(array[close] < target){
        //   if(close > array.length - 1){

        //   }
        //   close++;
        // }
        // return close;

        if(array[left] > target){
            return left;
        }else if ( array[right] > target){
            return right;
        }
        return -1;
    }
}
