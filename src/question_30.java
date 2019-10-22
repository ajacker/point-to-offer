/**
 * @author ajacker
 * @date 2019/10/22 23:56
 * @see <a href="连续子数组的最大和">https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484</a>
 */
public class question_30 {
    public static void main(String[] args) {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(FindGreatestSumOfSubArray(array));
    }

    /**
     * 经典动态规划
     *
     * @param array 数组
     * @return 最大连续和
     */
    static int FindGreatestSumOfSubArray(int[] array) {
        //res存放了目前连续和
        int res = 0;
        //max存放出现过最大的连续和
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            //从连续和与本元素中选最好的
            res = Math.max(res + num, num);
            //更新最大值
            max = Math.max(max, res);
        }
        return max;
    }
}
