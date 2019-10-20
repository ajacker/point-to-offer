/**
 * @author ajacker
 * @date 2019/10/20 20:37
 * @see <a href="二进制中1的个数">https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8</a>
 */
public class question_11 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(-2147483648));
    }

    static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            //求得当前位
            int cur = n & 0x01;
            count += cur;
            //无符号右移
            n = n >>> 1;
        }
        return count;
    }
}
