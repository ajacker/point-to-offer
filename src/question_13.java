import java.util.Arrays;

/**
 * @author ajacker
 * @date 2019/10/20 21:07
 * @see <a href="调整数组顺序使奇数位于偶数前面">https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593</a>
 */
public class question_13 {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 7, 8, 11, 14, 25};
        //交换后应为5 7 11 25 4 8 14
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    static void reOrderArray(int[] array) {
        for (int p = 0, q = 0; q < array.length; q++) {
            //将奇数位一个个移动到前面
            if (array[q] % 2 == 1) {
                moveToFront(array, p++, q);
            }
        }
    }

    /**
     * 将数组中b序号的数从后往前逐步交换到a处,确保b>a
     *
     * @param array 操作数组
     * @param a     a
     * @param b     b
     */
    static void moveToFront(int[] array, int a, int b) {
        for (int i = b; i > a; i--) {
            swap(array, i, i - 1);
        }
    }

    /**
     * 将数组中a、b序号数交换
     *
     * @param array 操作数组
     * @param a     a
     * @param b     b
     */
    static void swap(int[] array, int a, int b) {
        array[a] ^= array[b];
        array[b] ^= array[a];
        array[a] ^= array[b];
    }
}
