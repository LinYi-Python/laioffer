package practice;

public class MergeSort9 {
    public int[] mergeSort(int[] array) {
        // Write your solution here
        if(array == null || array.length == 0){
            return array;
        }
        return mergeSort(array, 0, array.length - 1);
    }

    private int[] mergeSort(int[] array, int left, int right){

        if(left == right){
            return new int[]{array[left]};
//            result[left] = array[left];
//            return result;
        }
        int mid = (right - left) / 2 + left;
        int[] leftRes = mergeSort(array, left, mid);
        int[] rightRes = mergeSort(array, mid + 1, right);
        return merge(leftRes, rightRes);

    }

    private int[] merge(int[] left, int[] right){
        int[] result = new int[right.length + left.length];
        int l = 0;
        int r = 0;
        int i = 0;
//        for(int i = 0; i < result.length; i++){
//            if(l < left.length && r < right.length){
//                if(left[l] <= right[r]){
//                    result[i] = left[l];
//                    l++;
//                }else{
//                    result[i] = right[r];
//                    r++;
//                }
//            }
//
//            if(l < left.length){
//                result[i] = left[l];
//                l++;
//            }else if(r < right.length){
//                result[i] = right[r];
//                r++;
//            }
//        }
        while(l < left.length && r < right.length){
            if(left[l] <= right[r]){
                result[i++] = left[l++];
            }else{
                result[i++] = right[r++];
            }
        }
        while(l < left.length){
            result[i++] = left[l++];
        }

        while (r < right.length){
            result[i++] = right[r++];
        }
        return result;

    }

    public static void main(String[] args) {
        MergeSort9 test = new MergeSort9();
        int[] array = new int[]{1,2,3,4,5};
        int[] result = test.mergeSort(array);
        System.out.println(result.toString());
    }
}
