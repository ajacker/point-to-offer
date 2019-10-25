/**
 * @author ajacker
 * @date 2019/10/25 10:16
 * @see <a href="孩子们的游戏（圆圈中最后剩下的数）">https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4</a>
 */
public class question_46 {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 3));
    }

    /**
     * 0到n-1的圈中每次喊到m-1出列，
     *
     * @param n n个元素
     * @param m m-1出列
     * @return 如果没有，返回-1
     */
    static int LastRemaining_Solution(int n, int m) {
        //如果没有，返回-1
        if (n <= 0) {
            return -1;
        }
        //记录小朋友是否出列
        boolean[] kids = new boolean[n];
        //报数
        int count = 0;
        //left代表还剩下几个小朋友
        int left = n;
        //current代表当前报数的小朋友
        int current = 0;
        while (left > 0) {
            //如果这个小朋友没有出列
            if (!kids[current]) {
                //如果这个小朋友是最后一个小朋友，恭喜你！
                if (left == 1) {
                    return current;
                }
                //报数报到m-1出列
                if (count == m - 1) {
                    left--;
                    kids[current] = true;
                }
                count = (count + 1) % m;
            }
            current = (current + 1) % n;
        }
        return -1;
    }
}
