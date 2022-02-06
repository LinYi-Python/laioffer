package practice;

import java.util.*;


class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
      this.key = key;
      this.neighbors = new ArrayList<GraphNode>();
    }
  }

public class Bipartite56 {
    public boolean isBipartite(List<GraphNode> graph) {
        // write your solution here
        Map<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
        for(GraphNode node: graph){
            if(!bfs(node, visited)){
                return false;
            }
        }
        return true;
    }

    private boolean bfs(GraphNode node, Map<GraphNode, Integer> visited){
        if(visited.containsKey(node)){
            return true;
        }

        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.offer(node);

        visited.put(node, 0);
        while(!queue.isEmpty()){
            GraphNode cur = queue.poll();
            int curGroup = visited.get(cur);

            int neiGroup = curGroup == 0? 1: 0;
            for(GraphNode nei: cur.neighbors){
                if (!visited.containsKey(nei)){
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else if (visited.get(nei) != neiGroup){
                    return false;
                }
            }
        }
        return true;
    }
}
//如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，
// 一个来自 B 集合，就将这个图称为 二分图 。