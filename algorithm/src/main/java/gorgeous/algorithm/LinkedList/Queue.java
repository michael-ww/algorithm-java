package gorgeous.algorithm.LinkedList;

public class Queue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        if (this.isEmpty()) {
            this.front = node;
            this.rear = node;
        } else {
            this.rear.setNext(node);
            node.setPrevious(this.rear);
            this.rear = node;
        }
        this.size++;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        } else {
            T data = this.front.getData();
            this.front = this.front.getNext();
            if (this.front != null) {
                this.front.setPrevious(null);
            } else {
                this.rear = null;
            }
            this.size--;
            return data;
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
