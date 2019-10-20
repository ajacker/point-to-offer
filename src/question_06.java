/**
 * @author ajacker
 * @date 2019/10/20 13:53
 * @see <a href="旋转数组的最小数字">https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba</a>
 */
public class question_06 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(array));
    }

    static int minNumberInRotateArray(int[] array) {
        //若数组大小为0，返回0
        if (array.length == 0) {
            return 0;
        }
        //题目所给数组的特点是先增加然后在最小处（旋转前数组的第一个）减小
        int first = array[0];
        for (int i = 1; i < array.length; i++) {
            //在遍历后续的过程中如果比首元素小，就是最小值
            if (array[i] < first) {
                return array[i];
            }
        }
        //未找到代表只有一个元素，它本身最小
        return first;
    }
}
