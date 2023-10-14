class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prevGroupEnd = dummy;
        ListNode current = head;
        int count = 0;
        
        while (current != null) {
            count++;
            if (count % k == 0) {
                prevGroupEnd = reverseGroup(prevGroupEnd, current.next);
                current = prevGroupEnd.next;
            } else {
                current = current.next;
            }
        }
        
        return dummy.next;
    }
    
    private ListNode reverseGroup(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode current = last.next;
        
        while (current != next) {
            last.next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = last.next;
        }
        
        return last;
    }
}
