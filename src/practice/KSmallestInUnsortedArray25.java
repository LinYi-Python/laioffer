package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestInUnsortedArray25 {
}



//method1
class Solution1 {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if(array == null || array.length == 0){
            return new int[0];
        }
        Arrays.sort(array);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = array[i];
        }
        return res;
    }
}

//Time O(N)
//Space O(1)


//method2
class Solution2 {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if(array == null || array.length == 0 || k == 0){
            return array;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                if(o1.equals(o2)){
                    return 0;
                }
                return o1 > o2? -1: 1;
            }
        } );
        for(int i = 0; i < array.length; i++){
            if(i < k){
                maxHeap.offer(array[i]);
            }else if(array[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }

        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--){
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        int[] array = new int[]{1};
        int k = 0;
        int[] result = test.kSmallest(array, k);
        System.out.println(result.toString());
    }
//Time :O(K + (N - K) logK )
    //Space : O(K)

}



class Solution3 {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if(array.length == 0 || k == 0){
            return new int[0];
        }
        quickSelect(array, 0, array.length - 1, k - 1);
        int[] result = Arrays.copyOf(array, k);
        Arrays.sort(result);
        return result;
    }

    private void quickSelect(int[] array, int left, int right, int target){
        int mid = partition(array, left, right);
        if(mid == target){
            return;
        }else if(target < mid){
            quickSelect(array, left, mid - 1, target);
        }else{
            quickSelect(array, mid + 1, right, target);
        }
    }

    private int partition(int[] array, int left, int right){
        int pivot = array[left];
        int start = left;
        int end = right - 1;
        while(start <= end){
            if(array[start] < pivot){
                start++;
            }else if(array[end] >= pivot){
                end--;
            }else{
                swap(array, start++, end--);
            }
        }
        swap(array, start, right);
        return start;
    }

    private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        int[] array = new int[]{1, 2, 3, 4};
        int k = 2;
        int[] result = test.kSmallest(array, k);
        System.out.println(result.toString());
    }

}
