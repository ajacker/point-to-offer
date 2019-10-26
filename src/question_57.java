import java.util.ArrayList;

/**
 * @author ajacker
 * @date 2019/10/26 9:37
 * @see <a href="二叉树的下一个节点">https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e</a>
 */
public class question_57 {
    public static void main(String[] args) {
        TreeLinkNode t0 = new TreeLinkNode(0);
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        TreeLinkNode t6 = new TreeLinkNode(6);
        t0.left = t1;
        t1.next = t0;
        t0.right = t2;
        t2.next = t0;
        t1.left = t3;
        t3.next = t1;
        t1.right = t4;
        t4.next = t1;
        t2.left = t5;
        t5.next = t2;
        t4.left = t6;
        t6.next = t4;
        System.out.println(GetNext(t4).val);
    }

    /**
     * 中序遍历顺序的下一个结点
     *
     * @param pNode 节点
     * @return 中序遍历顺序的下一个结点
     */
    static TreeLinkNode GetNext(TreeLinkNode pNode) {
        ArrayList<TreeLinkNode> list = new ArrayList<>();
        TreeLinkNode root = pNode;
        //找到树的根节点
        while (root.next != null) {
            root = root.next;
        }
        //得到完整的中序遍历序列
        getMid(root, list);
        //得到该节点下一个节点
        int nextIndex = list.indexOf(pNode) + 1;
        return nextIndex >= list.size() ? null : list.get(nextIndex);
    }

    /**
     * 中序遍历，并把结果顺序存入list
     *
     * @param node 根节点
     * @param list list
     */
    static void getMid(TreeLinkNode node, ArrayList<TreeLinkNode> list) {
        if (node.left != null) {
            getMid(node.left, list);
        }
        list.add(node);
        if (node.right != null) {
            getMid(node.right, list);
        }
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
