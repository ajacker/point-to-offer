/**
 * @author ajacker
 * @date 2019/10/20 18:21
 * @see <a href="变态跳台阶">https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387</a>
 */
public class question_09 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }

    static int JumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        int[] ways = new int[target + 1];
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i <= target; i++) {
            ways[i] = 0;
            //从第一步走1阶到走i阶
            for (int j = 1; j < i; j++) {
                //第一步走j阶
                ways[i] += ways[i - j];
            }
            //这是一口气走完的情况
            ways[i]++;
        }
        return ways[target];
    }
}
//1 (1 1)
//1 (2)
//2 (1)
//3
//
//1 (1 1 1)
//1 (1 2)
//1 (2 1)
//1 (3)
//2 (1 1)
//2 (2)
//3 1
//4