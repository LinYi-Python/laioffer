package practice;

import java.util.ArrayList;
import java.util.List;

public class MergeSort1 {

    public List<Integer> mergeSort(List<Integer> array){
        if(array == null){
            return array;
        }
        return mergeSort(array, 0, array.size() - 1);
    }

    private List<Integer> mergeSort(List<Integer> array, int left, int right){
        List<Integer> result = new ArrayList<Integer>();
        if(left == right){
            result.add(array.get(left));
            return result;
        }
        int mid = (right - left) / 2 + left;
        List<Integer> reLeft = mergeSort(array, left, mid);
        List<Integer> reRight = mergeSort(array, mid + 1, right);
        merge(reLeft, reRight, result);
        return result;
    }

    private void merge(List<Integer> left, List<Integer> right, List<Integer> result){
        int l = 0;
        int r = 0;
        while (l < left.size() && r < right.size()){
            if(left.get(l) <= right.get(r)){
                result.add(left.get(l));
                l++;
            }else{
                result.add(right.get(r));
                r++;
            }
        }
        while (l < left.size()){
            result.add(left.get(l));
            l++;
        }
        while ((r < right.size())){
            result.add(right.get(r));
            r++;
        }
    }

    public static void main(String[] args) {

    }

}


