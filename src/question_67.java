import java.util.stream.IntStream;

/**
 * @author ajacker
 * @date 2019/10/26 17:36
 * @see <a href="剪绳子">https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8</a>
 */
public class question_67 {
    public static void main(String[] args) {
        System.out.println(cutRope(2));
    }

    /**
     * 把长度为target分成n段，每一段乘起来的最大值
     *
     * @param target 绳子长度
     * @return 乘积的最大值
     */
    static int cutRope(int target) {
        //绳子只可能分为1<n<=target段，遍历每一个分成n段的最大值，得到总体的最大值
        return IntStream.rangeClosed(2, target).map(split -> cut(target, split)).max().orElse(0);
    }

    /**
     * 得到分成split段后，每一段乘积的最大值
     * 基于知识，分的最平均就是最大的分法
     *
     * @param len   绳子长度
     * @param split 分几段
     * @return 乘积的最大值
     */
    static int cut(int len, int split) {
        int splitLen = len / split;
        if (len % split == 0) {
            return (int) Math.pow(splitLen, split);
        } else {
            return splitLen * cut(len - splitLen, split - 1);
        }
    }
}
