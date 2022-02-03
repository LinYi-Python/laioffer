package binarySearch;

import java.util.Comparator;
import java.util.PriorityQueue;
public class Test {
	static class Cell {
	    int row;
	    int col;
	    int value;
	
	    Cell (int row, int col, int value){
	      this.row = row;
	      this.col = col;
	      this.value = value;
	    }
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
	    // Write your solution here
	    int rows = matrix.length;
	    int cols = matrix[0].length;
	    boolean visited[][] = new boolean [rows][cols];
	    PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
	      public int compare(Cell c1, Cell c2){
	        if (c1.value == c2.value){
	          return 0;
	        }
	        return c1.value < c2.value ? -1 : 1;
	      }
	    });
	    //add first cell into the queue
	    minHeap.offer(new Cell(0,0,matrix[0][0]));
	    visited[0][0] = true;
	
	    for (int i = 0; i < k-1; i++){
	      Cell cur = minHeap.poll();
	      //add neighbors into the queue
	      if (cur.row+1 < rows && !visited[cur.row+1][cur.col]){
	        minHeap.offer(new Cell(cur.row+1,cur.col,matrix[cur.row+1][cur.col]));
	        visited[cur.row+1][cur.col] = true;
	      }
	      if (cur.col+1 < cols && !visited[cur.row][cur.col+1]){
	        minHeap.offer(new Cell(cur.row,cur.col+1,matrix[cur.row][cur.col+1]));
	        visited[cur.row][cur.col+1] = true;
	      }
	    }
	    return minHeap.peek().value;
	}
	  
  public static void main(String[] args) {
		Test test = new Test();
		int matrix[][] = {{1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}};
	  	int result = test.kthSmallest(matrix, 2);
	  	System.out.println(result);
  }
}

