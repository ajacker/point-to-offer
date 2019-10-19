/**
 * @author ajacker
 * @see <a href="二维数组中的查找">https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e</a>
 */
public class question_01 {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        int target = 3;
        System.out.println(Find(target, array));
    }
    static boolean Find(int target, int[][] array) {
        //从数组右上角开始查找，因为特点是左侧都比它小，下侧都比他大
        int i = 0;
        int j = array[0].length - 1;
        //保证i，j在合法的范围
        while (i>=0 && i < array.length && j>=0 && j < array[i].length) {
            int cur = array[i][j];
            if (target == cur) {
                return true;
            } else if (target > cur) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}
