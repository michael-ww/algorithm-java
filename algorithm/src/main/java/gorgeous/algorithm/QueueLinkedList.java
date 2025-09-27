package gorgeous.algorithm;

public class QueueLinkedList<T extends Comparable<T>> {

    private final Node<T> front;
    private final Node<T> rear;
    private int size;

    public QueueLinkedList() {
        this.front = new Node<>(null);
        this.rear = new Node<>(null);
        this.front.setNext(rear);
        this.rear.setPrevious(front);
        this.size = 0;
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        node.setNext(this.rear);
        node.setPrevious(this.rear.getPrevious());
        this.rear.getPrevious().setNext(node);
        this.rear.setPrevious(node);
        this.size++;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        } else {
            Node<T> node = this.front.getNext();
            this.front.setNext(node.getNext());
            node.getNext().setPrevious(this.front);
            this.size--;
            return node.getData();
        }
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
            this.previous = null;
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
