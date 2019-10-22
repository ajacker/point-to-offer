import java.util.Arrays;

/**
 * @author ajacker
 * @date 2019/10/22 22:17
 * @see <a href="数组中出现次数超过一半的数字">https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163</a>
 */
public class question_28 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(ints));
    }

    /**
     * 用map记录每个数字出现的次数
     * @param array 数组
     * @return 出现超过一半的数字
     */
//    static int MoreThanHalfNum_Solution(int [] array) {
//        HashMap<Integer,Integer> map = new HashMap<>(array.length);
//        for (int i : array) {
//            map.put(i, map.getOrDefault(i, 0)+1);
//        }
//        Optional<Map.Entry<Integer, Integer>> max = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue));
//        Map.Entry<Integer, Integer> entry = max.get();
//        return entry.getValue()>array.length/2?entry.getKey():0;
//    }

    /**
     * 先排序再计数
     *
     * @param array 数组
     * @return 出现超过一半的数字
     */
    static int MoreThanHalfNum_Solution(int[] array) {
        if (array.length <= 1) {
            return array.length == 0 ? 0 : array[0];
        }
        Arrays.sort(array);
        int count = 0;
        //确保last一开始不为数组中任何一个数字
        int last = array[0] - 1;
        for (int num : array) {
            count = num == last ? count + 1 : 1;
            if (count > array.length / 2) {
                return num;
            }
            last = num;
        }
        return 0;
    }
}
