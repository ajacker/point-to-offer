import java.util.OptionalInt;

/**
 * @author ajacker
 * @date 2019/10/23 14:02
 * @see <a href="第一个只出现一次的字符">https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c</a>
 */
public class question_34 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("acbcaaddeggfaa"));
    }

    static int FirstNotRepeatingChar(String str) {
        //只出现一次的字符，从前找和从后找都是一样的index
        OptionalInt first = str.chars().filter(i -> str.indexOf(i) == str.lastIndexOf(i)).findFirst();
        return first.isPresent() ? str.indexOf(first.getAsInt()) : -1;
    }
}
