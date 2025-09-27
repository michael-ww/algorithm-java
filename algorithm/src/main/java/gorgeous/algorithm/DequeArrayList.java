package gorgeous.algorithm;

import java.util.Arrays;

public class DequeArrayList<T extends Comparable<T>> {

    private T[] data;
    private int size;

    public DequeArrayList(int capacity) {
        this.data = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    public void pushFront(T value) {
        if (this.size >= this.data.length) {
            resize(this.data.length * 2);
        }
        for (int i = this.size; i > 0; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[0] = value;
        this.size++;
    }

    public void pushRear(T value) {
        if (this.size >= this.data.length) {
            resize(this.data.length * 2);
        }
        this.data[this.size] = value;
        this.size++;
    }

    public T popFront() {
        if (isEmpty()) {
            return null;
        }
        T value = data[0];
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return value;
    }

    public T popRear() {
        if (isEmpty()) {
            return null;
        }
        T value = data[size - 1];
        data[size - 1] = null;
        size--;
        return value;
    }

    public T peekFront() {
        if (isEmpty()) {
            return null;
        }
        return data[0];
    }

    public T peekRear() {
        if (isEmpty()) {
            return null;
        }
        return data[size - 1];
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void resize(int capacity) {
        this.data = Arrays.copyOf(this.data, capacity);
    }
}
