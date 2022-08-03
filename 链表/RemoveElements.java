public class RemoveElements {
    /**
     * 203
     * @param head 参数
     * @param val 参数
     * @return 返回值
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
