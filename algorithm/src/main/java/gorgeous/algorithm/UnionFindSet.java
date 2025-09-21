package gorgeous.algorithm;

public class UnionFindSet {

    private final int[] father;

    public UnionFindSet(int capacity) {
        this.father = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            this.father[i] = i;
        }
    }

    public int find(int x) {
        if (x != this.father[x]) {
            this.father[x] = this.find(this.father[x]);
        }
        return this.father[x];
    }

    public void union(int x, int y) {
        this.father[this.find(x)] = this.find(y);
    }
}
