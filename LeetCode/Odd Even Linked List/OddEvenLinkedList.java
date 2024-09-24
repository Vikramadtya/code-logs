/*
 * Question : 328. Odd Even Linked List
 * Link : https://leetcode.com/problems/odd-even-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use two heads to create two new list then merge them
 */

public class OddEvenLinkedList {
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

    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = null, evenTail = null, oddHead = null, oddTail = null;

        boolean isEven = false;
        while (head != null) {
            if (isEven) {
                if (evenHead == null) {
                    evenTail = head;
                    evenHead = head;
                } else {
                    evenTail.next = head;
                    evenTail = head;
                }
            } else {
                if (oddHead == null) {
                    oddTail = head;
                    oddHead = head;
                } else {
                    oddTail.next = head;
                    oddTail = head;
                }

            }
            isEven = !isEven;
            head = head.next;
        }

        if (evenTail != null)
            evenTail.next = null;
        if (oddTail != null)
            oddTail.next = evenHead;

        return oddHead;

    }
}
