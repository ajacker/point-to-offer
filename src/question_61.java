import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ajacker
 * @date 2019/10/26 11:28
 * @see <a href="序列化二叉树">https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84</a>
 */
public class question_61 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(7);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t2.left = t5;
        t2.right = t6;
        String serialize = Serialize(t0);
        TreeNode deserialize = Deserialize(serialize);
    }

    /**
     * 将二叉树序列化为字符串
     *
     * @param root 二叉树根节点
     * @return 序列化的字符串
     */
    static String Serialize(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getList(root, result, 1);
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Integer> arrayList : result) {
            for (Integer i : arrayList) {
                sb.append(i == null ? "#" : i).append('!');
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串反序列化为二叉树
     *
     * @param str 字符串
     * @return 二叉树
     */
    static TreeNode Deserialize(String str) {
        String[] strs = str.split("!");
        //检查根节点是否为null
        if (strs[0].equals("#")) {
            return null;
        }
        //填充根节点到队列
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            //如果当前节点为空则处理队列下一个节点
            if (cur == null) {
                continue;
            }
            //添加为当前节点左右子树并添加到队列中
            if (strs[i].equals("#")) {
                cur.left = null;
            } else {
                cur.left = new TreeNode(Integer.parseInt(strs[i]));
            }
            queue.offer(cur.left);
            i++;
            if (strs[i].equals("#")) {
                cur.right = null;
            } else {
                cur.right = new TreeNode(Integer.parseInt(strs[i]));
            }
            queue.offer(cur.right);
            i++;
        }
        return root;
    }

    /**
     * 按层填充结果
     *
     * @param pRoot  根节点
     * @param result 结果list
     * @param depth  深度
     */
    static void getList(TreeNode pRoot, ArrayList<ArrayList<Integer>> result, int depth) {
        //如果深度不够就新添加
        if (result.size() < depth) {
            result.add(new ArrayList<>());
        }
        if (pRoot == null) {
            result.get(depth - 1).add(null);
            return;
        }
        result.get(depth - 1).add(pRoot.val);
        getList(pRoot.left, result, depth + 1);
        getList(pRoot.right, result, depth + 1);
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
