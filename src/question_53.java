/**
 * @author ajacker
 * @date 2019/10/25 22:37
 * @see <a href="表示数值的字符串">https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2</a>
 */
public class question_53 {
    public static void main(String[] args) {
        char[] chars = "12e+4.3".toCharArray();
        System.out.println(isNumeric(chars));
    }

    /**
     * 1. +-号后面必定为数字或.
     * 2. +-号只出现在第一位或e/E的后一位
     * 3. .后面必定为数字 或为最后一位（233. = 233.0）
     * 4. eE后面必定为数字或+-号
     * 5. e/E之后不会出现小数
     *
     * @param str
     * @return
     */
    static boolean isNumeric(char[] str) {
        // 标志小数点和指数
        boolean point = false, exp = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                // +-号后面必定为数字 或 后面为.（-.123 = -0.123）
                if (i + 1 == str.length || !(str[i + 1] >= '0' && str[i + 1] <= '9' || str[i + 1] == '.')) {
                    return false;
                }
                // +-号只出现在第一位或eE的后一位
                if (!(i == 0 || str[i - 1] == 'e' || str[i - 1] == 'E')) {
                    return false;
                }
            } else if (str[i] == '.') {
                // .后面必定为数字 或为最后一位（233. = 233.0）
                if (point || exp || !(i + 1 < str.length && str[i + 1] >= '0' && str[i + 1] <= '9')) {
                    return false;
                }
                point = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                // eE后面必定为数字或+-号
                if (exp || i + 1 == str.length || !(str[i] >= '0' && str[i + 1] <= '9' || str[i + 1] == '+' || str[i + 1] == '-')) {
                    return false;
                }
                exp = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
