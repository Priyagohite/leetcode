/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        while (l1!=null || l2!=null)
        {
           int z =carry;
            if(l1!=null)
            {
                z+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null)
            {
                z+=l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(z%10);
            head = head.next;
            carry = z/10;
            
          }
        if(carry!=0)
          head.next = new ListNode(carry);
        return dummy.next;
        
    }
}