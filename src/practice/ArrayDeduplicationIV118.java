package practice;
import java.util.Arrays;
/**
 * @ClassName ArrayDeduplicationIV118
 * @Description TODO
 * @Author linPython
 * @Date 2/26/22 18:24
 * @Version 1.0
 **/
public class ArrayDeduplicationIV118 {
}


class ArrayDeduplicationIV11A {
    public int[] dedup(int[] array) {
        // Write your solution here
        int end = -1;
        for(int i = 0; i < array.length; i++){
            if(end == -1 || array[end] != array[i]){
                array[++end] = array[i];
            } else {
                while(i + 1 < array.length && array[i + 1] == array[end]){
                    i++;
                }
                end--; // keypoint, small point should be return
            }
        }
        return Arrays.copyOf(array, end + 1);
    }
}

//[0, end] sorted
//(end, i) useless
//(i, array.length - 1] unexported

// {1, 2, 3, 3, 3, 2, 2}
//     e           i

// {1, 2, 3, 3, 3, 2, 2}
//  e                 i
// O(N)
// O(1)


class ArrayDeduplicationIV11B {
    public int[] dedup(int[] array) {
        // Write your solution here
        int end = 0;  //different
        for(int i = 1; i < array.length; i++){ //different
            if(end == -1 || array[end] != array[i]){
                array[++end] = array[i];
            } else {
                end--;// keypoint, small point should be return //different
                while(i + 1 < array.length && array[i + 1] == array[i]){ //different
                    i++;
                }

            }
        }
        return Arrays.copyOf(array, end + 1);
    }
}
