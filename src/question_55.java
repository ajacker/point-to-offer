import java.util.HashMap;

/**
 * @author ajacker
 * @date 2019/10/25 23:13
 * @see <a href="链表中环的入口节点">https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4</a>
 */
public class question_55 {
    public static void main(String[] args) {
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.out.println(EntryNodeOfLoop(l0).val);
    }


    /**
     * 快慢指针
     *
     * @param pHead
     * @return
     */
    static ListNode EntryNodeOfLoop(ListNode pHead) {
        //快慢指针同时间开始走
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //快指针追上慢指针的时候，快指针肯定刚刚好比慢指针多走了1圈（可以模拟两个人跑圈）
            if (fast == slow) {
                //这个指针从phead开始走，和slow相遇的时候就是入口
                ListNode p = pHead;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }

    /**
     * 用哈希表记录是否访问过，也可以用HashSet
     *
     * @param pHead
     * @return
     */
//    static ListNode EntryNodeOfLoop(ListNode pHead) {
//        //记录当前节点是否访问过
//        HashMap<ListNode, Boolean> map = new HashMap<>();
//        ListNode p = pHead;
//        while (p != null) {
//            if (map.getOrDefault(p, false)) {
//                //如果重复访问了就是环入口
//                return p;
//            } else {
//                map.put(p, true);
//            }
//            p = p.next;
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
