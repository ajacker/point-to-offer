import java.util.ArrayList;

/**
 * @author ajacker
 * @date 2019/10/21 17:44
 * @see <a href="顺时针打印矩阵">https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a</a>
 */
public class question_19 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        ArrayList<Integer> arrayList = printMatrix(matrix);
        System.out.println(arrayList);
    }

    static ArrayList<Integer> printMatrix(int[][] matrix) {
        //定义四个操作方向
        int[] RIGHT = new int[]{0, 1};
        int[] DOWN = new int[]{1, 0};
        int[] LEFT = new int[]{0, -1};
        int[] UP = new int[]{-1, 0};
        //定义操作顺序
        int[][] move = new int[][]{RIGHT, DOWN, LEFT, UP};
        //m控制使用哪个方向，初始值为RIGHT，在这几种操作直接循环
        int m = 0;
        //定义一个相同的矩阵用于标记是否被访问过
        int height = matrix.length;
        int length = matrix[0].length;
        boolean[][] isVisited = new boolean[height][length];
        //循环中止条件是遍历了足够的元素
        int count = 0;
        int sum = height * length;
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (count < sum) {
            int cur = matrix[i][j];
            isVisited[i][j] = true;
            result.add(cur);
            count++;
            if (!inRange(isVisited, i + move[m][0], j + move[m][1])) {
                //如果按照目前的移动方向移动，不在范围，代表需要转向了
                m = (m + 1) % 4;
            }
            //移动方向
            i += move[m][0];
            j += move[m][1];
        }
        return result;
    }

    /**
     * 判断[i][j]是否可以遍历（范围合法且未被访问过）
     *
     * @param isVisited 记录访问状态的矩阵
     * @param i         准备访问的i
     * @param j         准备访问的j
     * @return 是否
     */
    static boolean inRange(boolean[][] isVisited, int i, int j) {
        int height = isVisited.length;
        int length = isVisited[0].length;
        return i >= 0 && i < height && j >= 0 && j < length && !isVisited[i][j];
    }
}
