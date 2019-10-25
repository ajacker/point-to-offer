import java.util.OptionalInt;

/**
 * @author ajacker
 * @date 2019/10/25 22:57
 * @see <a href="字符流中第一个不重复的字符">https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720</a>
 */
public class question_54 {
    static StringBuilder stream = new StringBuilder();

    public static void main(String[] args) {
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('e');
        System.out.println(FirstAppearingOnce());
    }

    /**
     * 从字符流中读出一个字符
     *
     * @param ch 字符
     */
    static void Insert(char ch) {
        stream.append(ch);
    }

    /**
     * 返回在当前字符流中的第一个字符
     *
     * @return 第一个字符
     */
    static char FirstAppearingOnce() {
        String str = stream.toString();
        OptionalInt first = str.chars().filter(i -> str.indexOf(i) == str.lastIndexOf(i)).findFirst();
        return first.isPresent() ? ((char) first.getAsInt()) : '#';
    }
}
