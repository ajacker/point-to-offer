/**
 * @author ajacker
 * @date 2019/10/25 0:01
 * @see <a href="左旋转字符串">https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec</a>
 */
public class question_43 {
    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef", 9 + 3));
    }

    static String LeftRotateString(String str, int n) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        if (len == 0) {
            return "";
        }
        //p得到了循环左移n位后应该开始的index
        int p = n % len;
        StringBuilder sb = new StringBuilder();
        //拼接足够的字符（和原字符串长度相等）
        int count = 0;
        while (count++ != len) {
            //使得p走到末尾后从头开始走
            sb.append(chars[p]);
            p = (p + 1) % len;
        }
        return sb.toString();
    }
}
