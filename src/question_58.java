/**
 * @author ajacker
 * @date 2019/10/26 10:02
 * @see <a href="对称的二叉树">https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb</a>
 */
public class question_58 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(3);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        System.out.println(isSymmetrical(t0));
    }

    static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        //树根节点不用比较，只要左右子树的镜像遍历相同就可以
        return prevIterTogether(pRoot.left, pRoot.right);

    }

    /**
     * 校验两个树镜像遍历是否相同（是否对称）
     *
     * @param t1
     * @param t2
     * @return 是否相同
     */
    static boolean prevIterTogether(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            return t1.val == t2.val && prevIterTogether(t1.left, t2.right) && prevIterTogether(t1.right, t2.left);
        } else {
            return t1 == t2;
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
