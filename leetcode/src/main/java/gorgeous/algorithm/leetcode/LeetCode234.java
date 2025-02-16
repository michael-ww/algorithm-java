package gorgeous.algorithm.leetcode;

import java.util.Stack;

public class LeetCode234 {

    public boolean isPalindrome1(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return true;
        }

        Stack<ListNode<Integer>> stack = new Stack<>();
        ListNode<Integer> current = head;
        while (current != null) {
            stack.push(current);
            current = current.getNext();
        }

        current = head;
        while (!stack.isEmpty()) {
            if (current != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome2(ListNode<Integer> head) {
        if (head == null) {
            return false;
        }

        ListNode<Integer> fast = head, slow = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        ListNode<Integer> end = Utility.reverse(slow.getNext());
        ListNode<Integer> left = end, right = head;
        boolean answer = true;
        while (left != null) {
            if (left.getValue().equals((right.getValue()))) {
                answer = false;
                break;
            }
            left = left.getNext();
            right = right.getNext();
        }
        slow.setNext(Utility.reverse(end));
        return answer;
    }
}
