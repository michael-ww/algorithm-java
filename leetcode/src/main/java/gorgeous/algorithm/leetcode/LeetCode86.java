package gorgeous.algorithm.leetcode;

public class LeetCode86 {

    public ListNode<Integer> partition(ListNode<Integer> head, int x) {
        ListNode<Integer> lessHead = new ListNode<>(null);
        ListNode<Integer> lessCurrent = lessHead;
        ListNode<Integer> moreHead = new ListNode<>(null);
        ListNode<Integer> moreCurrent = moreHead;
        while (head != null) {
            if (head.getValue().compareTo(x) >= 0) {
                moreCurrent.setNext(head);
                moreCurrent = moreCurrent.getNext();
            } else {
                lessCurrent.setNext(head);
                lessCurrent = lessCurrent.getNext();
            }
            ListNode<Integer> next = head.getNext();
            head.setNext(null);
            head = next;
        }
        lessCurrent.setNext(moreHead.getNext());
        return lessHead.getNext();
    }
}
