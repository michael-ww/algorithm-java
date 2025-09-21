package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode2Test {

    @Test
    public void addTwoNumbers_validInput_returnHead() {
        //Arrange
        ListNode<Integer> l12 = new ListNode<>(3, null);
        ListNode<Integer> l11 = new ListNode<>(4, l12);
        ListNode<Integer> l1 = new ListNode<>(2, l11);
        ListNode<Integer> l23 = new ListNode<>(4, null);
        ListNode<Integer> l22 = new ListNode<>(6, l23);
        ListNode<Integer> l2 = new ListNode<>(5, l22);

        //Act
        ListNode<Integer> result = new LeetCode2().addTwoNumbers(l1, l2);

        //Assert
        Assertions.assertEquals(7, result.getValue());
        Assertions.assertEquals(0, result.getNext().getValue());
        Assertions.assertEquals(8, result.getNext().getNext().getValue());
        Assertions.assertNull(result.getNext().getNext().getNext());
    }
}
