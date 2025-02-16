package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode206Test {

    @Test
    public void reverseList_validInput_returnHead() {
        // Arrange
        ListNode<Integer> tail = new ListNode<>(5, null);
        ListNode<Integer> fouth = new ListNode<>(4, tail);
        ListNode<Integer> third = new ListNode<>(3, fouth);
        ListNode<Integer> second = new ListNode<>(2, third);
        ListNode<Integer> head = new ListNode<>(1, second);

        // Act
        ListNode<Integer> answer = new LeetCode206().reverseList(head);

        // Assert
        Assertions.assertEquals(5, answer.getValue());
    }
}
