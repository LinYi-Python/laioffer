package practice;
import java.util.*;
/**
 * @ClassName TopKFrequentWords67
 * @Description TODO
 * @Author LinPython
 * @Date 2/27/22 02:13
 * @Version 1.0
 **/
public class TopKFrequentWords67 {
}


class TopKFrequentWords67A {
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        //using priorityQueue here
        //get the freque of word using hashmap<String, Integer>
        //using minHeap with size k, poll the maxone
        if(combo == null || combo.length  == 0){
            return new String[0];
        }
        Map<String, Integer> freqMap = getFreq(combo);
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                return e1.getValue() - e2.getValue();
            }
        });
        for(Map.Entry<String, Integer> entry: freqMap.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            }else if(entry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        String[] result = new String[minHeap.size()];
        for(int i = minHeap.size() - 1; i >= 0; i--){
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    private Map<String, Integer> getFreq(String[] combo){
        Map<String, Integer> freqMap = new HashMap<>();
        for(String s : combo){
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        TopKFrequentWords67A test = new TopKFrequentWords67A();
        String[] combo = {"a","a","b"};
        int k = 1;
        String[] result = test.topKFrequent(combo, k);
        System.out.println(result.toString());
    }


}
