package gorgeous.algorithm.common;

public class ArrayList<T extends Comparable<T>> {

    private T[] data;
    private int size;

    public ArrayList(int capacity) {
        this.data = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    public void addFirst(T value) {
        this.add(0, value);
    }

    public void addLast(T value) {
        this.add(this.size, value);
    }

    public void add(int index, T value) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (this.size >= this.data.length) {
            resize(this.data.length * 2);
        }
        for (int i = this.size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = value;
        this.size++;
    }

    public void removeFirst() {
        this.remove(0);
    }

    public void removeLast() {
        this.remove(this.size - 1);
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[this.size - 1] = null;
        this.size--;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        this.data[index] = value;
    }

    public T getFirst() {
        return this.get(0);
    }

    public T getLast() {
        return this.get(this.size - 1);
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return this.data[index];
    }

    public int indexOf(T value) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void resize(int capacity) {
        T[] newData = (T[]) new Comparable[capacity];
        System.arraycopy(this.data, 0, newData, 0, this.size);
        this.data = newData;
    }
}
