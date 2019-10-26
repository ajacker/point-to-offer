import java.util.ArrayList;

/**
 * @author ajacker
 * @date 2019/10/26 11:25
 * @see <a href="把二叉树打印成多行">https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288</a>
 */
public class question_60 {
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
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        ArrayList<ArrayList<Integer>> lists = Print(t0);
        lists.forEach(System.out::println);
    }

    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        getList(pRoot, result, 1);
        return result;
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
        result.get(depth - 1).add(pRoot.val);
        if (pRoot.left != null) {
            getList(pRoot.left, result, depth + 1);
        }
        if (pRoot.right != null) {
            getList(pRoot.right, result, depth + 1);
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
