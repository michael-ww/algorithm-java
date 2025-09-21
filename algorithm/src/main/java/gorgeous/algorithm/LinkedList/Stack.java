package gorgeous.algorithm.LinkedList;

public class Stack<T> {

    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T data) {
        Node<T> node = new Node<>(data);
        if (this.isEmpty()) {
            this.top = node;
        } else {
            node.setNext(this.top);
            this.top = node;
        }
        this.size++;
    }

    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        T data = this.top.getData();
        this.top = this.top.getNext();
        this.size--;
        return data;
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.top.getData();
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

    }
}
