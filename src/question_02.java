/**
 * @author ajacker
 * @date 2019/10/19 23:10
 * @see <a href="替换空格">https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423</a>
 */
public class question_02 {
    public static void main(String[] args) {
        String s = "We Are Happy";
        StringBuffer str = new StringBuffer(s);
        System.out.println(replaceSpace(str));
    }

    static String replaceSpace(StringBuffer str) {
        int len = str.length();
        //用于替换的字符串
        String target = "%20";
        int targetLen = target.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                //替换空格以后，总长度和当前需要遍历的位置需要进行调整
                str.replace(i, i + 1, target);
                i += targetLen - 1;
                len += targetLen - 1;
            }
        }
        return str.toString();
    }
}
