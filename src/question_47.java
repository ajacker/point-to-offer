/**
 * @author ajacker
 * @date 2019/10/25 10:54
 * @see <a href="求1+2+3+...+n">https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1</a>
 */
public class question_47 {
    public static void main(String[] args) {
        long t1 = System.nanoTime();
        System.out.println(Sum_Solution(10000));
        long t2 = System.nanoTime();
        System.out.println(tailSum(10000, 0));
        long t3 = System.nanoTime();
        System.out.println("递归：" + (t2 - t1) / 1000 + "us");
        System.out.println(" 尾递归：" + (t3 - t2) / 1000 + "us");
    }

    /**
     * 求1+2+3+...+n
     * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
     * 使用逻辑短路来终止语句
     *
     * @param n n
     * @return 1+2+3+...+n
     */
    static int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n == 1) || ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    /**
     * 尾递归优化
     * 使用逻辑短路来终止语句
     *
     * @param n
     * @param sum
     * @return
     */
    static int tailSum(int n, int sum) {
        int result = sum + n;
        boolean ans = (n == 1) || ((result = tailSum(n - 1, result)) > 0);
        return result;
    }
}
