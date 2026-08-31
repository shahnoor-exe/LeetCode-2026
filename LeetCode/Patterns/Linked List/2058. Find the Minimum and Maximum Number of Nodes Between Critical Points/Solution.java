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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int f=-1,l=-1,d=Integer.MAX_VALUE,i=1;
        ListNode p=head, c=head.next;
        while(c.next!=null){
            if((c.val>p.val && c.val>c.next.val)||(c.val<p.val && c.val<c.next.val)){
                if(f==-1) f=i;
                else d=Math.min(d,i-l);
                l=i;
            }
            p=c;
            c=c.next;
            i++;
        }return d==Integer.MAX_VALUE?new int[]{-1,-1}:new int[]{d,l-f};
    }
}