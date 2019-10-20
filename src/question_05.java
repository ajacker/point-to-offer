import java.util.Stack;

/**
 * @author ajacker
 * @date 2019/10/20 11:52
 * @see <a href="用两个栈实现队列">https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6</a>
 */
public class question_05 {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        pop();
        push(6);
    }

    static void push(int node) {
        //插入时，先把stack2中的数据“倒”入stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        //再插入
        stack1.push(node);
    }

    static public int pop() {
        //插入时，先把stack1中的数据“倒”入stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        //再弹出
        return stack2.pop();
    }
}
