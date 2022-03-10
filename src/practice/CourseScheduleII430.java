package practice;
import java.util.*;
/**
 * @ClassName CourseScheduleII430
 * @Description TODO
 * @Author LinPython
 * @Date 3/9/22 21:23
 * @Version 1.0
 **/
public class CourseScheduleII430 {
}



// self-indepen
// (a, b) a and b is different
// pre array number is <= (numberCourse)  * (numberCouse - 1) / 2

//
//example:
//        (1, 0) (2, 0) (3, 1) (3, 2) (4, 3)
//
//        0 -> 1 ->3 -> 4
//        -> 2 ->
//
//        (1, 0) take 1 before take 0
//        key is prerequisite
//
//        graph
//<V, E>
//v is prerequisite class
//e is normal class
//0 <1, 2>
//        1 <3>
//        2 <3>
//        3 <4>
//
//        List<List<Integer>>
//
//
//        indegree []array
//        0: 0
//        1: 1
//        2: 1
//        3: 2
//        4: 1
//
//        use a queue with topologicalSort
//        step 1: pick courses (morn than one) with 0 indegree, put it into queue
//
//        step 2: poll , remove all edges of this course . -- indegree .find the next course with 0 indegree put it into queue
//
//        do step2 until queue is empty
//
//        whether
//
//        TC O(V + E)
//        SC O(V + E) // graph


class CourseScheduleII430A {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //preprocessing
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        //initialization
        for(int[] dependency: prerequisites) {
            int x = dependency[0];
            int y = dependency[1];
            graph.get(y).add(x);
        }

        return topologicalSort(graph, numCourses);
    }

    private int[] topologicalSort(List<List<Integer>> graph, int numCourses){
        int[] topologicalOrder = new int[numCourses]; // for our result;
        int[] indegree = new int[numCourses];

        //initialization indegree
        for(int x = 0; x < numCourses; x++){
            for(int y: graph.get(x)){
                indegree[y]++;
            }
        }

        //put 0 indegree into queue
        Deque<Integer> queue = new ArrayDeque<>();
        for(int x = 0; x < numCourses; x++) {
            if(indegree[x] == 0){
                queue.offer(x);
            }
        }

        //topologicalSort
        int numExpanded = 0;
        while(!queue.isEmpty()){
            int x = queue.poll();
            topologicalOrder[numExpanded++] = x;
            for(int y : graph.get(x)){
                if(--indegree[y] == 0){
                    queue.offer(y);
                }
            }
        }

        return numExpanded == numCourses ? topologicalOrder : new int[]{};
    }
}

