import java.util.Stack;

/**
 * @author ajacker
 * @date 2019/10/20 21:31
 * @see <a href="链表中倒数第k个结点">https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a</a>
 */
public class question_14 {
    public static void main(String[] args) {
        //构造测试链表
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        //调试程序
        ListNode listNode = FindKthToTail(l1, 2);
        System.out.println(listNode.val);
    }

    /**
     * 得到链表倒数第k个节点
     *
     * @param head 头节点
     * @param k    k
     * @return 倒数第k个节点  如果不存在返回null
     */
    static ListNode FindKthToTail(ListNode head, int k) {
        //用栈储存遍历一次的结果
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode res = null;
        //遍历完成后弹出k个
        for (int i = 0; i < k; i++) {
            if (!stack.isEmpty()) {
                res = stack.pop();
            } else {
                return null;
            }
        }
        return res;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
