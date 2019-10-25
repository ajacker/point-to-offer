/**
 * @author ajacker
 * @date 2019/10/25 11:25
 * @see <a href="不用加减乘除作加法">https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1</a>
 */
public class question_48 {
    public static void main(String[] args) {
        System.out.println(Add(-2, -8));
    }

    static int Add(int num1, int num2) {
        int c = 0;
        int result = 0;
        int count = 0;
        while ((num1 != 0 || num2 != 0 || c != 0) && count < 32) {
            //分别得到两个数字的二进制最低位
            int a = num1 & 0x01;
            int b = num2 & 0x01;
            //通过位运算得到本位数字
            int cur = (c & (a ^ b ^ 1)) | ((c ^ 1) & (a ^ b));
            //通过上一个进位和两个数字的本位状态得到下一个进位信号
            c = (c & (a | b)) | ((c ^ 1) & (a & b));
            //从低往高依次填充答案的每一位
            result |= cur << count;
            //使得两个数字右移1位，下次运算高一位的结果
            num1 >>>= 1;
            num2 >>>= 1;
            //计数运算了的位数
            count++;
        }
        return result;
    }

    /**
     * 得到进位信号
     * 等价于(c & (a | b)) | ((c ^ 1) & (a & b))
     *
     * @param a 第一个数
     * @param b 第二个数
     * @param c 上一个进位信号
     * @return 新的进位信号
     */
    static int getC(int a, int b, int c) {
        if (c == 1) {
            if ((a | b) == 1) {
                return 1;
            }
        } else {
            if ((a & b) == 1) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 得到本位数字
     * 等价于(c & (a ^ b ^ 1)) | ((c ^ 1) & (a ^ b))
     *
     * @param a 第一个数
     * @param b 第二个数
     * @param c 上一个进位信号
     * @return 本位数字
     */
    static int getCur(int a, int b, int c) {
        if (c == 1) {
            if ((a ^ b) == 0) {
                return 1;
            }
        } else {
            if ((a ^ b) == 1) {
                return 1;
            }
        }
        return (c & (a ^ b ^ 1)) | ((c ^ 1) & (a ^ b));
    }
}
