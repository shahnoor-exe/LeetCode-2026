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
    public ListNode reverseList(ListNode head) {
        ListNode x=null;ListNode x1=head;
        while(x1!=null){
            ListNode x2=x1.next;
            x1.next=x;
            x=x1;
            x1=x2;
        }return x;
    }
}