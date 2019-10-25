/**
 * @author ajacker
 * @date 2019/10/26 0:59
 * @see <a href="删除链表中重复的节点">https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef</a>
 */
public class question_56 {
    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode res = deleteDuplication(l0);
    }

    static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //添加头节点方便统一处理
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        while (p2 != null) {
            //如果有连续的值出现
            while (p2 != null && p2.next != null && p2.val == p2.next.val) {
                int removeVal = p2.val;
                //记录要删除的值，不断删除
                while (p2 != null && p2.val == removeVal) {
                    p1.next = p2.next;
                    p2 = p1.next;
                }
            }
            //向后同时遍历
            p1 = p1.next;
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        //实际上的头是head.next
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
