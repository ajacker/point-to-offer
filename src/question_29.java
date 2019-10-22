import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author ajacker
 * @date 2019/10/22 23:21
 * @see <a href="最小的K个数">https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf</a>
 */
public class question_29 {
    public static void main(String[] args) {
        int[] ints = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        System.out.println(GetLeastNumbers_Solution(ints, k));
    }

    /**
     * 利用stream api实现
     *
     * @param input
     * @param k
     * @return
     */
    static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        return k > input.length ? new ArrayList<>() : (ArrayList<Integer>) Arrays.stream(input).sorted().limit(k).boxed().collect(Collectors.toList());
    }
}
