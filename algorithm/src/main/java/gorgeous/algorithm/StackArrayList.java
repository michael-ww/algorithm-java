package gorgeous.algorithm;

import java.util.Arrays;

public class StackArrayList<T extends Comparable<T>> {

    private T[] data;
    private int size;

    public StackArrayList(int capacity) {
        this.data = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    public void push(T value) {
        if (this.size >= this.data.length) {
            this.resize(this.data.length * 2);
        }
        this.data[this.size++] = value;
    }

    public T pop() {
        if (this.isEmpty()) {
            return null;
        } else {
            if (this.size <= this.data.length / 4) {
                this.resize(this.data.length / 2);
            }
            return this.data[--this.size];
        }
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.data[this.size - 1];
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
