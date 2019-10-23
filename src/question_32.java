import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author ajacker
 * @date 2019/10/23 10:47
 * @see <a href="把数组排成更小的数">https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993</a>
 */
public class question_32 {
    public static void main(String[] args) {
        System.out.println(PrintMinNumber(new int[]{3, 32, 321}));
    }

    static String PrintMinNumber(int[] numbers) {
        //按照两个数组拼接后的大小排在前面，这样得到的就是最小的
        //例如321 21比较，32121>21321，所以21排在321前面，最后直接拼接起来就是最小的
        return Arrays.stream(numbers).boxed().sorted((a, b) -> {
            String m = String.valueOf(a);
            String n = String.valueOf(b);
            return Integer.compare(Integer.parseInt(m + n), Integer.parseInt(n + m));
        }).map(String::valueOf).collect(Collectors.joining());
    }

}
