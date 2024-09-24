/*
 * Question :2130. Maximum Twin Sum of a Linked List
 * Link : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : find middle then put values in a stack or reverse the remaining linked list
 */

import java.util.Stack;

public class MaximumTwinSumOfLinkedList {
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

    public int pairSum(ListNode head) {
        int count = 0;
        ListNode cursor = head, middle = head;
        while (cursor != null) {
            count++;
            cursor = cursor.next;
            if ((count & 1) != 1)
                middle = middle.next;
        }

        Stack<Integer> stack = new Stack<>();
        while (middle != null) {
            stack.push(middle.val);
            middle = middle.next;
        }

        int max = 0;
        while (!stack.isEmpty()) {
            int twin = stack.pop();
            if (twin + head.val > max) {
                max = twin + head.val;
            }
            head = head.next;
        }

        return max;
    }
}
