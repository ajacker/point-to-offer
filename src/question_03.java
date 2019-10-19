import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ajacker
 * @date 2019/10/20 0:13
 * @see <a href="从尾到头打印链表">https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035</a>
 */
public class question_03 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ArrayList<Integer> arrayList = printListFromTailToHead(l1);
        arrayList.forEach(System.out::println);
    }

    static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //先压入栈
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        //再全部弹出作为输出顺序
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
