import java.util.Stack;

/**
 * @author ajacker
 * @date 2019/10/21 19:17
 * @see <a href="栈的压入、弹出序列">https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106</a>
 */
public class question_21 {
    public static void main(String[] args) {
        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] pop = new int[]{4, 5, 3, 2, 1};
        int[] popA = new int[]{4, 3, 5, 1, 2};
        int[] popB = new int[]{4, 5, 3, 1, 2};
        System.out.println(IsPopOrder(push, popB));
    }

    static boolean IsPopOrder(int[] pushA, int[] popA) {
        //模拟入栈
        Stack<Integer> stack = new Stack<>();
        //p控制入栈序号
        int p = 0;
        for (int value : popA) {
            //如果可能的话入栈直到栈顶和出栈序列相同
            while (p < pushA.length && (stack.isEmpty() || stack.peek() != value)) {
                stack.push(pushA[p++]);
            }
            //如果出现出栈序列的值和模拟栈出栈情况不同，代表是非法序列
            if (stack.pop() != value) {
                return false;
            }
        }
        //经历层层考验，代表所有出栈序列都得到了验证
        return true;
    }
}
