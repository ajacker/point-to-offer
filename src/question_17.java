/**
 * @author ajacker
 * @date 2019/10/20 22:12
 * @see <a href="树的子结构">https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88</a>
 */
public class question_17 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t3.left = t4;
        t3.right = t5;
        t2.right = t6;
        System.out.println(HasSubtree(t0, t0));
        System.out.println(HasSubtree(t0, t1));
        System.out.println(HasSubtree(t0, t2));
        System.out.println(HasSubtree(t0, t3));
        System.out.println(HasSubtree(t0, t4));
        System.out.println(HasSubtree(t0, t5));
        System.out.println(HasSubtree(t0, t6));
    }

    /**
     * 判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * @param root1 A
     * @param root2 B
     * @return B是不是A的子结构
     */
    static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //空树不是任意一个树的子结构
        if (root1 == null || root2 == null) {
            return false;
        }
        //看看头节点相同的情况下是否为子结构
        if (root1.val == root2.val && equalTree(root1, root2)) {
            return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    /**
     * 判断两棵树头节点相同且结构相同
     *
     * @param root1 A
     * @param root2 B
     * @return B是A的子结构且头节点相同
     */
    static boolean equalTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        //要求所有B有的结构，A也有并且值相同
        boolean flag = root1.val == root2.val;
        if (flag && root2.left != null) {
            if (root1.left == null) {
                //B有左子树，A也得有，否则结构不一致
                return false;
            }
            flag = equalTree(root1.left, root2.left);
        }
        if (flag && root2.right != null) {
            if (root1.right == null) {
                //B有右子树，A也得有，否则结构不一致
                return false;
            }
            flag = equalTree(root1.right, root2.right);
        }
        return flag;
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
