import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ajacker
 * @date 2019/10/25 0:25
 * @see <a href="翻转单词顺序列">https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3</a>
 */
public class question_44 {
    public static void main(String[] args) {
        System.out.println(ReverseSentence("student. am I"));
    }

    static String ReverseSentence(String str) {
        String[] words = str.split(" ");
        if (words.length == 0) {
            return str;
        }
        List<String> list = Arrays.stream(words).collect(Collectors.toList());
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
