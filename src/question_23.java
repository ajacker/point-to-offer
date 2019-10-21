import java.util.Arrays;

/**
 * @author ajacker
 * @date 2019/10/21 21:46
 * @see <a href="二叉搜索树的后序遍历序列">https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd</a>
 */
public class question_23 {
    public static void main(String[] args) {
        int[] sequence = new int[]{3, 2, 1, 5, 7, 6, 8, 4};
        System.out.println(VerifySquenceOfBST(sequence));
    }

    static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length < 1) {
            return false;
        }
        int root = sequence[sequence.length - 1];
        //找左右子树的节点总数
        int lcount = 0, rcount = 0;
        boolean inLeft = true;
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] < root) {
                if (!inLeft) {
                    //如果在右子树部分出现比根大的，这就不是一个二叉搜索树
                    return false;
                }
                lcount++;
            } else {
                //当遇到一个比根节点大的，后面的应该都比根节点大（右子树部分）
                inLeft = false;
                rcount++;
            }
        }
        //组建左右子树的后序遍历序列
        int[] lsequence = Arrays.copyOfRange(sequence, 0, lcount);
        int[] rsequence = Arrays.copyOfRange(sequence, lcount, lcount + rcount);
        boolean flag = true;
        //如果长度小于等于1，没必要判断
        if (lsequence.length >= 2) {
            flag = VerifySquenceOfBST(lsequence);
        }
        if (rsequence.length >= 2) {
            flag &= VerifySquenceOfBST(rsequence);
        }
        return flag;
    }
}
