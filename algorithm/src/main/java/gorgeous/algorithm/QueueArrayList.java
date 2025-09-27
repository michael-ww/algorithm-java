package gorgeous.algorithm;

import java.util.Arrays;

public class QueueArrayList<T extends Comparable<T>> {

    private T[] data;
    private int size;

    public QueueArrayList(int capacity) {
        this.data = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    public void enqueue(T value) {
        if (this.size >= this.data.length) {
            this.resize(this.data.length * 2);
        }
        this.data[this.size++] = value;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            return null;
        } else {
            if (this.size <= this.data.length / 4) {
                this.resize(this.data.length / 2);
            }
            T value = this.data[0];
            System.arraycopy(this.data, 1, this.data, 0, --this.size);
            return value;
        }
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.data[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        this.data = Arrays.copyOf(this.data, capacity);
    }
}
