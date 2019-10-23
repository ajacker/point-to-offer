import java.util.ArrayList;

/**
 * @author ajacker
 * @date 2019/10/23 12:06
 * @see <a href="丑数">https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b</a>
 */
public class question_33 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(20));
    }

    /**
     * 生成丑数，不超时
     * 难点：如何保证有序
     *
     * @param index
     * @return
     */
    static int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index) {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            //如果某一个被采用了，那么下次*它就拿下一个乘（同一个数不会被用来乘两次2|3|5）
            if (min == m2) {
                i2++;
            }
            if (min == m3) {
                i3++;
            }
            if (min == m5) {
                i5++;
            }
        }
        return list.get(list.size() - 1);
    }


    /**
     * 这种超时，但是可以
     * @param index
     * @return
     */
//    static int GetUglyNumber_Solution(int index) {
//        HashMap<Integer,Boolean> map = new HashMap<>();
//        map.put(1,true);
//        int count = 0;
//        int cur = 0;
//        while (count!=index){
//            cur++;
//            if(cur==1||(cur % 2 == 0 && map.getOrDefault(cur / 2,false))||
//                    (cur % 3 == 0 && map.getOrDefault(cur / 3,false))||
//                    (cur % 5 == 0 && map.getOrDefault(cur / 5,false))){
//                count++;
//                map.put(cur, true);
//            }
//        }
//        return cur;
//    }

    /**
     * 暴力法 超时
     * @param index
     * @return
     */
//    static int GetUglyNumber_Solution(int index) {
//        int count=0;
//        int i = 1;
//        for (; count < index; i++) {
//            if(isUgly(i)){
//                count++;
//            }
//        }
//        return i-1;
//    }
//    static boolean isUgly(int num){
//        while (num%2==0){
//            num/=2;
//        }
//        while (num%3==0){
//            num/=3;
//        }
//        while (num%5==0){
//            num/=5;
//        }
//        return num==1;
//    }
}
