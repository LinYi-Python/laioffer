package practice;

import java.sql.PreparedStatement;

public class LowestCommonAncestor127 {
}


class TreeNodeP {
   public int key;
   public TreeNodeP left;
   public TreeNodeP right;
   public TreeNodeP parent;
   public TreeNodeP(int key, TreeNodeP parent) {
     this.key = key;
     this.parent = parent;
   }
 }

class LowestCommonAncestor127A {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        // Write your solution here.
        if (one == null || two == null){
            return null;
        }
        int d1 = findDepth(one);
        int d2 = findDepth(two);

        if(d1 >= d2){
            TreeNodeP result = findLCA(one, two, d1 - d2);
            return result;
        }else {
            TreeNodeP result = findLCA(two, one, d2 - d1);
            return result;
        }

    }

    private int findDepth(TreeNodeP node){
        int length = 0;
        while(node != null){
            node = node.parent;
            length++;
        }
        return length;
    }

    private TreeNodeP findLCA(TreeNodeP lower, TreeNodeP higher, int diff){
        while(diff > 0){
            lower = lower.parent;
            diff--;
        }
        while(lower != higher){
            lower = lower.parent;
            higher = higher.parent;
        }
        return lower;
    }

}