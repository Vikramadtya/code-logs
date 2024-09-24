/*
 * Question : 206. Reverse Linked List
 * Link : https://leetcode.com/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : keep track of previous node
 */

public class ReverseLinkedList {
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

    public ListNode reverseList(ListNode head) {

        if (head == null)
            return head;

        ListNode previous = null;

        while (head.next != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = previous;
            previous = temp;
        }

        head.next = previous;

        return head;
    }
}
