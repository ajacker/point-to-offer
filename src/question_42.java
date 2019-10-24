import java.util.ArrayList;

/**
 * @author ajacker
 * @date 2019/10/24 23:40
 * @see <a href="和为S的两个数字">https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b</a>
 */
public class question_42 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(FindNumbersWithSum(array, 3));
    }

    /**
     * 从小到大通过二分查找找到应该和他配对的数
     *
     * @param array
     * @param sum
     * @return
     */
    static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            //从当前往后查找，因为前面如果有的话肯定会先找到
            if (insertValueSearch(array, i + 1, array.length - 1, sum - num) != -1) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(num);
                result.add(sum - num);
                return result;
            }
        }
        return new ArrayList<>();
    }

    /**
     * 插值查找
     *
     * @param array  数组
     * @param left   开始
     * @param right  结束
     * @param target 目标
     * @return 索引，找不到返回-1
     */
    static int insertValueSearch(int[] array, int left, int right, int target) {
        if (left <= right && target >= array[left] && target <= array[right]) {
            int mid = left + (right - left) * (target - array[left]) / (array[right] - array[left]);
            if (target < array[mid]) {
                return insertValueSearch(array, left, mid - 1, target);
            } else if (target > array[mid]) {
                return insertValueSearch(array, mid + 1, right, target);
            } else {
                return mid;
            }
        }
        return -1;
    }
}
