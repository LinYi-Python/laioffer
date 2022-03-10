package practice;

/**
 * @ClassName TwoSubsetsWithMinDifference263
 * @Description TODO
 * @Author LinPython
 * @Date 3/1/22 18:19
 * @Version 1.0
 **/
public class TwoSubsetsWithMinDifference263 {

}

class TwoSubsetsWithMinDifference263A {
    public int minDifference(int[] array) {
        if (array == null) {
            return 0;
        }
        int[] dif = new int[1];
        dif[0] = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length / 2) {
                left += array[i];
            }else {
                right += array[i];
            }
        }
        helper(array, 0, dif, left, right);
        return dif[0];
    }
    private void helper(int[] array, int index, int[] dif, int left, int right) {
//        if (right == left) {
//            dif[0] = 0;
//            return;
//        }
        if (index > array.length / 2) {
            return;
        }
        if (right == left) {
            dif[0] = 0;
            return;
        }
        dif[0] = Math.min(dif[0], Math.abs(right - left));
        for (int i = array.length / 2; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, dif, left + array[index] - array[i], right + array[i] - array[index]);
            swap(array, index, i);
        }
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        TwoSubsetsWithMinDifference263A test = new TwoSubsetsWithMinDifference263A();
        int[] array = new int[]{3, 8, 0 ,0, 0};
//        int[] array = new int[]{2, 9, 3 ,1, 1};
        int result = test.minDifference(array);
        System.out.println(result);
    }
}
