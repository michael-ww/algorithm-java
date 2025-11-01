package gorgeous.algorithm.leetcode;

public class LeetCode160 {

    public ListNode<Integer> getIntersectionNode1(ListNode<Integer> headA, ListNode<Integer> headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode<Integer> loopA = this.getLoopNode(headA);
        ListNode<Integer> loopB = this.getLoopNode(headB);
        if (loopA == null && loopB == null) {
            return this.getNoLoopIntersectionNode(headA, headB);
        } else if (loopA != null && loopB != null) {
            return this.getBothLoopIntersectionNode(headA, loopA, headB, loopB);
        } else {
            return null;
        }
    }

    private ListNode<Integer> getLoopNode(ListNode<Integer> head) {
        if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
            return null;
        }

        ListNode<Integer> fast = head.getNext().getNext(), slow = head.getNext();
        while (fast != slow) {
            if (fast.getNext() == null || fast.getNext().getNext() == null) {
                return null;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        fast = head;
        while (fast != slow) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return fast;
    }

    private ListNode<Integer> getNoLoopIntersectionNode(ListNode<Integer> headA, ListNode<Integer> headB) {
        ListNode<Integer> lnA = headA;
        int nodeCount = 0;
        while (lnA.getNext() != null) {
            nodeCount++;
            lnA = lnA.getNext();
        }

        ListNode<Integer> lnB = headB;
        while (lnB.getNext() != null) {
            nodeCount--;
            lnB = lnB.getNext();
        }

        if (lnA != lnB) {
            return null;
        }

        ListNode<Integer> longlst = nodeCount > 0 ? headA : headB;
        ListNode<Integer> shortlst = longlst == headA ? headB : headA;
        nodeCount = Math.abs(nodeCount);
        while (nodeCount > 0) {
            nodeCount--;
            longlst = longlst.getNext();
        }

        while (longlst != shortlst) {
            longlst = longlst.getNext();
            shortlst = shortlst.getNext();
        }

        return longlst;
    }

    private ListNode<Integer> getBothLoopIntersectionNode(ListNode<Integer> headA, ListNode<Integer> loopA,
            ListNode<Integer> headB, ListNode<Integer> loopB) {
        if (loopA == loopB) {
            ListNode<Integer> currentA = headA;
            int nodeCount = 0;
            while (currentA != loopA) {
                nodeCount++;
                currentA = currentA.getNext();
            }
            ListNode<Integer> currentB = headB;
            while (currentB != loopB) {
                nodeCount--;
                currentB = currentB.getNext();
            }
            ListNode<Integer> longlst = nodeCount > 0 ? headA : headB;
            ListNode<Integer> shortlst = longlst == headA ? headB : headA;
            nodeCount = Math.abs(nodeCount);
            while (nodeCount > 0) {
                nodeCount--;
                longlst = longlst.getNext();
            }
            while (longlst != shortlst) {
                longlst = longlst.getNext();
                shortlst = shortlst.getNext();
            }
            return longlst;
        } else {
            ListNode<Integer> currentA = loopA.getNext();
            while (currentA != loopA) {
                if (currentA == loopB) {
                    return loopA;
                }
                currentA = currentA.getNext();
            }
            return null;
        }
    }

    public ListNode<Integer> getIntersectionNode2(ListNode<Integer> headA, ListNode<Integer> headB) {
        ListNode<Integer> currentA = headA, currentB = headB;
        while (currentA != currentB) {
            if (currentA == null) {
                currentA = headB;
            } else {
                currentA = currentA.getNext();
            }
            if (currentB == null) {
                currentB = headA;
            } else {
                currentB = currentB.getNext();
            }
        }

        return currentA;
    }
}
