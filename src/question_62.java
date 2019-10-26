/**
 * @author ajacker
 * @date 2019/10/26 15:07
 * @see <a href="二叉搜索树的第k个节点">https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a</a>
 */
public class question_62 {
    static int times = 0;

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(5);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode(3);
        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n4.left = n7;
        TreeNode x = KthNode(n0, 5);
        System.out.println(x.val);
    }

    /**
     * 找出其中的第k小的结点
     * 前序遍历到第几个就是第几小的
     *
     * @param pRoot 树根
     * @param k     k
     * @return
     */
    static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        if (pRoot.left != null) {
            TreeNode left = KthNode(pRoot.left, k);
            if (left != null) {
                return left;
            }
        }
        if (++times == k) {
            return pRoot;
        }
        if (pRoot.right != null) {
            TreeNode right = KthNode(pRoot.right, k);
            if (right != null) {
                return right;
            }
        }
        return null;
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
