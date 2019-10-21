import java.util.ArrayList;

/**
 * @author ajacker
 * @date 2019/10/21 22:31
 * @see <a href="二叉树中和为某一值的路径">https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd</a>
 */
public class question_24 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(8);
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(10);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(9);
        TreeNode t6 = new TreeNode(1);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        ArrayList<ArrayList<Integer>> arrayLists = FindPath(t0, 19);
        arrayLists.forEach(System.out::println);
    }

    static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        FindPath(root, target, new ArrayList<>(), result);
        return result;
    }

    static void FindPath(TreeNode root, int target, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> result) {
        cur.add(root.val);
        //叶节点
        if (root.left == null && root.right == null) {
            //满足条件的路径
            if (root.val - target == 0) {
                //复制当前cur中满足条件的路径
                result.add(new ArrayList<>(cur));
            }
        } else {
            if (root.left != null) {
                FindPath(root.left, target - root.val, cur, result);
                //递归完成后退栈，否则cur中保留的不是当前的路径
                cur.remove(cur.size() - 1);
            }
            if (root.right != null) {
                FindPath(root.right, target - root.val, cur, result);
                //递归完成后退栈，否则cur中保留的不是当前的路径
                cur.remove(cur.size() - 1);
            }
        }
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
