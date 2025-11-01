package gorgeous.algorithm.leetcode;

import java.util.PriorityQueue;

public class LeetCode23 {

    public ListNode<Integer> mergeKLists(ListNode<Integer>[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        PriorityQueue<ListNode<Integer>> pq = new PriorityQueue<>();
        for (ListNode<Integer> listNode : lists) {
            while (listNode != null) {
                pq.offer(listNode);
                listNode = listNode.getNext();
            }
        }

        ListNode<Integer> dummy = new ListNode<>(null);
        ListNode<Integer> current = dummy;
        while (!pq.isEmpty()) {
            current.setNext(pq.poll());
            current = current.getNext();
        }

        return dummy.getNext();
    }
}
