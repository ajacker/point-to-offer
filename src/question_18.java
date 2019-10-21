/**
 * @author ajacker
 * @date 2019/10/21 14:23
 * @see <a href="二叉树的镜像">https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011</a>
 */
public class question_18 {
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
        Mirror(t0);
    }

    static void Mirror(TreeNode root) {
        //递归中止条件
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            Mirror(root.left);
            Mirror(root.right);
            //从最底层向上逐个交换左右节点
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
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
