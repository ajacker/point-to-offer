import java.util.Arrays;

/**
 * @author ajacker
 * @date 2019/10/20 10:36
 * @see <a href="重建二叉树">https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6</a>
 */
public class question_04 {
    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(treeNode);
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果,重建出该二叉树
     *
     * @param pre 前序遍历结果
     * @param in  中序遍历结果
     * @return 重建的二叉树根节点
     */
    static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //递归终止条件：检查是否为空
        if (pre.length == 0) {
            return null;
        }
        //前序遍历的第一个元素是根节点
        int root = pre[0];
        TreeNode res = new TreeNode(root);
        //先找到根节点在中序遍历中的位置
        int rootPos = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == root) {
                rootPos = i;
            }
        }
        //得到左右子树节点数
        int leftLen = rootPos;
        int rightLen = in.length - rootPos - 1;
        //以根节点分割中序遍历序列，得到左子树的中序遍历序列和右子树的中序遍历序列
        int[] leftIn = Arrays.copyOfRange(in, 0, leftLen);
        int[] rightIn = Arrays.copyOfRange(in, rootPos + 1, rootPos + 1 + rightLen);
        //根据长度分割前序遍历
        int[] leftPre = Arrays.copyOfRange(pre, 1, 1 + leftLen);
        int[] rightPre = Arrays.copyOfRange(pre, 1 + leftLen, 1 + leftLen + rightLen);
        //递归拼装左右子树
        res.left = reConstructBinaryTree(leftPre, leftIn);
        res.right = reConstructBinaryTree(rightPre, rightIn);
        //返回结果
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
