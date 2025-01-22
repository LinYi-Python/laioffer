package practice;

/**
 * @ClassName Final
 * @Description TODO
 * @Author LinPython
 * @Date 3/22/22 09:35
 * @Version 1.0
 **/
public class Final {

}

//Recruiting Event Schedules
class RecruitingEventSchedules {
    private void dfs(String input, StringBuilder curr, int idx) {
        if (idx == input.length()) {
            System.out.println(curr);
            return ;
        }
        // without x
        curr.append(input.charAt(idx));
        dfs(input, curr, idx + 1);
        curr.deleteCharAt(curr.length() - 1);

        // with x
        if (curr.length() <= 0) return ;
        curr.append('x');
        curr.append(input.charAt(idx));
        dfs(input, curr, idx + 1);
        curr.deleteCharAt(curr.length() - 1);
        curr.deleteCharAt(curr.length() - 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String t1 = "ABC";
        String t2 = "A";
        String t3 = "";
        RecruitingEventSchedules sol = new RecruitingEventSchedules();
        /*
         *  ABC
            ABxC
            AxBC
            AxBxC
         */
        sol.dfs(t1, new StringBuilder(), 0);
        sol.dfs(t2, new StringBuilder(), 0); // A
        sol.dfs(t3, new StringBuilder(), 0); // ""
    }
}

//Cousins in a Binary Tree
class Cousins{
    public boolean findCusion(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == null || b == null) return false;
        boolean[] res = new boolean[]{false};
        dfs(root, a, b, 0, res);
        return res[0];
    }

    public int dfs(TreeNode root, TreeNode a, TreeNode b, int level, boolean[] res) {
        if (root == null) return -1;
        if (root == a || root == b) return level;
        int left = dfs(root.left, a, b, level + 1, res);
        int right = dfs(root.right, a, b, level + 1, res);
        if (left == right && left - level > 1) res[0] = true;
        return left == -1 ? right : left;
    }

}

//Packing Up the Swags
class PerfectNumber {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}

//Infinite Loop Around the Dinner Table
class Loop{
    public boolean canChain(String[] strArr) {
        return helper(strArr, 1);
    }

    public boolean helper(String[] strArr, int index) {
        if (index == strArr.length) return canConnect(strArr[index - 1], strArr[0]); // head -> tail
        for (int i = index; i < strArr.length; ++i) {
            if (canConnect(strArr[index - 1], strArr[i])) {
                swap(strArr, index, i);
                if (helper(strArr, index + 1)) return true;
                swap(strArr, i, index);
            }
        }
        return false;
    }

    private boolean canConnect(String s1, String s2) {
        return s1.charAt(s1.length() - 1) == s2.charAt(0);
    }
    private void swap(String[] strArr, int index, int i){
        String temp = strArr[index];
        strArr[index] = strArr[i];
        strArr[i] = temp;
    }

}



