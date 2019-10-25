/**
 * @author ajacker
 * @date 2019/10/25 19:13
 * @see <a href="数组中重复的数字">https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8</a>
 */
public class question_50 {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        System.out.println(duplicate(array, array.length, duplication));
        System.out.println(duplication[0]);
    }

    /**
     * 找到数组中重复的数字
     *
     * @param numbers     整数数组
     * @param length      数字数组的长度
     * @param duplication （用于返回）数组中重复的数字，这个数组的长度为1，通过设置 duplication[0] = ? 来返回结果
     * @return 如果输入合法并存在重复的数，返回true，否则false
     */
    static boolean duplicate(int numbers[], int length, int[] duplication) {
        //因为出现的数只可能为0-n-1，可以弄个数组表示它是否出现过
        boolean[] appeared = new boolean[length];
        for (int i = 0; i < length; i++) {
            int num = numbers[i];
            if (!appeared[num]) {
                appeared[num] = true;
            } else {
                duplication[0] = num;
                return true;
            }
        }
        return false;
    }
}
