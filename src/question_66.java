/**
 * @author ajacker
 * @date 2019/10/26 17:10
 * @see <a href="机器人的运动范围">https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8</a>
 */
public class question_66 {
    /**
     * 方向数组，方便遍历上下左右
     */
    static int[][] dirs = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(movingCount(8, 2, 2));
    }

    /**
     * 机器人从（0，0）走能到达几个格子
     *
     * @param threshold 数位之和不能大于此
     * @param rows      行
     * @param cols      列
     * @return 能到达多少个格子
     */
    static int movingCount(int threshold, int rows, int cols) {
        //先得到能走不能走的矩阵
        boolean[][] canReach = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canReach[i][j] = getSum(i, j) <= threshold;
            }
        }
        //dfs搜索有几个能走到
        dfs(0, 0, canReach, rows, cols);
        return count;
    }

    /**
     * 深度优先搜索
     *
     * @param i        搜索点的行index
     * @param j        搜索点的列index
     * @param canReach 记录是否能够到达的二维数组
     * @param rows     行数
     * @param cols     列数
     */
    static void dfs(int i, int j, boolean[][] canReach, int rows, int cols) {
        if (canReach[i][j]) {
            count++;
            //走过了以后标记不能走了，避免它搜回去
            canReach[i][j] = false;
            //尝试上下左右走
            for (int t = 0; t < 4; t++) {
                int newI = i + dirs[t][0];
                int newJ = j + dirs[t][1];
                //如果没出界就尝试搜索
                if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols) {
                    dfs(newI, newJ, canReach, rows, cols);
                }
            }

        }
    }

    /**
     * 得到两个数字的数位之和，如25,36-》2+5+3+6=16
     *
     * @param a a
     * @param b b
     * @return 数位之和
     */
    static int getSum(int a, int b) {
        int sum = 0;
        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }
        while (b != 0) {
            sum += b % 10;
            b /= 10;
        }
        return sum;
    }

}
