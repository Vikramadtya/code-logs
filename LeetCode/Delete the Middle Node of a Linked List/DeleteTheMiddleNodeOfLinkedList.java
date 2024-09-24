/*
 * Question : 2095. Delete the Middle Node of a Linked List
 * Link : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use a fast and slow pointer but start slow pointer 1 step late to get the node that points to middle
 */

public class DeleteTheMiddleNodeOfLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null)
            return head;

        int count = 1;
        ListNode cursor = head.next;
        ListNode middle = head;

        if (cursor == null)
            return null;

        while (cursor != null) {
            count++;
            cursor = cursor.next;
            if ((count & 1) != 1) {
                middle = middle.next;
            }
        }

        middle.next = (middle.next != null) ? middle.next.next : null;

        return head;
    }
}