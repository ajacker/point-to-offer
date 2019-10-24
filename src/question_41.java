import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ajacker
 * @date 2019/10/24 23:09
 * @see <a href="和为S的连续正整数序列">https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe</a>
 */
public class question_41 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(100);
        arrayLists.forEach(System.out::println);
    }

    static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //尝试从1到一半开始，因为大于一半不可能出现连续序列
        for (int start = 1; start <= sum / 2; start++) {
            int i = start;
            int curSum = 0;
            while (curSum < sum) {
                curSum += i++;
            }
            if (curSum == sum) {
                //生成从[start,i)的序列，i这时刚好到连续数的末尾的后一个
                result.add((ArrayList<Integer>) IntStream.range(start, i).boxed().collect(Collectors.toList()));
            }
        }
        return result;
    }
}
