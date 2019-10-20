/**
 * @author ajacker
 * @date 2019/10/20 14:19
 * @see <a href="斐波那契数列">https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3</a>
 */
public class question_07 {
    public static void main(String[] args) {
        long s1 = System.nanoTime();
        System.out.println(Fibonacci(39));
        long s2 = System.nanoTime();
        System.out.println(Fibonacci(39, 0, 1));
        long s3 = System.nanoTime();
        System.out.println(fib(39));
        long s4 = System.nanoTime();
        System.out.println("普通递归：" + (s2 - s1) / 1000000f + "ms");
        System.out.println("尾递归：\t" + (s3 - s2) / 1000000f + "ms");
        System.out.println("循环：\t" + (s4 - s3) / 1000000f + "ms");
    }

    /**
     * 普通递归算法
     *
     * @param n 次数
     * @return 第n项
     */
    static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    /**
     * 尾递归算法
     *
     * @param n   次数
     * @param foo 上上次运算的结果（相当于 f(n-2)）
     * @param bar 上次运算的结果（相当于 f(n-1)）
     * @return 第n项
     */
    static int Fibonacci(int n, int foo, int bar) {
        if (n == 0) {
            return foo;
        } else if (n == 1) {
            return bar;
        }
        return Fibonacci(n - 1, bar, foo + bar);
    }

    /**
     * 循环算法
     *
     * @param n 次数
     * @return 第n项
     */
    static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            int prevv = 0;
            int prev = 1;
            for (int i = 0; i < n - 1; i++) {
                int cur = prevv + prev;
                prevv = prev;
                prev = cur;
            }
            return prev;
        }
    }
}
