/**
 * @author ajacker
 * @date 2019/10/24 22:06
 * @see <a href="二叉树的深度">https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b</a>
 */
public class question_38 {
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
        System.out.println(TreeDepth(t0));
    }

    /**
     * 递归求树深度
     *
     * @param root 树根节点
     * @return 深度
     */
    static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        //任意一棵树的深度为左子树和右子树深度最大值+1（本节点深度）
        return Integer.max(leftDepth, rightDepth) + 1;
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
