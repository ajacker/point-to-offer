import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ajacker
 * @date 2019/10/26 15:52
 * @see <a href="滑动窗口中的最大值">https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788</a>
 */
public class question_64 {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> arrayList = maxInWindows(array, 3);
        arrayList.forEach(System.out::println);
    }

    static ArrayList<Integer> maxInWindows(int[] num, int size) {
        return size == 0 ? new ArrayList<>() : (ArrayList<Integer>) IntStream.rangeClosed(0, num.length - size)
                .map(i -> Arrays.stream(num)
                        .skip(i).limit(size).max().getAsInt())
                .boxed().collect(Collectors.toList());
    }
}
