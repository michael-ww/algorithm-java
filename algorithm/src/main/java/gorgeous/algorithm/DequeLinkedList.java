package gorgeous.algorithm;

public class DequeLinkedList<T extends Comparable<T>> {

    private final Node<T> head;
    private final Node<T> tail;
    private int size;

    public DequeLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        this.head.setNext(tail);
        this.tail.setPrevious(head);
        this.size = 0;
    }

    public void pushFront(T value) {
        Node<T> node = new Node<>(value);
        node.setNext(head.getNext());
        node.setPrevious(head);
        head.getNext().setPrevious(node);
        head.setNext(node);
        size++;
    }

    public void pushRear(T value) {
        Node<T> node = new Node<>(value);
        node.setPrevious(tail.getPrevious());
        node.setNext(tail);
        tail.getPrevious().setNext(node);
        tail.setPrevious(node);
        size++;
    }

    public T popFront() {
        if (isEmpty()) {
            return null;
        }
        Node<T> node = head.getNext();
        head.setNext(node.getNext());
        node.getNext().setPrevious(head);
        size--;
        return node.getValue();
    }

    public T popRear() {
        if (isEmpty()) {
            return null;
        }
        Node<T> node = tail.getPrevious();
        tail.setPrevious(node.getPrevious());
        node.getPrevious().setNext(tail);
        size--;
        return node.getValue();
    }

    public T peekFront() {
        if (isEmpty()) {
            return null;
        }
        return head.getNext().getValue();
    }

    public T peekRear() {
        if (isEmpty()) {
            return null;
        }
        return tail.getPrevious().getValue();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {

        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}
