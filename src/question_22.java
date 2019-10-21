import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author ajacker
 * @date 2019/10/21 20:55
 * @see <a href="从上往下打印二叉树">https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701</a>
 */
public class question_22 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(8);
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(10);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(9);
        TreeNode t6 = new TreeNode(11);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        System.out.println(PrintFromTopToBottom(t0));
    }

    static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //这就是一个广度优先遍历
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            result.add(curNode.val);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
        return result;
    }

    static public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
