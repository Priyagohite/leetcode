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
class Solution
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode tmp = head;
        int count =0;
        while(tmp!=null)
        {
            count++;
            tmp=tmp.next;
            
        }
        int steps=count-n;
        
        if(steps==0)
           return head.next;
        tmp=head;
        for(int i=1;i<steps;i++)
           tmp=tmp.next;
        tmp.next=tmp.next.next;
         
        return head;
    }
}