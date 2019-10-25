/**
 * @author ajacker
 * @date 2019/10/25 20:58
 * @see <a href="正则表达式匹配">https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c</a>
 */
public class question_52 {
    public static void main(String[] args) {
        char[] str = "bcbbabab".toCharArray();
        char[] pattern = ".*a*a".toCharArray();
        System.out.println(match(str, pattern));
    }

    static boolean match(char[] str, char[] pattern) {
        //i是匹配串索引，p是模式串索引
        int i = 0;
        int p = 0;
        while (i < str.length) {
            char c = str[i];
            if (p >= pattern.length) {
                //如果没有模式串可用匹配剩余的匹配串，则匹配失败
                return false;
            }
            if (pattern[p] == c || pattern[p] == '.') {
                //如果模式串和与匹配串字符相等或遇到万能字符，则都前进
                i++;
                p++;
            } else {
                //如果不相等
                if (p + 1 < pattern.length && pattern[p + 1] == '*') {
                    //判断是否后面有*，如果有，则跳过2（将*视作出现0次）
                    p += 2;
                } else if (pattern[p] != '*') {
                    //如果字符不相等且也没有特殊含义（单纯的不相等），匹配失败
                    return false;
                } else {
                    //如果字符为*
                    if (pattern[p - 1] != c && pattern[p - 1] != '.') {
                        //如果*前面不是对应的字符，且*前面也不是万能字符.，那么结束匹配*字符（不再扩展）
                        p++;
                    } else {
                        //如果*前面是对应字符或者万能字符，将匹配串后移1，并设置模式串的.为对应字符
                        pattern[p - 1] = c;
                        i++;
                    }
                }
            }
        }
        //记录原先p的位置
        int prevP = p;
        //数一数有几个*
        int count = 0;
        while (p < pattern.length) {
            if (pattern[p++] == '*') {
                count++;
            }
        }
        //有几个*长度就可以-2倍的几，如果在这之后模式串小于匹配串则成功
        return prevP >= pattern.length - count * 2;
    }
}
