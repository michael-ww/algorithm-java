package gorgeous.algorithm;

public class StackLinkedList<T extends Comparable<T>> {

    private final Node<T> top;
    private int size;

    public StackLinkedList() {
        this.top = new Node<>(null);
        this.size = 0;
    }

    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.setNext(this.top.getNext());
        node.setPrevious(this.top);
        this.top.getNext().setPrevious(node);
        this.top.setNext(node);
        this.size++;
    }

    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        Node<T> node = this.top.getNext();
        node.getNext().setPrevious(this.top);
        this.top.setNext(node.getNext());
        this.size--;
        return node.getData();
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.top.getNext().getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> previous;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
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
