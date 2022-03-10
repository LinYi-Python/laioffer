package practice;
import java.util.Arrays;
/**
 * @ClassName ArrayDeduplicationI115
 * @Description TODO
 * @Author LinPython
 * @Date 2/25/22 18:23
 * @Version 1.0
 **/
public class ArrayDeduplicationI115 {
}


class ArrayDeduplicationI115A {
    public int[] dedup(int[] array) {
        // Write your solution here
        if(array == null || array.length < 1){
            return array;
        }
        //using two pointer here
        int slow = 0;
        int fast = 1;
        int n = array.length;
        for(; fast < n; fast++){
            if(array[fast] != array[slow]){
                array[++slow] = array[fast];
            }
        }
        return Arrays.copyOf(array, slow + 1);
    }

    public static void main(String[] args) {
        ArrayDeduplicationI115A test = new ArrayDeduplicationI115A();
        int[] array = {1, 2, 2, 3, 3, 3};
        int[] result = test.dedup(array);
        System.out.println(result.toString());
    }
}
