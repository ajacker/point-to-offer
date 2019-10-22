import java.util.stream.IntStream;

/**
 * @author ajacker
 * @date 2019/10/23 0:34
 * @see <a href="整数中1出现的次数">https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6</a>
 */
public class question_31 {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }

    static int NumberOf1Between1AndN_Solution(int n) {
        return IntStream.rangeClosed(1, n).map(question_31::oneCount).sum();
    }

    /**
     * 判断一个数字中有几个1
     *
     * @param n n
     * @return n有几个1
     */
    static int oneCount(int n) {
        int count = 0;
        while (n != 0) {
            count = n % 10 == 1 ? count + 1 : count;
            n /= 10;
        }
        return count;
    }
}
