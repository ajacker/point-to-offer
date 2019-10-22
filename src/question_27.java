import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ajacker
 * @date 2019/10/22 12:51
 * @see <a href="字符串的排列">https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7</a>
 */
public class question_27 {
    public static void main(String[] args) {
        System.out.println(Permutation("abc"));
    }

    static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str.isEmpty()) {
            return result;
        }
        //这个set用作去重
        Set<String> resultSet = new HashSet<>();
        Permutation(new StringBuffer(), new StringBuffer(str), result, resultSet);
        return result;
    }

    /**
     * 递归从str中顺序选一个出来加入prefix拼接
     *
     * @param prefix    已拼接的
     * @param str       待拼接的
     * @param result    保存结果
     * @param resultSet 结果去重
     */
    static void Permutation(StringBuffer prefix, StringBuffer str, ArrayList<String> result, Set<String> resultSet) {
        //没有待拼接的就加入结果
        if (str.length() == 0) {
            //能加入集合代表无重复，才加入list
            if (resultSet.add(prefix.toString())) {
                result.add(prefix.toString());
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            Permutation(new StringBuffer(prefix).append(str.charAt(i)), new StringBuffer(str).deleteCharAt(i), result, resultSet);
        }
    }
}
