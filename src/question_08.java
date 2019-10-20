/**
 * @author ajacker
 * @date 2019/10/20 14:55
 * @see <a href="跳台阶">https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4</a>
 */
public class question_08 {
    public static void main(String[] args) {
        long s1 = System.nanoTime();
        System.out.println(JumpFloor(39));
        long s2 = System.nanoTime();
        System.out.println(JumpFloor(39, 1, 2));
        long s3 = System.nanoTime();
        System.out.println(jump(39));
        long s4 = System.nanoTime();
        System.out.println("普通递归：" + (s2 - s1) / 1000000f + "ms");
        System.out.println("尾递归：\t" + (s3 - s2) / 1000000f + "ms");
        System.out.println("循环：\t" + (s4 - s3) / 1000000f + "ms");
    }

    /**
     * 普通递归算法
     *
     * @param target 楼梯数
     * @return 方式个数
     */
    static int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        return JumpFloor(target - 2) + JumpFloor(target - 1);
    }

    /**
     * 尾递归算法
     *
     * @param n   次数
     * @param foo 上上次运算的结果（相当于 f(n-2)）
     * @param bar 上次运算的结果（相当于 f(n-1)）
     * @return 方式个数
     */
    static int JumpFloor(int n, int foo, int bar) {
        if (n == 1) {
            return foo;
        } else if (n == 2) {
            return bar;
        }
        return JumpFloor(n - 1, bar, foo + bar);
    }

    /**
     * 循环算法
     *
     * @param n 楼梯数
     * @return 方式个数
     */
    static int jump(int n) {
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
