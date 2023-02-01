/**
 * 面试题 02.07. 链表相交
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int lengthA = 0, lengthB = 0;
        while (pointerA != null) {
            lengthA++;
            pointerA = pointerA.next;
        }
        while (pointerB != null) {
            lengthB++;
            pointerB = pointerB.next;
        }
        int deviation;
        pointerA = headA;
        pointerB = headB;
        if (lengthA > lengthB) {
            deviation = lengthA - lengthB;
            for (int i = 0; i < deviation; i++) {
                pointerA = pointerA.next;
            }
        } else {
            deviation = lengthB - lengthA;
            for (int i = 0; i < deviation; i++) {
                pointerB = pointerB.next;
            }
        }
        while (pointerA != null) {
            if (pointerA == pointerB) {
                break;
            }
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return pointerA;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
