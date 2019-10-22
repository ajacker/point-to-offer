/**
 * @author ajacker
 * @date 2019/10/22 9:24
 * @see <a href="二叉搜索树与双向链表">https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5</a>
 */
public class question_26 {
    public static void main(String[] args) {

    }

    static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        //用数组是为了传递对象而不是引用
        TreeNode[] pLastNode = new TreeNode[1];
        //中序遍历二叉搜索树就可以得到从小往大的序列
        Convert(pRootOfTree, pLastNode);
        //中序遍历完成后，已经完成了单向链表的链接，再反向链接
        while (pLastNode[0] != null && pLastNode[0].left != null) {
            pLastNode[0] = pLastNode[0].left;
        }
        return pLastNode[0];
    }

    static void Convert(TreeNode curNode, TreeNode[] lastNode) {
        if (curNode == null) {
            return;
        }
        //中序遍历
        if (curNode.left != null) {
            Convert(curNode.left, lastNode);
        }
        //将上一个和本节点链接
        curNode.left = lastNode[0];
        if (lastNode[0] != null) {
            lastNode[0].right = curNode;
        }
        lastNode[0] = curNode;
        if (curNode.right != null) {
            Convert(curNode.right, lastNode);
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
