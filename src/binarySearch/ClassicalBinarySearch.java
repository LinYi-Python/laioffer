package binarySearch;

public class ClassicalBinarySearch {
    public int binarySearch(int[] array, int target) {
        // Write your solution here
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ClassicalBinarySearch test = new ClassicalBinarySearch();
        int[] array =  new int[]{1};
        int target = 2;
        int result = test.binarySearch(array, target);
        System.out.println(result);
    }
}


//14. Classical Binary Search
