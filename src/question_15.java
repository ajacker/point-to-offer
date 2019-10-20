/**
 * @author ajacker
 * @date 2019/10/20 21:41
 * @see <a href="反转链表">https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca</a>
 */
public class question_15 {
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
        ListNode reverseList = ReverseList(l1);
    }

    /**
     * 原地反转链表
     *
     * @param head 链表头节点
     * @return 反转后的链表
     */
    static ListNode ReverseList(ListNode head) {
        //处理头节点为空或单节点的情况
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, q = p.next;
        //反转相邻两个链表的指向
        while (q != null) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        //头节点处理为尾节点
        head.next = null;
        return p;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
