package practice;

interface Dictionary {
   public Integer get(int index);
  }

public class SearchInUnknownSizedSortedArray20 {
    public int search(Dictionary dict, int target) {
        // Write your solution here
        if(dict == null){
            return -1;
        }
        int left = 0;
        int right = 1;
        while(dict.get(right) != null && dict.get(right) < target){
            left = right;
            right = 2 * right;
        }
        return binarySearch(dict, target, left, right);
    }

    public int binarySearch(Dictionary dict, int target, int left, int right){
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(dict.get(mid) == null || dict.get(mid) > target){
                right = mid - 1;
            }else if(dict.get(mid) < target){
                right = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
