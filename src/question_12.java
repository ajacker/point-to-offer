/**
 * @author ajacker
 * @date 2019/10/20 20:46
 * @see <a href="数值的整数次方">https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00</a>
 */
public class question_12 {
    public static void main(String[] args) {
        System.out.println(Power(2, -3));
    }

    static double Power(double base, int exponent) {
        if (base == 0) {
            //0的任何次方为0
            return 0;
        } else if (exponent == 0) {
            //任何数的0次方为1
            return 1;
        }
        //处理负数幂的情况
        if (exponent < 0) {
            base = 1f / base;
            exponent = -1 * exponent;
        }
        //加速幂
        double result = 0;
        //把base的奇数次方变成，base的n-1次方*base
        if (exponent % 2 != 0) {
            result = base;
            exponent--;
        }
        //base的n次方不断变为base^2的n/2次方（加速幂）
        while (exponent / 2 >= 1) {
            base *= base;
            exponent = exponent >> 1;
        }
        return result * base;
    }
}
