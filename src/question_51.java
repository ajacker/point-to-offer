import java.util.Arrays;

/**
 * @author ajacker
 * @date 2019/10/25 20:38
 * @see <a href="构建乘积数组">https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46</a>
 */
public class question_51 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = multiply(A);
        System.out.println(Arrays.toString(B));
    }

    static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        Arrays.fill(B, 1);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    B[i] *= A[j];
                }
            }
        }
        return B;
    }
}
