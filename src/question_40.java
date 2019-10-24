import java.util.Arrays;

/**
 * @author ajacker
 * @date 2019/10/24 22:25
 * @see <a href="数组中只出现一次的数字">https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe</a>
 */
public class question_40 {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 8, 9, 9};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    static void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        Arrays.sort(array);
        //确保不在数组中
        int last = array[0] - 1;
        //num一开始是num1
        int[] num = num1;
        for (int i = 0; i < array.length; i++) {
            int cur = array[i];
            if (last != cur) {
                //如果这一个和上一个不一样，和下一个也不一样，或者是末尾，就是只出现一次的
                if (i + 1 >= array.length || array[i + 1] != cur) {
                    //给num1赋值了之后该给num2赋值
                    num[0] = cur;
                    //如果num2赋值完了，提前结束循环
                    if (num == num2) {
                        break;
                    }
                    num = num2;
                }
            }
            last = cur;
        }
    }
}
