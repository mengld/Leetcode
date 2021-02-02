/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {

        List<Integer> list = new ArrayList<>();
        if (head != null) {
            int[] temp = reversePrint(head.next);
            for (int i = 0; i < temp.length; i++) {
                list.add(temp[i]);
            }
            list.add(head.val);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}
