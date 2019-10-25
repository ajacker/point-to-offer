/**
 * @author ajacker
 * @date 2019/10/25 16:28
 * @see <a href="把字符串转换成整数">https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e</a>
 */
public class question_49 {
    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483649"));
    }

    static int StrToInt(String str) {
        //判断正负并去掉正负号
        int flag = 1;
        if (str.startsWith("-")) {
            flag = -1;
            str = str.replaceAll("-", "");
        }
        str = str.replaceAll("\\+", "");
        if (str.isEmpty() || str.length() > 10) {
            return 0;
        }
        char[] array = str.toCharArray();
        int len = array.length - 1;
        int result = 0;
        int i = 0;
        while (len >= 0) {
            char c = array[i++];
            if (Character.isDigit(c)) {
                int value = (int) (Character.getNumericValue(c) * Math.pow(10, len--) * flag);
                if (result < 0 && result < Integer.MIN_VALUE - value) {
                    //下溢出了
                    return 0;
                }
                if (result > 0 && result > Integer.MAX_VALUE - value) {
                    //上溢出了
                    return 0;
                }
                result += value;
            } else {
                return 0;
            }
        }
        return result;
    }
}
