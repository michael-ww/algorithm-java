package gorgeous.algorithm.common;

public class LinkedList<T> {

    private final Node<T> head;
    private final Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        this.head.setNext(tail);
        this.tail.setPrevious(head);
        this.size = 0;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.setNext(this.head.getNext());
        node.setPrevious(this.head);
        this.head.getNext().setPrevious(node);
        this.head.setNext(node);
        this.size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        node.setPrevious(this.tail.getPrevious());
        node.setNext(this.tail);
        this.tail.getPrevious().setNext(node);
        this.tail.setPrevious(node);
        this.size++;
    }

    public void removeFirst() {
        if (this.size > 0) {
            this.head.getNext().getNext().setPrevious(this.head);
            this.head.setNext(this.head.getNext().getNext());
            this.size--;
        }
    }

    public void removeLast() {
        if (this.size > 0) {
            this.tail.getPrevious().getPrevious().setNext(this.tail);
            this.tail.setPrevious(this.tail.getPrevious().getPrevious());
            this.size--;
        }
    }

    public T getFirst() {
        return this.size > 0 ? null : this.head.getNext().getValue();
    }

    public T getLast() {
        return this.size > 0 ? null : this.tail.getPrevious().getValue();
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
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
