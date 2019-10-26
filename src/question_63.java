import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ajacker
 * @date 2019/10/26 15:23
 * @see <a href="数据流中的中位数">https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1</a>
 */
public class question_63 {
    static List<Integer> stream = new ArrayList<>();

    public static void main(String[] args) {
        Insert(5);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());
        Insert(1);
        System.out.println(GetMedian());
        Insert(6);
        System.out.println(GetMedian());
        Insert(7);
        System.out.println(GetMedian());
        Insert(0);
        System.out.println(GetMedian());
        Insert(8);
        System.out.println(GetMedian());
    }

    static void Insert(Integer num) {
        stream.add(num);
    }

    static Double GetMedian() {
        Collections.sort(stream);
        Integer[] array = stream.toArray(new Integer[0]);
        int len = array.length;
        if (len == 0) {
            return 0d;
        }
        if (len % 2 == 1) {
            return Double.valueOf(array[len / 2]);
        } else {
            return (array[len / 2 - 1] + array[len / 2]) / 2d;
        }
    }
}
