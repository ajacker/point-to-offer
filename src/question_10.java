/**
 * @author ajacker
 * @date 2019/10/20 19:53
 * @see <a href="矩形覆盖">https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6</a>
 */
public class question_10 {
    public static void main(String[] args) {
        long s1 = System.nanoTime();
        System.out.println(RectCover(39));
        long s2 = System.nanoTime();
        System.out.println(RectCover(39, 1, 2));
        long s3 = System.nanoTime();
        System.out.println(cover(39));
        long s4 = System.nanoTime();
        System.out.println("普通递归：" + (s2 - s1) / 1000000f + "ms");
        System.out.println("尾递归：\t" + (s3 - s2) / 1000000f + "ms");
        System.out.println("循环：\t" + (s4 - s3) / 1000000f + "ms");
    }

    /**
     * 递归算法
     * 每个问题都可拆解成子问题f(n-2)+f(n-1):第一个横着放(占2列)+第一个竖着放（占1列）
     *
     * @param n 2*n的目标矩形
     * @return 方法数
     */
    static int RectCover(int n) {
        if (n <= 2) {
            return n;
        }
        return RectCover(n - 1) + RectCover(n - 2);
    }

    /**
     * 尾递归算法
     *
     * @param n   次数
     * @param foo 上上次运算的结果（相当于 f(n-2)）
     * @param bar 上次运算的结果（相当于 f(n-1)）
     * @return 第n项
     */
    static int RectCover(int n, int foo, int bar) {
        if (n == 1) {
            return foo;
        } else if (n == 2) {
            return bar;
        }
        return RectCover(n - 1, bar, foo + bar);
    }

    /**
     * 循环算法
     *
     * @param n 次数
     * @return 第n项
     */
    static int cover(int n) {
        if (n <= 2) {
            return n;
        } else {
            int prevv = 1;
            int prev = 2;
            for (int i = 0; i < n - 2; i++) {
                int cur = prevv + prev;
                prevv = prev;
                prev = cur;
            }
            return prev;
        }
    }
}