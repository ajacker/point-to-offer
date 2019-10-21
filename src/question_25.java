import java.util.HashMap;
import java.util.Map;

/**
 * @author ajacker
 * @date 2019/10/21 23:05
 * @see <a href="复杂链表的复制">https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba</a>
 */
public class question_25 {
    public static void main(String[] args) {
        RandomListNode l0 = new RandomListNode(0);
        RandomListNode l1 = new RandomListNode(1);
        RandomListNode l2 = new RandomListNode(2);
        RandomListNode l3 = new RandomListNode(3);
        RandomListNode l4 = new RandomListNode(4);
        RandomListNode l5 = new RandomListNode(5);
        RandomListNode l6 = new RandomListNode(6);
        RandomListNode l7 = new RandomListNode(7);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l2.random = l6;
        l3.random = l0;
        l7.random = l4;
        RandomListNode clone = Clone(l0);
    }

    /**
     * 克隆复杂链表
     *
     * @param pHead 要克隆的链表头指针
     * @return 克隆结果
     */
    static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //map用于保存旧链表和新链表的对应关系
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        //先克隆完整的链表部分并建立映射
        RandomListNode result = cloneNext(pHead, map);
        //根据map克隆random部分
        cloneRandom(result, pHead, map);
        return result;
    }

    /**
     * 克隆next域
     *
     * @param pHead 要克隆的链表头指针
     * @param map   用于保存旧链表和新链表的对应关系
     * @return 克隆链表的头指针
     */
    static RandomListNode cloneNext(RandomListNode pHead, Map<RandomListNode, RandomListNode> map) {
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode p = pHead.next;
        RandomListNode q = head;
        map.put(pHead, head);
        //克隆next域并保存旧链表和新链表的对应关系
        while (p != null) {
            q.next = new RandomListNode(p.label);
            map.put(p, q.next);
            p = p.next;
            q = q.next;
        }
        return head;
    }

    static void cloneRandom(RandomListNode head, RandomListNode pHead, Map<RandomListNode, RandomListNode> map) {
        RandomListNode p = pHead;
        RandomListNode q = head;
        //利用map，使得q和q.random建立与p和p.random对应的关系（结构）
        while (p != null) {
            q.random = p.random == null ? null : map.get(p.random);
            p = p.next;
            q = q.next;
        }
    }

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
