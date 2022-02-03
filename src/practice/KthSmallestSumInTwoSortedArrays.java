package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestSumInTwoSortedArrays {
    public int kthSum(int[] a, int[] b, int k) {
        // Write your solution here
        //using greedy algorithm here
        if(a == null || b == null || k == 0){
            return -1;
        }

        //MaxHeap
        // PriorityQueue<pair> pq = new PriorityQueue<>((x1, x2) -> x2.sum - x1.sum);
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            public int compare(Pair x1, Pair x2){
                if(x1.sum == x2.sum){
                    return 0;
                }
                return x1.sum > x2.sum ? -1 : 1;
            }
        });
        int n = a.length;
        int m = b.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                Pair cur = new Pair(a[i], b[j], a[i] + b[j]);
                if(pq.size() < k){
                    pq.offer(cur);
                } else {
                    if(cur.sum < pq.peek().sum){
                        pq.poll();
                        pq.offer(cur);
                    }else break;
                }
            }
        }

//        while(pq.size() > k){
//            pq.poll();
//        }
        Pair result = pq.peek();

        return result.sum;
    }

    class Pair{
        int fir, sec, sum;
        Pair(int i, int j, int s){
            fir = i;
            sec = j;
            sum = s;
        }
    }
}



class KthSmallestSumInTwoSortedArrays1 {
    public int kthSum(int[] a, int[] b, int k) {
        // Write your solution here
        //using greedy algorithm here
        if(a == null || b == null || k == 0){
            return -1;
        }

        //MaxHeap
        // PriorityQueue<pair> pq = new PriorityQueue<>((x1, x2) -> x2.sum - x1.sum);
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            public int compare(Pair x1, Pair x2){
                if(x1.sum == x2.sum){
                    return 0;
                }
                return x1.sum > x2.sum ? -1 : 1;
            }
        });
        int n = a.length;
        int m = b.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                Pair cur = new Pair(a[i], b[j], a[i] + b[j]);
                if(pq.size() < k){
                    pq.offer(cur);
                } else {
                    if(cur.sum < pq.peek().sum){
                        pq.poll();
                        pq.offer(cur);
                    }else break;
                }
            }
        }

//        while(pq.size() > k){
//            pq.poll();
//        }
        Pair result = pq.peek();

        return result.sum;
    }

    class Pair{
        int fir, sec, sum;
        Pair(int i, int j, int s){
            fir = i;
            sec = j;
            sum = s;
        }
    }
}



class KthSmallestSumInTwoSortedArrays2 {
    public int kthSum(int[] a, int[] b, int k) {
        // Write your solution here


        //minHeap
        // PriorityQueue<pair> pq = new PriorityQueue<>((x1, x2) -> x1.sum - x2.sum);
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            public int compare(Pair x1, Pair x2){
                if (x1.sum == x2.sum){
                    return 0;
                }
                return x1.sum > x2.sum ? 1 : -1;
            }
        });
        int m = a.length;
        int n = b.length;
        for (int i = 0; i < n && i < k; i++){
            pq.offer(new Pair(0, i, a[0] + b[i]));
        }
        while (k != 1 && !pq.isEmpty()){
            Pair cur = pq.poll();
            k--;
            if(cur == null || cur.row == m -1){
                continue;
            }
            pq.offer(new Pair(cur.row + 1, cur.col, (a[cur.row + 1] + b[cur.col])));
        }
        return pq.peek().sum;

    }

    class Pair{
        int row, col, sum;
        Pair(int i, int j, int s){
            row = i;
            col= j;
            sum = s;
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5};
        int[] b = new int[]{4, 8};
        int k = 5;
        KthSmallestSumInTwoSortedArrays2 test = new KthSmallestSumInTwoSortedArrays2();
        int result = test.kthSum(a, b, k);
        System.out.println(result);
    }
}


class KthSmallestSumInTwoSortedArrays3 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        /*二分查找第 k 小的数对和的大小*/
        int left = nums1[0] + nums2[0];
        int right = nums1[m - 1] + nums2[n - 1];
        int pairSum = right;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long cnt = 0;
            int start = 0;
            int end = n - 1;
            while (start < m && end >= 0) {
                if (nums1[start] + nums2[end] > mid) {
                    end--;
                } else {
                    cnt += end + 1;
                    start++;
                }
            }
            if (cnt < k) {
                left = mid + 1;
            } else {
                pairSum = mid;
                right = mid - 1;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        int pos = n - 1;
        /*找到小于目标值 pairSum 的数对*/
        for (int i = 0; i < m; i++) {
            while (pos >= 0 && nums1[i] + nums2[pos] >= pairSum) {
                pos--;
            }
            for (int j = 0; j <= pos && k > 0; j++, k--) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[i]);
                list.add(nums2[j]);
                ans.add(list);
            }
        }

        /*找到等于目标值 pairSum 的数对*/
        pos = n - 1;
        for (int i = 0; i < m && k > 0; i++) {
            while (pos >= 0 && nums1[i] + nums2[pos] > pairSum) {
                pos--;
            }
            for (int j = i; k > 0 && j >= 0 && nums1[j] + nums2[pos] == pairSum; j--, k--) {
                List<Integer> list = new ArrayList<>();
                list.add(nums1[j]);
                list.add(nums2[pos]);
                ans.add(list);
            }
        }
        return ans;
    }
}



