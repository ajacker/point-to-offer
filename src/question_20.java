import java.util.Stack;

/**
 * @author ajacker
 * @date 2019/10/21 18:44
 * @see <a href="包含min函数的栈">https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49</a>
 */
public class question_20 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(4);
        myStack.push(9);
        myStack.push(2);
        myStack.push(2);
        System.out.println(myStack.min());
        myStack.push(6);
        System.out.println(myStack.top());
    }

    static class MyStack {
        Stack<Integer> data = new Stack<>();
        Stack<Integer> min = new Stack<>();

        public void push(int node) {
            data.push(node);
            if (min.isEmpty() || min.peek() >= node) {
                min.push(node);
            }
        }

        public void pop() {
            int value = data.pop();
            if (!min.isEmpty() && min.peek() == value) {
                min.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
