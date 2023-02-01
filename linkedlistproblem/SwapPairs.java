/**
 * 24
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode pre = dummyHead;
        while (pre.next != null && pre.next.next != null) {
            ListNode temp = pre.next;
            pre.next = pre.next.next;
            temp.next = pre.next.next;
            pre.next.next = temp;
            pre = temp;
        }
        return dummyHead.next;
    }
}
