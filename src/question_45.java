import java.util.Arrays;

/**
 * @author ajacker
 * @date 2019/10/25 1:01
 * @see <a href="扑克牌顺子">https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4</a>
 */
public class question_45 {
    public static void main(String[] args) {
        int[] array = {0, 3, 2, 6, 4};
        System.out.println(isContinuous(array));
    }

    static boolean isContinuous(int[] numbers) {
        //不够5个顺不了
        if (numbers.length < 5) {
            return false;
        }
        Arrays.sort(numbers);
        //排序后非0首次的index
        int startIndex = -1;
        //大小王个数
        int zero = 0;
        int last = -1;
        for (int i = 0; i < 5; i++) {
            int number = numbers[i];
            if (number == 0) {
                zero++;
                continue;
            }
            //有两张一样的牌顺不了
            if (last == number) {
                return false;
            }
            last = number;
            startIndex = startIndex == -1 ? i : startIndex;
        }
        if (zero >= 4) {
            //有4个以上的到时候肯定能顺
            return true;
        } else {
            int start = numbers[startIndex];
            for (int i = start; i < start + 5; i++) {
                //如果不符合预期，就尝试使用大小王，zero是还剩下的大小王
                if (startIndex >= 5 || i != numbers[startIndex]) {
                    zero--;
                } else {
                    startIndex++;
                }
            }
            //如果大小王不够用就不符合
            return zero >= 0;
        }
    }
}
