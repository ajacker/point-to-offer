/**
 * @author ajacker
 * @date 2019/10/20 21:54
 * @see <a href="合并两个排序的链表">https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337</a>
 */
public class question_16 {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(6);
        ListNode p4 = new ListNode(9);
        ListNode p5 = new ListNode(14);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        ListNode q1 = new ListNode(2);
        ListNode q2 = new ListNode(5);
        ListNode q3 = new ListNode(7);
        ListNode q4 = new ListNode(13);
        ListNode q5 = new ListNode(18);
        q1.next = q2;
        q2.next = q3;
        q3.next = q4;
        q4.next = q5;
        ListNode merge = Merge(p1, q1);
    }

    /**
     * 合并两个有序链表
     *
     * @param list1 l1
     * @param list2 l2
     * @return 合并后的链表
     */
    static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p = list1, q = list2;
        //结果链表
        ListNode res = new ListNode(-1);
        //r是结果链表的尾部
        ListNode r = res;
        //公共长度部分，谁小插入谁
        while (p != null && q != null) {
            ListNode cur;
            if (p.val < q.val) {
                cur = new ListNode(p.val);
                p = p.next;
            } else {
                cur = new ListNode(q.val);
                q = q.next;
            }
            r.next = cur;
            r = r.next;
        }
        //如果有剩余，直接全部插入，两个while只会发生0或1种情况
        while (p != null) {
            r.next = p;
            r = r.next;
            p = p.next;
        }
        while (q != null) {
            r.next = q;
            r = r.next;
            q = q.next;
        }
        //res头是为了方便插入的节点，实际head为res.next
        return res.next;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
