import java.util.Arrays;

/**
 * @author ajacker
 * @date 2019/10/26 16:12
 * @see <a href="矩阵中的路径">https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc</a>
 */
public class question_65 {
    /**
     * 方向数组，方便遍历上下左右
     */
    static int[][] dirs = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) {
        char[] matrix = {'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G',
                'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q',
                'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E',
                'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M',
                'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'};
        System.out.println(hasPath(matrix, 5, 8, "SGGFIECVAASABCEHJIGQEM".toCharArray()));
    }

    static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (str.length == 0) {
            return true;
        }
        boolean result = false;
        char first = str[0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char cur = matrix[i * cols + j];
                if (cur == first) {
                    //找到不同的开始点，只要能从任何一个开始找到路径，那么就找到了
                    //这里复制数组因为可能其它开始点修改了数组（我用来标记访问过的’\0‘）
                    result = result || movePath(Arrays.copyOf(matrix, matrix.length), rows, cols, i, j, str);
                }
            }
        }
        return result;
    }

    /**
     * 递归从某个点开始查找路径
     *
     * @param matrix 矩阵
     * @param rows   行数
     * @param cols   列数
     * @param i      开始点行index（中间点）
     * @param j      开始点列index（中间点）
     * @param str    剩余需要匹配的路径
     * @return 是否匹配
     */
    static boolean movePath(char[] matrix, int rows, int cols, int i, int j, char[] str) {
        char first = str[0];
        char cur = matrix[i * cols + j];
        if (cur != first) {
            //如果遇到字符不匹配，返回false
            return false;
        } else if (str.length == 1) {
            //如果最后一个字符匹配成功则成功了
            return true;
        }
        //标记访问过了（'\0'不等于任何一个字符，也可以换别的）
        matrix[i * cols + j] = '\0';
        //因为走到这一步肯定匹配了第一个字符，那么剩下要匹配的是除了第一个字外的字符
        char[] newStr = Arrays.copyOfRange(str, 1, str.length);
        //记录结果的
        boolean result = false;
        for (int t = 0; t < 4; t++) {
            //尝试走四个方向，得到下一个点
            int newI = i + dirs[t][0];
            int newJ = j + dirs[t][1];
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols) {
                //如果下一个点在范围内，尝试从骗一个点匹配剩余字符，这里用逻辑或，只要有一个匹配成功则成功
                result = result || movePath(matrix, rows, cols, newI, newJ, newStr);
            }
        }
        return result;
    }
}
