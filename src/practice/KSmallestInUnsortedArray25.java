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
        if(k == 0){
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


//method2 using maxHeap
class Solution2 {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if(array == null || array.length == 0 || k == 0){
            return array;
        }
        if(k == 0){
            return new int[0];
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


//method4 using MAXheap
class Solution4 {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if(array == null || array.length == 0 || k == 0){
            return array;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(o1.equals(o2)){
                    return 0;
                }
                return o1 > o2? 1: -1;
            }
        } );

        for(int i = 0; i < array.length; i++){
//            if(maxHeap.peek() == null){
//                maxHeap.offer(array[i]);
//            }
//            else if(array[i] > maxHeap.peek()){
//                maxHeap.poll();
//                maxHeap.offer(array[i]);
//            }else{
//                maxHeap.offer(array[i]);
//            }
            maxHeap.offer(array[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
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


class Solution5 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for(int i = nums.length - 1; i >= nums.length - k + 1; i--){
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize){
        for(int i = heapSize/2; i >= 0; i--){
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize){
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        if(l < heapSize && a[l] > a[largest]){
            largest = l;
        }
        if(r < heapSize && a[r] > a[largest]){
            largest = r;
        }
        if(largest != i){
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }

    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}