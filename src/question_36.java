/**
 * @author ajacker
 * @date 2019/10/24 11:05
 * @see <a href="两个链表的第一个公共节点">https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46</a>
 */
public class question_36 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode m1 = new ListNode(7);
        ListNode m2 = new ListNode(8);
        ListNode m3 = l3;
        ListNode m4 = new ListNode(9);
        ListNode m5 = new ListNode(5);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        System.out.println(FindFirstCommonNode(l1, m1).val);
    }

    /**
     * 将 l1 l2拼接为l1+l2和l2+l1，使得他们的公共部分对齐（在末尾），同时遍历就可找到目标节点
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //l1走完走l2,l2走完走l1，直到找到两个相等
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }

    /**
     * 暴力！
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
//    static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        ListNode p1 = pHead1;
//        ListNode p2;
//        while (p1 != null) {
//            p2 = pHead2;
//            while (p2 != null) {
//                if (p1 == p2) {
//                    return p1;
//                }
//                p2 = p2.next;
//            }
//            p1 = p1.next;
//        }
//        return null;
//    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
