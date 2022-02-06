package practice;


public class ReOrderArray197 {
    public int[] reorder(int[] array) {
        // Write your solution here
        //N1 - N 2K
        //split N1 - Nk,   Nk - N2k
        //revers second array (N2k - Nk)
        //merge one by one
        //don not forgot N2k+ 1 if odd
        if (array.length % 2 == 0){
            reorder(array, 0, array.length - 1);
        } else {
            reorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorder(int[] array, int left, int right){
        int length = right - left + 1;
        if(length <= 2){
            return;
        }
        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        reorder(array, left, left + (lmid - left) * 2 - 1);
        reorder(array, left + (lmid - left) * 2, right);
    }

    private void reverse(int[] array, int left, int right){
        while(left < right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReOrderArray197 test = new ReOrderArray197();
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] result = test.reorder(array);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            if(i != result.length - 1){
                sb.append(result[i]);
                sb.append("->");
            } else {
                sb.append(result[i]);
            }
        }
        System.out.println(sb.toString());

    }
}

//TC O(log N)
//SC O(N * log N)
